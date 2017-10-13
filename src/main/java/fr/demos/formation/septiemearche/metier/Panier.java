package fr.demos.formation.septiemearche.metier;

import java.util.ArrayList;
import java.util.Iterator;

import fr.demos.formation.septiemearche.exceptions.ExceptionQuantiteDemandeeSuperieureAuStock;
import fr.demos.formation.septiemearche.exceptions.ExceptionRetirerArticleAbsentDuPanier;
import fr.demos.formation.septiemearche.exceptions.ExceptionRetirerArticlePanier;

public class Panier implements Iterable<LignePanier> {
	
	private Compte compte;
//	relier un panier à une session ou un compte
	private ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();
	
	
	@Override
	public String toString() {
		return "Panier [lignesPanier=" + lignesPanier + ", getPrixTotal()=" + getPrixTotal()
				+ ", getSizeContenuPanier()=" + getSizeContenuPanier() + ", getArticlesCumulesPanier()="
				+ getArticlesCumulesPanier() + "]";
	}

	public double getPrixTotal(){
		double prixTotal=0;
		double prixTotalArrondi=0.00; 
		for (LignePanier ligneDuPanier : lignesPanier){
			prixTotal = prixTotal + (ligneDuPanier.getQuantite() * ligneDuPanier.getArticle().getPrixHt());
			prixTotalArrondi = Math.round(prixTotal*100.0)/100.0;
		}
		return prixTotalArrondi;
	}
	
	//sera appelée par ajouterUnArticle
	private void ajouterLignePanier(Article a, int quantite) throws ExceptionQuantiteDemandeeSuperieureAuStock{
		//si quantité demandée inférieure ou égale au stock
		if (quantite <= a.getStock()){
			lignesPanier.add(new LignePanier(a, quantite));
		} else { // si quantite demandée supérieure au stock
			if (a.getMateriel() == null){ // si dématerialise illimité, quantité toujours à 1
				lignesPanier.add(new LignePanier(a, quantite));
			} else { // si matérialisé stock insuffisant
				throw new ExceptionQuantiteDemandeeSuperieureAuStock("Le stock n'est pas suffisant, nombre d'articles en stock : ", a.getStock());
				}
		}
	}
	
	

	public void ajouterUnArticle(Article a, int quantiteAjoutee) throws ExceptionQuantiteDemandeeSuperieureAuStock{
		LignePanier lp1 = new LignePanier(a, quantiteAjoutee);
		int indexDeMaLigne = lignesPanier.indexOf(lp1);
		
		// si la ligne a déjà des articles il faut les comptabiliser pour comparer au stock
		// test sur quantiteLignePlusQuantiteAjoutee, pas uniquement sur la quantit� ajout�e !!!
		int quantiteLignePlusQuantiteAjoutee = lp1.getQuantite() + quantiteAjoutee;
		
		// si la ligne article existe déjà
		if (indexDeMaLigne != -1){
			// si la quantité ajoutée <= stock de l'article
			if (quantiteLignePlusQuantiteAjoutee <= a.getStock()){
				lignesPanier.get(indexDeMaLigne).setQuantite(
					lignesPanier.get(indexDeMaLigne).getQuantite() + quantiteAjoutee);
			} else { // si quantite demandée supérieure au stock
				 // si dématerialise on s'en fiche c'est illimité
				if (a.getMateriel() == null){
					lignesPanier.get(indexDeMaLigne).setQuantite(
							lignesPanier.get(indexDeMaLigne).getQuantite() + quantiteAjoutee);
				} else { // si matérialisé et stock insuffisant
					throw new ExceptionQuantiteDemandeeSuperieureAuStock(
							"Le stock n'est pas suffisant, nombre d'articles en stock : ", a.getStock());
					}
			}
		}
		// si la ligne article n'existe pas
		else { 
			this.ajouterLignePanier(a, quantiteAjoutee);
		}
	}
	

	// supprimer ligne à partir de la référence trouvée dans la ligne (c'est ma clé primaire)
	public void supprimerLignePanier(String refArticleLigne){
			
		
		Iterator<LignePanier> iter = lignesPanier.iterator();
		while(iter.hasNext()){
			LignePanier lp= iter.next();
			// si la réf est la même, c'est ma ligne panier
			if(lp.getArticle().getReference().equals(refArticleLigne)){
				iter.remove();
			}
		}
	}
	
	// TODO vérifier et utiliser
	public boolean validerStockCommande(Panier p){
		
		boolean stockArticlesOk = true;
		
		// parcourir le panier et sortir la quantité
		for(LignePanier ligne : lignesPanier){
			
			int nbreArticlesLigne = ligne.getQuantite();			
			// si au moins une lignePanier > stock article
			if(nbreArticlesLigne <= ligne.getArticle().getStock()){
				stockArticlesOk = false;
			}
		} // for each
		return stockArticlesOk;
	} // validerCommande
	
	
	// nombre de lignes dans panier
	public int getSizeContenuPanier(){
		int quantite = lignesPanier.size();
		return quantite;
	}
	
	//nombre d'articles dans panier (plusieurs articles par ligne)
	public int getArticlesCumulesPanier(){
		int i = 0;
		for(LignePanier lignePanier : lignesPanier){
			i = i + lignePanier.getQuantite();		
		}
		return i;
	}

	
	// methode pour modifier la quantté de la ligne panier
	public void modifierQuantiteLignePanier (String refArticleLigne, int nouvelleQuantiteLigne) throws ExceptionQuantiteDemandeeSuperieureAuStock{
		for(LignePanier lignePanier : lignesPanier){
			// si c'est bien mon article
			if (lignePanier.getArticle().getReference().equals(refArticleLigne)){
				// si article dématérialisé (pas de stock à gérer quantité illimitée)
				if(lignePanier.getArticle().getMateriel() == null){
					lignePanier.setQuantite(nouvelleQuantiteLigne);
				} else { // si article matériel 
					// test quantité demandée et stock
					if(nouvelleQuantiteLigne <= lignePanier.getArticle().getStock()) {
						lignePanier.setQuantite(nouvelleQuantiteLigne);
					} else {
						throw new ExceptionQuantiteDemandeeSuperieureAuStock(
								"Le stock n'est pas suffisant, nombre d'articles en stock : ", lignePanier.getArticle().getStock());
					}
				}
			}
		}
	}
			
	@Override
	public Iterator<LignePanier> iterator() {
		return lignesPanier.iterator();
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
		
}
