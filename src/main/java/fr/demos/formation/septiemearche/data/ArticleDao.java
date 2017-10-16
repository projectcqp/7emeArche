package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.formation.septiemearche.metier.Article;
import fr.demos.formation.septiemearche.metier.Livre;

/**
 * @author STAGIAIRE
 *
 */

public class ArticleDao implements InterfaceDao<Article> {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Article select(String id) throws Exception {

		// TODO mettre à jour avec l'exemple sur TvaDao
		try {
			int idInt = Integer.parseInt(id);
			String requestString = "SELECT a FROM Article a WHERE a.id=?";

			TypedQuery<Article> query = em.createQuery(requestString, Article.class);
			query.setParameter(1, idInt);

			return query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("On fait le select(id) sur un int" + e);
			return null;
		}
	}

	@Override
	public List<Article> selectSearch(String criteria) throws Exception {

		Double criteriaDouble = null;
		try {
			criteriaDouble = Double.parseDouble(criteria);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Impossible de parseDouble : " + criteria + ", " + e);
		}

		String requestString = "SELECT a FROM Article a WHERE a.reference=? OR a.prixHt=? OR a.nom=? OR a.description=?";

		TypedQuery<Article> query = em.createQuery(requestString, Article.class);
		query.setParameter(1, criteria);
		query.setParameter(2, criteriaDouble);
		query.setParameter(3, criteria);
		query.setParameter(4, criteria);

		return query.getResultList();
	}

	@Override
	public List<Article> selectAll() throws Exception {

		String requestString = "SELECT a FROM Article a";

		TypedQuery<Article> query = em.createQuery(requestString, Article.class);

		return query.getResultList();
	}

	@Override
	public void insert(Article a) throws Exception {
		em.persist(a);
	}

	@Override
	public void update(Article a) throws Exception {
		em.persist(a);

	}

	@Override
	public void delete(Article a) throws Exception {
		em.remove(a);
		a.setId(0);
	}

}
