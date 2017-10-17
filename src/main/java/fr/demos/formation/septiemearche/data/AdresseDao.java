package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import fr.demos.formation.septiemearche.metier.Adresse;

public class AdresseDao implements InterfaceDao<Adresse> {
	@PersistenceContext
	private EntityManager em;
	private static Logger logger = Logger.getLogger("Log");

	@Override
	public Adresse select(String iStringd) throws Exception {

		int idInt = 0;
		Adresse adresse = null;

		try {
			idInt = Integer.parseInt(iStringd);

			String requestString = "SELECT a FROM Adresse a WHERE a.id=?";

			TypedQuery<Adresse> query = em.createQuery(requestString, Adresse.class);
			query.setParameter(1, idInt);

			adresse = query.getSingleResult();
		} catch (NumberFormatException e) {
			logger.error("Paramètre invalide, " + idInt + " n'est pas un nombre valide");
		}
		return adresse;
	}

	@Override
	public List<Adresse> selectAll() throws Exception {
		String requestString = "SELECT a FROM Adresse a";

		TypedQuery<Adresse> query = em.createQuery(requestString, Adresse.class);

		List adresses = query.getResultList();

		if (adresses.isEmpty()) {
			logger.info("La table adresse est vide.");
		}

		return adresses;
	}

	@Override
	public void insert(Adresse adresse) throws Exception {
		try {
			em.persist(adresse);
		} catch (EntityExistsException e) {
			logger.error("Une adresse existe déjà avec cette clef");
		}
	}

	@Override
	public void update(Adresse adresse) throws Exception {
		em.persist(adresse);
	}

	@Override
	public void delete(Adresse adresse) throws Exception {
		em.remove(adresse);
		adresse.setId(0);

	}

}
