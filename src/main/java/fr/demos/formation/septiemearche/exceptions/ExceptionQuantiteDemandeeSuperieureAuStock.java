package fr.demos.formation.septiemearche.exceptions;

public class ExceptionQuantiteDemandeeSuperieureAuStock extends Exception {

	private int stockArticle;

	public ExceptionQuantiteDemandeeSuperieureAuStock(String message, int stockArticle) {
		super(message);
		this.stockArticle = stockArticle;
	}
	
	public int getQuantiteStock(){
		return stockArticle;
	}
	
}
