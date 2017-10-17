package fr.demos.formation.septiemearche.data;

import org.apache.log4j.Logger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


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
	public Tva select(String idString) throws Exception {
		int idInt = 0;
		Tva tva = null;
		
		try {
			idInt = Integer.parseInt(idString);

		String requestString = "SELECT t FROM Tva t WHERE t.id=?";

		TypedQuery<Tva> query = em.createQuery(requestString, Tva.class);
		query.setParameter(1, idInt);

		tva = query.getSingleResult();
		
		logger.debug("objet chargé " + tva);
	}catch(NumberFormatException e	) {
		logger.error("Paramètre invalide, " + idString + " n'est pas un nombre valide");
	}
		return tva;
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
