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

// On défini le type generique (entre chevrons) de l'interface implémentée
public class TvaDao implements InterfaceDao<Tva>{
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Tva select(String id) throws Exception {
		
		int idInt = Integer.parseInt(id);
		
		String requestString = "SELECT t FROM Tva t WHERE t.id=?";
		
		TypedQuery<Tva> query =em.createQuery(requestString, Tva.class);
		query.setParameter(1, idInt);
		
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