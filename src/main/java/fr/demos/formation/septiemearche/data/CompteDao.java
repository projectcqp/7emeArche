package fr.demos.formation.septiemearche.data;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.formation.septiemearche.metier.Compte;

public class CompteDao implements InterfaceDao<Compte> {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Compte select(String id) throws Exception {

		int idInt = 2147483647;
		try {
			idInt = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("On fait le select(id) sur un int" + e);
		}

		String requestString = "SELECT c FROM Compte c WHERE c.id=?";

		TypedQuery<Compte> query = em.createQuery(requestString, Compte.class);
		query.setParameter(1, idInt);

		return query.getSingleResult();
	}

	@Override
	public List<Compte> selectSearch(String criteria) throws Exception {

		int criteriaInt = 2147483647;
		try {
			System.out.println("je parseInt");
			criteriaInt = Integer.parseInt(criteria);
		} catch (Exception e) {
			System.out.println("Impossible de ParseInt le criteria");
		}

		LocalDate criteriaLocalDate = LocalDate.now();
		System.out.println(criteriaLocalDate);
		try {
			System.out.println("je parseLocalDate");
			criteriaLocalDate = LocalDate.parse(criteria);
		} catch (Exception e) {
			System.out.println("Impossible de ParseLocalDate le criteria");
		}
		
		String requestString = "SELECT c FROM Compte c WHERE c.id=? OR c.email=? OR c.nom=? OR c.prenom=?"
				//+ " OR c.telephone=? OR c.dateNaissance=?";
				+ " OR c.telephone=?";

		TypedQuery<Compte> query = em.createQuery(requestString, Compte.class);
		query.setParameter(1, criteriaInt);
		query.setParameter(2, criteria);
		query.setParameter(3, criteria);
		query.setParameter(4, criteria);
		query.setParameter(5, criteria);
		//query.setParameter(6, criteriaLocalDate);
		
		return query.getResultList();
	}

	@Override
	public List<Compte> selectAll() throws Exception {
		String requestString = "SELECT c FROM Compte c";

		TypedQuery<Compte> query = em.createQuery(requestString, Compte.class);

		return query.getResultList();
		// Todo filtrer les résultats en fonction du paramètre
	}

	@Override
	public void insert(Compte compte) throws Exception {
		em.persist(compte);

	}

	@Override
	public void update(Compte compte) throws Exception {
		em.persist(compte);
	}

	@Override
	public void delete(Compte compte) throws Exception {
		em.remove(compte);
		compte.setId(0);
	}

}