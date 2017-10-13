package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.demos.formation.septiemearche.metier.Article;

/**
 * @author STAGIAIRE
 *
 */

public interface ArticleDao extends InterfaceDao<Article> {

	
	
	
	@Override
	public Article select(String key) throws Exception;

	@Override
	public List<Article> selectSearch(String criteria) throws Exception;

	@Override
	public List<Article> selectAll() throws Exception;

	@Override
	public void insert(Article object) throws Exception;

	@Override
	public void update(Article object) throws Exception;

	@Override
	public void delete(Article object) throws Exception;
	

}
