package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.formation.septiemearche.metier.Livre;

public class LivreDao implements InterfaceDao<Livre> {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Livre select(String id) throws Exception {		
		
		//TODO mettre à jour avec l'exemple sur TvaDao
		try {
			int idInt = Integer.parseInt(id);
			String requestString = "SELECT l FROM Livre l WHERE l.id=?";
			
			TypedQuery<Livre> query = em.createQuery(requestString, Livre.class);
			query.setParameter(1, idInt);
			
			return query.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("On fait le select(id) sur un int" + e);
			return null;
		}
	}

	@Override
	public List<Livre> selectSearch(String criteria) throws Exception {
		
		String requestString = "SELECT l FROM Livre l WHERE l.auteur=? OR l.isbn=? OR l.editeur=? OR l.genre=?";

		TypedQuery<Livre> query = em.createQuery(requestString, Livre.class);
		query.setParameter(1, criteria);
		query.setParameter(2, criteria);
		query.setParameter(3, criteria);
		query.setParameter(4, criteria);
		
		return query.getResultList();
	}

	@Override
	public List<Livre> selectAll() throws Exception {
		String requestString = "SELECT l FROM Livre l";

		TypedQuery<Livre> query = em.createQuery(requestString, Livre.class);

		return query.getResultList();
		// Todo filtrer les résultats en fonction du paramètre
	}

	@Override
	public void insert(Livre l) throws Exception {
		em.persist(l);

	}

	@Override
	public void update(Livre l) throws Exception {
		em.persist(l);
	}

	@Override
	public void delete(Livre l) throws Exception {
		em.remove(l);
		l.setId(0);
	}

}