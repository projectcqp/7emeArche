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

	public int countElements() {

		String countString = em.createQuery("SELECT COUNT(*) FROM Article a").getSingleResult().toString();
		int count = 0;
		try {
			count = Integer.parseInt(countString);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return count;
	}

	public List<Article> selectSearch(String criteria) throws Exception {

		String requestString = "SELECT a FROM Article a WHERE a.reference=? OR a.nom=? OR a.description=?";

		TypedQuery<Article> query = em.createQuery(requestString, Article.class);
		query.setParameter(1, criteria);
		query.setParameter(2, criteria);
		query.setParameter(3, criteria);

		return query.getResultList();
	}

	public List<Article> selectAll() throws Exception, SQLException {

		String requestString = "SELECT a FROM Article a";

		TypedQuery<Article> query = em.createQuery(requestString, Article.class);

		return query.getResultList();
	}

	// Retourne la liste d'articles à afficher pour chaque page "paginée"
	public List<Article> select(int firstOfPage, int recordsPerPage) {

		String requestString = "SELECT a FROM Article a ORDER BY a.id ASC";

		TypedQuery<Article> query = em.createQuery(requestString, Article.class);

		query.setFirstResult(firstOfPage);
		query.setMaxResults(recordsPerPage);

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
	public void delete(Article articleDivers) throws Exception {
		em.remove(articleDivers);
		articleDivers.setId(0);
	}

}
