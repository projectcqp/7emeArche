package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.demos.formation.septiemearche.metier.Commande;

public class CommandeDao implements InterfaceDao<Commande> {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Commande select(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Commande object) throws Exception {
		em.persist(object);
		
	}

	@Override
	public void update(Commande object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Commande object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commande> selectSearch(String criteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
