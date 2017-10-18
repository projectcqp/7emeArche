package fr.demos.formation.septiemearche.metier;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Alexandre BIGOT
 *
 *
 *Une commande est associée à un compte.
 *Elle  contient une ou plusieurs ligne comande
 */
@Entity
@Table(name = "commande")
public class Commande implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_commande")
	private int id;
	
	@Column(name = "date_commande")
	private LocalDateTime dateCommande;
	
	// numeroCommande composé de année-mois-nombre incrémenté ex: 2017-10-0001
	@Column(name = "numero_commande")
	private String numeroCommande;
	
	// numeroFacture composé de f-annéemoisjour-nombre incrémenté ex: f-20171018-0001
	@Column(name = "numero_facture_commande")
	private String numeroFacture;
	
	// concaténation des infos de adresse (adresse.toString())
	@Column(name = "adresse_facturation_commande")
	private String adresseFacturation;
	
	// concaténation des infos de adresse (adresse.toString())
	@Column(name = "adresse_livraison_commande")
	private String adresseLivraison;
	
	@Column(name = "total_ht_commande")
	private double totalHt;
	
	@Column(name = "total_tva_commande")
	private double totalTva;

	@OneToMany
	@JoinColumn(name = "id_commande_ligne_commande", referencedColumnName = "id_commande")
	private List<LigneCommande> lignesCommande = new ArrayList<>();
	
	@ManyToOne
	private Compte compte;
	
	private String destinataireCompte;
	private String destinataireAutre;

	public Commande() {
		super();
	}
	
	public Commande(LocalDateTime dateCommande, String numeroCommande, String numeroFacture,
			String adresseFacturation, String adresseLivraison, double totalHt, double totalTva,
			List<LigneCommande> lignesCommande, Compte compte) {
		super();
		this.dateCommande = dateCommande;
		this.numeroCommande = numeroCommande;
		this.numeroFacture = numeroFacture;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
		this.totalHt = totalHt;
		this.totalTva = totalTva;
		this.lignesCommande = lignesCommande;
		this.compte = compte;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(LocalDateTime dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(String numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public String getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	public String getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(String adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public double getTotalHt() {
		return totalHt;
	}

	public void setTotalHt(double totalHt) {
		this.totalHt = totalHt;
	}

	public double getTva() {
		return totalTva;
	}

	public void setTva(double totalTva) {
		this.totalTva = totalTva;
	}

	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public double getTotalTva() {
		return totalTva;
	}

	public void setTotalTva(double totalTva) {
		this.totalTva = totalTva;
	}

	public String getDestinataireCompte() {
		destinataireCompte = this.compte.getTitre() + " " + this.compte.getPrenom() + " " + this.compte.getNom();
		return destinataireCompte;
	}

	public void setDestinataireCompte(String destinataireCompte) {
		this.destinataireCompte = destinataireCompte;
	}

	public String getDestinataireAutre() {
		return destinataireAutre;
	}

	public void setDestinataireAutre(Enum<Titre> titre, String prenom, String nom) {
		this.destinataireAutre = titre + " " + prenom + " " + nom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}