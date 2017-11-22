package fr.demos.formation.septiemearche.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import fr.demos.formation.septiemearche.metier.Article;

/**
 * @author STAGIAIRE
 *
 */

public class ArticleDao implements InterfaceDao<Article> {

	@PersistenceContext
	private EntityManager em;

	private static Logger logger = Logger.getLogger("Log");

	@Override
	public Article select(String idString) throws Exception {
		int idInt = 0;
		Article article = null;

		try {
			idInt = Integer.parseInt(idString);

			String requestString = "SELECT a FROM Article a WHERE a.id=?";

			TypedQuery<Article> query = em.createQuery(requestString, Article.class);
			query.setParameter(1, idInt);

			article = query.getSingleResult();
		} catch (NumberFormatException e) {
			logger.error("Paramètre invalide, " + idString + " n'est pas un nombre valide");
		}
		return article;
	}

	

	public List<Article> selectSearch(String criteria, int firstOfPage, int recordsPerPage) {
		// Retourne la liste d'articles à afficher pour chaque page "paginée"
		TypedQuery<Article> query;
		String requestString = "";
		if (criteria==null||criteria.equals("")) {

			requestString = "SELECT a FROM Article a ORDER BY a.id ASC";
			query = em.createQuery(requestString, Article.class);
			
			

		} else {

			requestString = "SELECT a FROM Article a WHERE a.reference LIKE ? OR a.nom LIKE ? OR a.description LIKE ?";
			query = em.createQuery(requestString, Article.class);
			query.setParameter(1, "%"+criteria+"%");
			query.setParameter(2, "%"+criteria+"%");
			query.setParameter(3, "%"+criteria+"%");

		}

		query.setFirstResult(firstOfPage);
		query.setMaxResults(recordsPerPage);
		return query.getResultList();

	}

	public long countElementsSearch(String criteria) {
		TypedQuery<Long> query;
		String requestString = "";
		
		if (criteria==null||criteria.equals("")) {

			requestString = "SELECT count(*) FROM Article a";
			query = em.createQuery(requestString, Long.class);		

		} else {
			requestString=
						"SELECT COUNT(*) FROM Article a WHERE a.reference LIKE ? OR a.nom LIKE ? OR a.description LIKE ?";
			query = em.createQuery(requestString, Long.class);
		
			query.setParameter(1, "%"+criteria+"%");
			query.setParameter(2, "%"+criteria+"%");
			query.setParameter(3, "%"+criteria+"%");
		}
		Long count = query.getSingleResult();
		
		System.out.println("Count:" +count);
		return count;
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
	public void delete(Article articleDivers) throws Exception {
		em.remove(articleDivers);
		articleDivers.setId(0);
	}

}
