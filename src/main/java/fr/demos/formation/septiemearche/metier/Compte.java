package fr.demos.formation.septiemearche.metier;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import fr.demos.formation.septiemearche.exceptions.ExceptionPasswordFormat;

/**
 * @author Alexandre
 * 
 *         Un compte a une adresse de facturation et une adresse a un compte
 *
 */
@Entity
@Table(name = "compte")
public class Compte implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_compte")
	private int id;
	
	@Column(name = "email_compte", nullable = false)
	private String email;
	
	@Column(name = "password_compte", nullable = false)
	private String password;
	
	@Column(name = "titre_compte", nullable = false)
	@Enumerated(EnumType.STRING)
	private Titre titre;
	
	@Column(name = "nom_compte", nullable = false)
	private String nom;
	
	@Column(name = "prenom_compte", nullable = false)
	private String prenom;
	
	@Column(name = "telephone_compte", nullable = false)
	private String telephone;
	
	//TODO faire autrechose que de la date java 8 ça fait planter hibernate
	//@Column(name = "date_naissance_compte", nullable = false)
	@Transient
	private LocalDate dateNaissance;
	
	
	@OneToOne
	@JoinColumn(name= "id_adresse_facturation_compte")
	private Adresse adresseFacturation;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="id_compte_adresse")
	private List<Adresse> adressesCompte;
	
	@Transient
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

	public Compte() {
		super();
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", email=" + email + ", password=" + password + ", titre=" + titre + ", nom=" + nom
				+ ", prenom=" + prenom + ", telephone=" + telephone + ", dateNaissance=" + dateNaissance
				+ ", adresseFacturation=" + adresseFacturation + ", adressesCompte=" + adressesCompte
				+ ", longueurPasswordMini=" + longueurPasswordMini + "]";
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

	public List<Adresse> getAdressesCompte() {
		return adressesCompte;
	}

	public void setAdressesCompte(List<Adresse> adressesCompte) {
		this.adressesCompte = adressesCompte;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Titre getTitre() {
		return titre;
	}

	public void setTitre(Titre titre) {
		this.titre = titre;
	}
	
}
