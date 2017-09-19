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
		String requestString = "SELECT t FROM Tva t WHERE t.id=?";
		
		TypedQuery<Tva> query =em.createQuery(requestString, Tva.class);
		query.setParameter(0, id);
		
		return query.getSingleResult();
	}

	@Override
	public List<Tva> selectAll() throws Exception {
		String requestString = "SELECT t FROM Tva t";
		
		TypedQuery<Tva> query =em.createQuery(requestString, Tva.class);
		
		return query.getResultList();
// TODO filtrer les résultats en fonction du paramètre
	}

	@Override
	public void insert(Tva tva) throws Exception {
		em.persist(tva);
	}

	@Override
	public void update(Tva tva) throws Exception {
		em.merge(tva);
	}

	@Override
	public void delete(Tva tva) throws Exception {
		em.remove(tva);
		tva.setId(0);
		
	}
	
}