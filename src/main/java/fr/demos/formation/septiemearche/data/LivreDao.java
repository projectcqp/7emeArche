package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import fr.demos.formation.septiemearche.metier.Livre;

public class LivreDao implements InterfaceDao<Livre> {
	@PersistenceContext
	private EntityManager em;
	private static Logger logger = Logger.getLogger("Log");

	@Override
	public Livre select(String idString) throws Exception {
		int idInt = 0;
		Livre livre = null;
		
		try {
			idInt = Integer.parseInt(idString);
			String requestString = "SELECT l FROM Livre l WHERE l.id=?";
			
			TypedQuery<Livre> query = em.createQuery(requestString, Livre.class);
			query.setParameter(1, idInt);
			
			livre = query.getSingleResult();
		} catch(NumberFormatException e) {
			logger.error("Paramètre invalide, " + idInt + " n'est pas un nombre valide");
		}
		return livre;
	}

	public List<Livre> selectSearch(String criteria) throws Exception {
		
		String requestString = "SELECT l FROM Livre l WHERE l.auteur=? OR l.isbn=? OR l.editeur=? OR l.genre=?";

		TypedQuery<Livre> query = em.createQuery(requestString, Livre.class);
		query.setParameter(1, criteria);
		query.setParameter(2, criteria);
		query.setParameter(3, criteria);
		query.setParameter(4, criteria);
		
		return query.getResultList();
	}

	public List<Livre> selectAll() throws Exception {
		String requestString = "SELECT l FROM Livre l";

		TypedQuery<Livre> query = em.createQuery(requestString, Livre.class);

		return query.getResultList();
		// Todo filtrer les résultats en fonction du paramètre
	}

	@Override
	public void insert(Livre livre) throws Exception {
		em.persist(livre);

	}

	@Override
	public void update(Livre livre) throws Exception {
		em.persist(livre);
	}

	@Override
	public void delete(Livre livre) throws Exception {
		em.remove(livre);
		livre.setId(0);
	}

}