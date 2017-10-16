package fr.demos.formation.septiemearche.data;

import java.text.ParseException;
import org.apache.log4j.Logger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import fr.demos.formation.septiemearche.metier.Tva;

/**
 * @author STAGIAIRE
 *
 */

// On défini le type generique (entre chevrons) de l'interface implémentée
public class TvaDao implements InterfaceDao<Tva> {
	@PersistenceContext
	private EntityManager em;
	private static Logger logger = Logger.getLogger("Log");	

	@Override
	public Tva select(String id) throws Exception {
		int idInt = 0;
		Tva tva = null;
		
		try {
			idInt = Integer.parseInt(id);

		String requestString = "SELECT t FROM Tva t WHERE t.id=?";

		TypedQuery<Tva> query = em.createQuery(requestString, Tva.class);
		query.setParameter(1, idInt);

		tva = query.getSingleResult();
		
		logger.debug("objet chargé " + tva);
	}catch(NumberFormatException e	) {
		logger.error("Paramètre invalide, " + id + " n'est pas un nombre valide");
	}
		return tva;
	}

	@Override
	public List<Tva> selectSearch(String criteria) throws Exception {

		int criteriaInt = 2147483647;
		try {
			System.out.println("je parseInt");
			criteriaInt = Integer.parseInt(criteria);
		} catch (Exception e) {
			System.out.println("Impossible de ParseInt le criteria");
		}

		float criteriaFloat = 3.4028235E38f;
		try {
			System.out.println("je parseFloat");
			criteriaFloat = Float.parseFloat(criteria);
		} catch (Exception e) {
			System.out.println("Impossible de ParseFloat le criteria");
		}

		String requestString = "SELECT t FROM Tva t WHERE t.id=? OR t.taux=? OR t.libelle=?";

		TypedQuery<Tva> query = em.createQuery(requestString, Tva.class);
		query.setParameter(1, criteriaInt);
		query.setParameter(2, criteriaFloat);
		query.setParameter(3, criteria);

		return query.getResultList();
	}

	@Override
	public List<Tva> selectAll() throws Exception {
		String requestString = "SELECT t FROM Tva t";

		TypedQuery<Tva> query = em.createQuery(requestString, Tva.class);

		return query.getResultList();
	}

	@Override
	public void insert(Tva tva) throws Exception {
		em.persist(tva);
	}

	@Override
	public void update(Tva tva) throws Exception {
		em.merge(tva);
	}

	@Override
	public void delete(Tva tva) throws Exception {
		em.remove(tva);
		tva.setId(0);

	}

}
