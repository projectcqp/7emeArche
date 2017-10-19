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

			String requestString = "SELECT c FROM Commande c WHERE c.id=?";

			TypedQuery<Commande> query = em.createQuery(requestString, Commande.class);
			query.setParameter(1, idInt);

			commande = query.getSingleResult();
		} catch (NumberFormatException e) {
			logger.error("Paramètre invalide, " + idInt + " n'est pas un nombre valide");
		}
		return commande;
	}

	public List<Commande> selectCommandeFor(Compte compte) throws Exception {
		// TODO intégrer un critère de délai pour limiter le nombre de résultats dans le temps
		String requestString = "SELECT c FROM Commande c WHERE c.id=?";

		TypedQuery<Commande> query = em.createQuery(requestString, Commande.class);
		query.setParameter(1, compte.getId());
		
		List<Commande> commandes = query.getResultList();

		if (commandes.isEmpty()) {
			logger.debug("Pas de commande trouvée pour le client : " + compte);
		}

		return commandes;
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

}
