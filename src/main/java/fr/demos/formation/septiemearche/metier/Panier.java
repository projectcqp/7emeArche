package fr.demos.formation.septiemearche.metier;

import java.util.ArrayList;
import java.util.Iterator;

import fr.demos.formation.septiemearche.exceptions.ExceptionQuantiteDemandeeSuperieureAuStock;

public class Panier implements Iterable<LignePanier> {
	
	private Compte compte;
//	relier un panier Ã  une session ou un compte
	private ArrayList<LignePanier> lignesPanier = new ArrayList<>();
	
	
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
	
	//sera appelÃ©e par ajouterUnArticle
	private void ajouterLignePanier(Article a, int quantite) throws ExceptionQuantiteDemandeeSuperieureAuStock{
		//si quantitÃ© demandÃ©e infÃ©rieure ou Ã©gale au stock
		if (quantite <= a.getStock()){
			lignesPanier.add(new LignePanier(a, quantite));
		} else { // si quantite demandÃ©e supÃ©rieure au stock
			if (a.getMaterialise() == null){ // si dÃ©materialise illimitÃ©, quantitÃ© toujours Ã  1
				lignesPanier.add(new LignePanier(a, quantite));
			} else { // si matÃ©rialisÃ© stock insuffisant
				throw new ExceptionQuantiteDemandeeSuperieureAuStock("Le stock n'est pas suffisant, nombre d'articles en stock : ", a.getStock());
				}
		}
	}
	
	public void ajouterUnArticle(Article a, int quantiteAjoutee) throws ExceptionQuantiteDemandeeSuperieureAuStock{
		LignePanier lp1 = new LignePanier(a, quantiteAjoutee);
		int indexDeMaLigne = lignesPanier.indexOf(lp1);
		
		// si la ligne a dÃ©jÃ  des articles il faut les comptabiliser pour comparer au stock
		// test sur quantiteLignePlusQuantiteAjoutee, pas uniquement sur la quantitï¿½ ajoutï¿½e !!!
		int quantiteLignePlusQuantiteAjoutee = lp1.getQuantite() + quantiteAjoutee;
		
		// si la ligne article existe dÃ©jÃ 
		if (indexDeMaLigne != -1){
			// si la quantitÃ© ajoutÃ©e <= stock de l'article
			if (quantiteLignePlusQuantiteAjoutee <= a.getStock()){
				lignesPanier.get(indexDeMaLigne).setQuantite(
					lignesPanier.get(indexDeMaLigne).getQuantite() + quantiteAjoutee);
			} else { // si quantite demandÃ©e supÃ©rieure au stock
				 // si dÃ©materialise on s'en fiche c'est illimitÃ©
				if (a.getMaterialise() == null){
					lignesPanier.get(indexDeMaLigne).setQuantite(
							lignesPanier.get(indexDeMaLigne).getQuantite() + quantiteAjoutee);
				} else { // si matÃ©rialisÃ© et stock insuffisant
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

	// supprimer ligne Ã  partir de la rÃ©fÃ©rence trouvÃ©e dans la ligne (c'est ma clÃ© primaire)
	public void supprimerLignePanier(String refArticleLigne){
		Iterator<LignePanier> iter = lignesPanier.iterator();
		while(iter.hasNext()){
			LignePanier lp= iter.next();
			// si la rÃ©f est la mÃªme, c'est ma ligne panier
			if(lp.getArticle().getReference().equals(refArticleLigne)){
				iter.remove();
			}
		}
	}
	
	// TODO vÃ©rifier et utiliser
	public boolean validerStockCommande(){
		
		boolean stockArticlesOk = true;
		
		// parcourir le panier et sortir la quantitÃ©
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
		return lignesPanier.size();
	}
	
	//nombre d'articles dans panier (plusieurs articles par ligne)
	public int getArticlesCumulesPanier(){
		int i = 0;
		for(LignePanier lignePanier : lignesPanier){
			i = i + lignePanier.getQuantite();		
		}
		return i;
	}

	// methode pour modifier la quanttÃ© de la ligne panier
	public void modifierQuantiteLignePanier (String refArticleLigne, int nouvelleQuantiteLigne) throws ExceptionQuantiteDemandeeSuperieureAuStock{
		for(LignePanier lignePanier : lignesPanier){
			// si c'est bien mon article
			if (lignePanier.getArticle().getReference().equals(refArticleLigne)){
				// si article dÃ©matÃ©rialisÃ© (pas de stock Ã  gÃ©rer quantitÃ© illimitÃ©e)
				if(lignePanier.getArticle().getMaterialise() == null){
					lignePanier.setQuantite(nouvelleQuantiteLigne);
				} else { // si article matÃ©riel 
					// test quantitÃ© demandÃ©e et stock
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
	
	/**
	 * @param article
	 * @param nouvelleQuantiteLigne
	 * @throws ExceptionQuantiteDemandeeSuperieureAuStock
	 */
	public void modifierQuantiteLignePanier (Article article, int nouvelleQuantiteLigne) throws ExceptionQuantiteDemandeeSuperieureAuStock{
		modifierQuantiteLignePanier(article.getReference(), nouvelleQuantiteLigne);
}
	
	 /* 
	 * @param article
	 * @return
	 */
	public boolean articleDejaDansLePanier(Article article) {
for(LignePanier lignePanier : lignesPanier) {
	if(lignePanier.getArticle() == article) {
		return true;
	}
}
return false;
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
	
	public double getTotalHt() {
		double totalHt = 0;
		
		for(LignePanier lignePanier:lignesPanier) {
			totalHt += lignePanier.getTotalHt();
		}
		
		return totalHt; 
	}
	
		public double getTotalTc() {
			double totalTc = 0;
			
			for(LignePanier lignePanier:lignesPanier) {
				totalTc += lignePanier.getTotalTc();
			}
			
			return totalTc;
	}
		
		public double getMontantTva() {
			double totalTva = 0;
			
			for(LignePanier lignePanier:lignesPanier) {
				totalTva += lignePanier.getMontantTva();
			}
			
			return totalTva;
		}
		
		/**
		 * Retourne la ligne du panier contenant l'article en paramètre
		 * retourne null si elle n'existe pas.
		 * 
		 * @param article
		 * @return
		 */
		public LignePanier getLignePanier(Article article) {
			for(LignePanier lignePanier:lignesPanier) {
				if(lignePanier.getArticle()== article) {
				return lignePanier;
			}
		}
			return null;
		}

		
		
		
}
