package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.formation.septiemearche.metier.Adresse;
import fr.demos.formation.septiemearche.metier.Tva;

public class AdresseDao implements InterfaceDao<Adresse>{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Adresse select(String id) throws Exception {
		
		int idInt = 0;
		try {
			idInt = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("On fait le select(id) sur un int" + e);
		}
		
		String requestString = "SELECT a FROM Adresse a WHERE a.id=?";

		TypedQuery<Adresse> query = em.createQuery(requestString, Adresse.class);
		query.setParameter(1, idInt);

		return query.getSingleResult();
	}

	
	
	@Override
	public List<Adresse> selectSearch(String criteria) throws Exception {
		
		int criteriaInt = 2147483647;
		try {
			System.out.println("je parseInt");
			criteriaInt = Integer.parseInt(criteria);
		} catch (Exception e) {
			System.out.println("Impossible de ParseInt le criteria");
		}
				
		String requestString = "SELECT a FROM Adresse a WHERE a.id=? OR a.nomAdresse=? OR a.voie=?"
				+ " OR a.complement=? OR a.codePostal=? OR a.ville=? OR a.pays=?";
		
		TypedQuery<Adresse> query =em.createQuery(requestString, Adresse.class);
		query.setParameter(1, criteriaInt);
		query.setParameter(2, criteria);
		query.setParameter(3, criteria);
		query.setParameter(4, criteria);
		query.setParameter(5, criteria);
		query.setParameter(6, criteria);
		query.setParameter(7, criteria);
		return query.getResultList();
	}
	
	
	
	@Override
	public List<Adresse> selectAll() throws Exception {
		
		String requestString = "SELECT a FROM Adresse a";
		
		TypedQuery<Adresse> query =em.createQuery(requestString, Adresse.class);
		
		return query.getResultList();
	}

	@Override
	public void insert(Adresse adresse) throws Exception {
		em.persist(adresse);

	}

	@Override
	public void update(Adresse adresse) throws Exception {
		em.persist(adresse);
	}

	@Override
	public void delete(Adresse adresse) throws Exception {
		em.remove(adresse);
		adresse.setId(0);

	}

}