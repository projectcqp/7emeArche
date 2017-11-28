package fr.demos.formation.septiemearche.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author STAGIAIRE
 * 
 * Une ligne commande appartient à une et une seule comande
 * Elle ne réfférence pas un article, mais une copie de ces attributs pour figer l'état de l'article au moment de la validation de la commande
 *
 */
@Entity
@Table(name="ligne_commande")
public class LigneCommande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ligne_commande")
	private int id;
	
	@Column(name="reference_article_ligne_commande")
	private String referenceArticle;
	
	@Column(name="nom_article_ligne_commande")
	private String nomArticle;
	
	@Column(name="prix_unitaire_ligne_commande")
	private double prixUnitaire; 
	
	@Column(name="quantite_ligne_commande")
	private int quantite;
	
	@Column(name="total_ligne_commande")
	private double total;
	
	@Column(name="taux_tva_ligne_commande")
	private double tauxTva;
		
	
	public LigneCommande() {
		super();
	}
	
	public LigneCommande(String referenceArticle, String nomArticle, double prixUnitaire, double tauxTva,
			int quantite, double total) {
		super();
		this.referenceArticle = referenceArticle;
		this.nomArticle = nomArticle;
		this.prixUnitaire = prixUnitaire;
		this.tauxTva = tauxTva;
		this.quantite = quantite;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getreferenceArticle() {
		return referenceArticle;
	}

	public void setreferenceArticle(String referenceArticle) {
		this.referenceArticle = referenceArticle;
	}

	public String getnomArticle() {
		return nomArticle;
	}

	public void setnomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public double getTauxTva() {
		return tauxTva;
	}

	public void setTauxTva(double tauxTva) {
		this.tauxTva = tauxTva;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}