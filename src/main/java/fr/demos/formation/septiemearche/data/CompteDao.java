package fr.demos.formation.septiemearche.data;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import fr.demos.formation.septiemearche.metier.Compte;

public class CompteDao implements InterfaceDao<Compte> {
	@PersistenceContext
	private EntityManager em;
	private static Logger logger = Logger.getLogger("Log");

	@Override
	public Compte select(String idString) throws Exception {
		int idInt = 0;
		Compte compte = null;

		try {
			idInt = Integer.parseInt(idString);

			String requestString = "SELECT c FROM Compte c WHERE c.id=?";

			TypedQuery<Compte> query = em.createQuery(requestString, Compte.class);
			query.setParameter(1, idInt);

			compte = query.getSingleResult();
			
		} catch (NumberFormatException e) {
			logger.error("Paramètre invalide, " + idInt + " n'est pas un nombre valide");
		}
		return compte;
	}

	
	public Compte select(String email, String password){
		
		Compte compteConnecte = null;
		
		try {
			String requestString = "SELECT c FROM Compte c WHERE c.email=? AND c.password=?";
			
			TypedQuery<Compte> query = em.createQuery(requestString, Compte.class);
			query.setParameter(1, email);
			query.setParameter(2, password);
			
			compteConnecte = query.getSingleResult();
		} catch (Exception e) {
		
			logger.error("Il n'y a aucun compte trouvé avec cette combinaison email, mot de passe");
		}
		
		
		return compteConnecte;
	
	}
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
				+ " OR c.telephone=? OR c.adresseFacturation.codePostal=? OR c.adresseFacturation.pays=?";

		TypedQuery<Compte> query = em.createQuery(requestString, Compte.class);
		query.setParameter(1, criteriaInt);
		query.setParameter(2, criteria);
		query.setParameter(3, criteria);
		query.setParameter(4, criteria);
		query.setParameter(5, criteria);
		query.setParameter(6, criteria);
		query.setParameter(7, criteria);

		return query.getResultList();
	}

	public List<Compte> selectAll() throws Exception {
		String requestString = "SELECT c FROM Compte c";

		TypedQuery<Compte> query = em.createQuery(requestString, Compte.class);

		return query.getResultList();
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