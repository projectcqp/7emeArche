package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.demos.formation.septiemearche.metier.Adresse;

public class AdresseDao implements InterfaceDao<Adresse> {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Adresse select(String id) throws Exception {
		String requestString = "SELECT FROM ADRESSE WHERE ID=?";

		TypedQuery<Adresse> query = em.createQuery(requestString, Adresse.class);
		query.setParameter(0, id);

		return query.getSingleResult();
	}

	@Override
	public List<Adresse> selectAll(String criteria) throws Exception {
		String requestString = "SELECT FROM ADRESSE";

		TypedQuery<Adresse> query = em.createQuery(requestString, Adresse.class);

		return query.getResultList();
		// Todo filtrer les résultats en fonction du paramètree
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