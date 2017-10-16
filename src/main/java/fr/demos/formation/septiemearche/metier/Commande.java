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
 */
@Entity
@Table(name = "commande")
public class Commande implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_commande")
	private int id;
	@Column(name = "date_commande")
	private LocalDateTime dateCommande;
	@Column(name = "numero_commande")
	private String numeroCommande;
	@Column(name = "numero_facture_commande")
	private String numeroFacture;
	@Column(name = "	dresse_facturation_commande")
	private String adresseFacturation;
	@Column(name = "adresse_livraison_commande")
	private String adresseLivraison;
	@Column(name = "total_ht_commande")
	private double totalHt;
	@Column(name = "montant_tva_commande")
	private double montantTva;

	@OneToMany
	@JoinColumn(name = "id_ligne_commande", referencedColumnName = "id_commande_ligne_commande")
	private List<LigneCommande> lignesCommande = new ArrayList<>();
	@ManyToOne
	private Compte compte;

	public Commande() {
		super();
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
		return montantTva;
	}

	public void setTva(double montantTva) {
		this.montantTva = montantTva;
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

}