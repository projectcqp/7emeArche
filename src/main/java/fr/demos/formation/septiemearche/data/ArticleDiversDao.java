package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.formation.septiemearche.metier.ArticleDivers;

public class ArticleDiversDao implements InterfaceDao<ArticleDivers> {
	@PersistenceContext
	private EntityManager em;

	@Override
	public ArticleDivers select(String id) throws Exception {
		
		//TODO mettre à jour avec l'exemple sur TvaDao
		int idInt = 2147483647;
		try {
			idInt = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("On fait le select(id) sur un int" + e);
		}
				
		// on accède directement à l'id de la classe mère article avec ad.id
		String requestString = "SELECT ad FROM ArticleDivers ad WHERE ad.id=?";

		TypedQuery<ArticleDivers> query = em.createQuery(requestString, ArticleDivers.class);
		query.setParameter(1, idInt);

		return query.getSingleResult();
	}

	@Override
	public List<ArticleDivers> selectSearch(String criteria) throws Exception {
		
		String requestString = "SELECT ad FROM ArticleDivers ad WHERE ad.type=?";

		TypedQuery<ArticleDivers> query = em.createQuery(requestString, ArticleDivers.class);
		query.setParameter(1, criteria);
		
		return query.getResultList();
	}

	@Override
	public List<ArticleDivers> selectAll() throws Exception {
		String requestString = "SELECT ad FROM ArticleDivers ad";

		TypedQuery<ArticleDivers> query = em.createQuery(requestString, ArticleDivers.class);

		return query.getResultList();
		// Todo filtrer les résultats en fonction du paramètre
	}

	@Override
	public void insert(ArticleDivers ad) throws Exception {
		em.persist(ad);

	}

	@Override
	public void update(ArticleDivers ad) throws Exception {
		em.persist(ad);
	}

	@Override
	public void delete(ArticleDivers ad) throws Exception {
		em.remove(ad);
		ad.setId(0);
	}

}