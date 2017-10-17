package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import fr.demos.formation.septiemearche.metier.Commande;
import fr.demos.formation.septiemearche.metier.Compte;

public class CommandeDao implements InterfaceDao<Commande> {

	@PersistenceContext
	private EntityManager em;
	private static Logger logger = Logger.getLogger("Log");
	
	@Override
	public Commande select(String idString) throws Exception {
		int idInt = 0;
		Commande commande = null;
		
		try {
			idInt = Integer.parseInt(idString);
			
		String requestString = "SELECT FROM COMMANDE C WHERE C.ID=?";

		TypedQuery<Commande> query = em.createQuery(requestString, Commande.class);
		query.setParameter(1, idInt);

		commande = query.getSingleResult();
		} catch(NumberFormatException e){
			logger.error("Paramètre invalide, " + idInt + " n'est pas un nombre valide");			
		}
		return commande;
	}

	@Override
	public List<Commande> selectAll() throws Exception {
		// TODO Auto-generated method stub
		//Cette méthode est potentiellement dangereuse
		return null;
	}

	@Override
	public void insert(Commande commande) throws Exception {
		em.persist(commande);
	}

	@Override
	public void update(Commande commande) throws Exception {
		em.persist(commande);
	}

	@Override
	public void delete(Commande commande) throws Exception {
		em.remove(commande);		
	}

	public List<Commande> selectCommandeFor(Compte compte) throws Exception {
		//Todo intégrer un critère de délais pour limiter le nombre de résultat dans le temps
	String requestString = "SELECT FROM COMMANDE C WHERE C.IDCLIENT=?";

	TypedQuery<Commande> query = em.createQuery(requestString, Commande.class);
	query.setParameter(1, compte.getId());
	List<Commande> commandes = query.getResultList();
	
	if(commandes.isEmpty()) {
		logger.debug("Pas de commande trouvée pour le client :" + compte);
	}
	
		return commandes;
	}

}
