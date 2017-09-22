package fr.demos.formation.septiemearche.metier;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.demos.formation.septiemearche.exceptions.ExceptionPasswordFormat;

/**
 * @author Alexandre
 * 
 *         Un compte a une adresse de facturation et une adresse a un compte
 *
 */
@Entity
@Table(name = "compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_compte")
	private int id;
	@Column(name = "email_compte", nullable = false)
	private String email;
	@Column(name = "password_compte", nullable = false)
	private String password;
	@Column(name = "nom_compte", nullable = false)
	private String nom;
	@Column(name = "prenom_compte", nullable = false)
	private String prenom;
	@Column(name = "telephone_compte", nullable = false)
	private String telephone;
	@Column(name = "date_naissance_compte", nullable = false)
	private LocalDate dateNaissance;
	@Column(name = "id_adress_facturation_compte", nullable = false)
	private Adresse adresseFacturation;
	private int longueurPasswordMini = 6;

	public void testCreationPassword(String password, String passwordConfirmation) throws ExceptionPasswordFormat {
		// test si les passwords entres sont identiques
		if (password == passwordConfirmation) {
			// test taille 6 caract�res mini
			if (password.length() < longueurPasswordMini) {

			} else {
				throw new ExceptionPasswordFormat(
						"Votre mot de passe n'est pas assez long, vous avez entré un mot de passe de "
								+ password.length() + " caractères et il en faut au moins 6");
			} // test longueur
		} else {
			throw new ExceptionPasswordFormat("Vous avez entré des mots de passe différents");
		}
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public int getLongueurPasswordMini() {
		return longueurPasswordMini;
	}

	public void setLongueurPasswordMini(int longueurPasswordMini) {
		this.longueurPasswordMini = longueurPasswordMini;
	}
	
}
