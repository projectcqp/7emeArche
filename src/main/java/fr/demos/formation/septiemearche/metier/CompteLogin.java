package fr.demos.formation.septiemearche.metier;

import javax.inject.Inject;

import fr.demos.formation.septiemearche.data.CompteDao;

public class CompteLogin {
	
	
	
	
	
	
	
	
	
	
	// A SUPPRIMER ET REMPLACER PAR UNE METHODE QUI CHECKE LE LOGIN DANS COMPTE DAO
	
	
	
	
	
	
	// appel de l'interface on pourra choisir son dao si plusieurs
	@Inject CompteDao compteDao;
	
	public Compte getCompteSiConnexionReussie(String identifiantEmail, String password) throws Exception {
		
		Compte compteRetourne = null;
		//je cree une instance du DAO qui va me retourner un Compte
		//
		
		//TODO
		//compteRetourne = compteDao.select(identifiantEmail, password);
		
		return compteRetourne;
		// si retourne null erreur password ou email
	}	
}