package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.formation.septiemearche.metier.Tva;

/**
 * @author STAGIAIRE
 *
 */

public class TvaDao implements InterfaceDao<Tva>{
	@PersistenceContext
	private EntityManager em;
	
//On définit le generic entre chevrons
	@Override
	public Tva select(String id) throws Exception {
		String requestString = "SELECT FROM TVA WHERE ID=?";
		
		TypedQuery<Tva> query =em.createQuery(requestString, Tva.class);
		query.setParameter(0, id);
		
		return query.getSingleResult();
	}

	@Override
	public List<Tva> selectAll(String criteria) throws Exception {
		String requestString = "SELECT FROM TVA";
		
		TypedQuery<Tva> query =em.createQuery(requestString, Tva.class);
		
		return query.getResultList();
//Todo filtrer les résultats en fonction du paramètree
	}

	@Override
	public int insert(Tva tva) throws Exception {
		em.persist(tva);
		
		return tva.getId();
	}

	@Override
	public void update(Tva tva) throws Exception {
		em.persist(tva);
	}

	@Override
	public void delete(Tva tva) throws Exception {
		em.remove(tva);
		tva.setId(0);
		
	}
	
}