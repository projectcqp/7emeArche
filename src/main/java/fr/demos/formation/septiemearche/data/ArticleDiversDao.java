package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import fr.demos.formation.septiemearche.metier.Article;
import fr.demos.formation.septiemearche.metier.ArticleDivers;

public class ArticleDiversDao implements InterfaceDao<ArticleDivers> {
	@PersistenceContext
	private EntityManager em;
	private static Logger logger = Logger.getLogger("Log");

	@Override
	public ArticleDivers select(String idString) throws Exception {
		int idInt = 0;
		ArticleDivers article = null;
		try {
			idInt = Integer.parseInt(idString);

			String requestString = "SELECT ad FROM ArticleDivers ad WHERE ad.id=?";

			TypedQuery<ArticleDivers> query = em.createQuery(requestString, ArticleDivers.class);
			query.setParameter(1, idInt);

			article = query.getSingleResult();
		} catch (NumberFormatException e) {
			logger.error("Paramètre invalide, " + idInt + " n'est pas un nombre valide");
		}
		catch (NoResultException e) {
			// quand pas de résultat on retourne null
			logger.error("Pas de résultat pour cet id : " + idInt);
			return null;
		}
		return article;
	}

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