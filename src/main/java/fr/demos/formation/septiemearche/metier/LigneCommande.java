package fr.demos.formation.septiemearche.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author STAGIAIRE
 *
 */
@Entity
@Table(name="ligne_commande")
public class LigneCommande {
	@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ligne_commande")
	private int id;
	@Column(name="references_article_ligne_commande")
	private String referencesArticle;
	@Column(name="designation_article_ligne_commande")
	private String ddesignationArticle;
	@Column(name="prix_unitaire_ligne_commande")
	private double prixUnitaire; 
	@Column(name="taux_tva_ligne_commande")
	private double tauxTva;
	@Column(name="quantite_ligne_commande")
	private int quantite;
	@Column(name="total_ligne_commande")
	private double total;
		
	public LigneCommande() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReferencesArticle() {
		return referencesArticle;
	}

	public void setReferencesArticle(String referencesArticle) {
		this.referencesArticle = referencesArticle;
	}

	public String getDdesignationArticle() {
		return ddesignationArticle;
	}

	public void setDdesignationArticle(String ddesignationArticle) {
		this.ddesignationArticle = ddesignationArticle;
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