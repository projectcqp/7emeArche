package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.formation.septiemearche.metier.Compte;

public class CompteDao implements InterfaceDao<Compte> {
	@PersistenceContext
	private EntityManager em;

	// pour vérifier le mot de passe et retroune un compte
	public 
	
	
	@Override
	public Compte select(String id) throws Exception {
		String requestString = "SELECT FROM COMPTE WHERE ID=?";

		TypedQuery<Compte> query = em.createQuery(requestString, Compte.class);
		query.setParameter(0, id);

		return query.getSingleResult();
	}

	@Override
	public List<Compte> selectAll(String criteria) throws Exception {
		String requestString = "SELECT FROM COMPTE";

		TypedQuery<Compte> query = em.createQuery(requestString, Compte.class);

		return query.getResultList();
		// Todo filtrer les résultats en fonction du paramètree
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
		compte.setEmail("0");
	}

}