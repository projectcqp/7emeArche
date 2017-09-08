package fr.demos.formation.septiemearche.metier;

import fr.demos.formation.septiemearche.exceptions.ExceptionPasswordFormat;

public class Compte {

	private String nom;
	private String prenom;
	private Adresse adresseCompte;
	private Adresse adresseLivraison;
	private String email;
	private String telephone;
	private String password;
	private int longueurPasswordMini = 6;
			
	public Compte(String nom, String prenom, Adresse adresseCompte, Adresse adresseLivraison,
			String email, String telephone, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresseCompte = adresseCompte;
		this.adresseLivraison = adresseLivraison;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
	}

	public void testCreationPassword (String password, String passwordConfirmation)throws ExceptionPasswordFormat{
		//test si les passwords entres sont identiques
		if(password == passwordConfirmation){
			// test taille 6 caract�res mini
			if (password.length() < longueurPasswordMini){
				
			} else {
				throw new ExceptionPasswordFormat("Votre mot de passe n'est pas assez long, vous avez entré un mot de passe de "
												+ password.length() + " caractères et il en faut au moins 6");
			}// test longueur
		} else {
			throw new ExceptionPasswordFormat("Vous avez entré des mots de passe différents");
		}
	}
	
	
	
	@Override
	public String toString() {
		return "Compte [nom=" + nom + ", prenom=" + prenom + ", adresseCompte=" + adresseCompte.toString() + ", adresseLivraison="
				+ adresseLivraison + ", email=" + email + ", telephone=" + telephone + ", password=" + password
				+ ", longueurPasswordMini=" + longueurPasswordMini + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Adresse getAdresseCompte() {
		return adresseCompte;
	}

	public void setAdresseCompte(Adresse adresseCompte) {
		this.adresseCompte = adresseCompte;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}

