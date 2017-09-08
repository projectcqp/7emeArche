package fr.demos.formation.septiemearche.metier;

/**
 * @author STAGIAIRE
 *
 */
public class LigneCommande {
	
	private String refLigneCommande;
	private String refArticle;
	private String quantite;
	private float prix;
	private float prixTotalLigne;
	
	public LigneCommande() {
		super();

	}
	
	public LigneCommande(String refLigneCommande, String refArticle, String quantite, float prix,
			float prixTotalLigne) {
		super();
		this.refLigneCommande = refLigneCommande;
		this.refArticle = refArticle;
		this.quantite = quantite;
		this.prix = prix;
		this.prixTotalLigne = prixTotalLigne;
	}
	
	public String getRefLigneCommande() {
		return refLigneCommande;
	}
	public void setRefLigneCommande(String refLigneCommande) {
		this.refLigneCommande = refLigneCommande;
	}
	public String getRefArticle() {
		return refArticle;
	}
	public void setRefArticle(String refArticle) {
		this.refArticle = refArticle;
	}
	public String getQuantite() {
		return quantite;
	}
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public float getPrixTotalLigne() {
		return prixTotalLigne;
	}
	public void setPrixTotalLigne(float prixTotalLigne) {
		this.prixTotalLigne = prixTotalLigne;
	}
	
}
