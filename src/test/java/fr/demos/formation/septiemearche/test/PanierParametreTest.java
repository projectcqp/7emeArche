package fr.demos.formation.septiemearche.test;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.demos.formation.septiemearche.exceptions.ExceptionQuantiteDemandeeSuperieureAuStock;
import fr.demos.formation.septiemearche.metier.Article;
import fr.demos.formation.septiemearche.metier.ArticleDivers;
import fr.demos.formation.septiemearche.metier.Etat;
import fr.demos.formation.septiemearche.metier.LignePanier;
import fr.demos.formation.septiemearche.metier.Livre;
import fr.demos.formation.septiemearche.metier.Panier;
import fr.demos.formation.septiemearche.metier.Tva;

@RunWith(Parameterized.class)
public class PanierParametreTest {

	@Parameters	
	public static Collection<Object[]> params(){
		Object[] element1 = {new Livre("Reference", 10, "Nom", "UrlImage", new Tva(1, 10, "A"), 10, Etat.OCCASION_BON, "Auteur", "Isbn",
				"Editeur", "Genre")};
		
		Object[] element2 = {new Livre("Reference", 13, "Nom", "UrlImage", new Tva(1, 10, "A"), "Format", "UrlDownload", "auteur", "Isbn", "Editeur", "enre")};
		
		Object[] element3 = {new ArticleDivers("Reference", 10, "Nom", "UrlImage", new Tva(1, 10, "a"), 10, "nature")};
		
		
		
		ArrayList<Object[]> listeParams = new ArrayList<>();
		listeParams.add(element1);			
		listeParams.add(element2);
		listeParams.add(element3);
		return listeParams;				
	}

	private final Article article;
	
	private Panier panier;

	public PanierParametreTest(Article article) {
		super();
		panier = new Panier();
		this.article=article;
	}

	/**
	 * Test la méthode articleDejaDansLePanier doit retourner fau si l'article
	 * n'y est pas et vrais si l'article y est
	 */
	@Test

	public void testMethodeArticleDejaDansLePanier() {
		boolean test;

		test = panier.articleDejaDansLePanier(article);
		Assert.assertFalse(test);

		try {
			panier.ajouterUnArticle(article, 2);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			Assert.fail("Vérifier l'appel à la méthode ajouter article : la quantité n'est pas valide");
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			e.printStackTrace();
			Assert.fail("Vérifier l'appel de la méthode ajouter article la quantité est trop importante");
		}

		test = panier.articleDejaDansLePanier(article);
		Assert.assertTrue(test);
	}

	/**
	 * Teste l'ajout d'un nouvel article
	 *
	 * Ne doit pas lever d'erreur
	 */
	@Test
	public void testAjoutArticleSimple() {
		try {
			panier.ajouterUnArticle(article, 2);
			Assert.assertTrue(panier.articleDejaDansLePanier(article));
			Assert.assertEquals(2, panier.getLignePanier(article));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			Assert.fail(
					"Vérifier l'appel de la méthode ajouter article : l'article  demandée est invalide ou la quantitée est à 0 ");
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			e.printStackTrace();
			Assert.fail("Vérifier l'appel de la méthode ajouter article : la quantité demandée est supérieur au stock");
		}
	}

	/**
	 * Teste l'ajout cumulatif
	 *
	 * Ne doit pas lever d'erreur
	 */
	@Test
	public void testAjoutArticleCumulatif() {
		try {
			panier.ajouterUnArticle(article, 2);
			panier.ajouterUnArticle(article, 3);
			Assert.assertTrue(panier.articleDejaDansLePanier(article));
			Assert.assertEquals(5, panier.getLignePanier(article));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			Assert.fail(
					"Vérifier l'appel de la méthode ajouter article : l'article  demandée est invalide ou la quantitée est à 0 ");
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			e.printStackTrace();
			Assert.fail("Vérifier l'appel de la méthode ajouter article : la quantité demandée est supérieur au stock");
		}
	}

	/**
	 * Test si l'exception sstock est levée si on demande plus que le stock
	 * 
	 * @throws ExceptionQuantiteDemandeeSuperieureAuStock
	 * 
	 */
	@Test(expected = ExceptionQuantiteDemandeeSuperieureAuStock.class)
	public void testExceptionSimple() throws ExceptionQuantiteDemandeeSuperieureAuStock {
		try {
			panier.ajouterUnArticle(article, 1000);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			Assert.fail(
					"Vérifier l'appel de la méthode ajouter article : l'article  demandée est invalide ou la quantitée est à 0 ");
		}
	}

	/**
	 * Teste si l'exception stock est levée pour un teste cumulatif
	 * 
	 * @throws ExceptionQuantiteDemandeeSuperieureAuStock
	 * 
	 */
	@Test(expected = ExceptionQuantiteDemandeeSuperieureAuStock.class)
	public void testExceptionCumulatif() throws ExceptionQuantiteDemandeeSuperieureAuStock {
		try {
			panier.ajouterUnArticle(article, 3);
			panier.ajouterUnArticle(article, 3000);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			Assert.fail(
					"Vérifier l'appel de la méthode ajouter article : l'article  demandée est invalide ou la quantitée est à 0 ");
		}
	}

	/**
	 * Test si une exception illegal argument exception est levée pour un ajout
	 * avec une quantité à 0
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionQuantiteZero() {
		try {
			panier.ajouterUnArticle(article, 0);
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			e.printStackTrace();
			Assert.fail("Vérifier l'appel de la méthode ajouter article: la quantité demandée est supérieur au stock");
		}
	}

	/**
	 * Vérifie que la modification à 0 supprime l'article
	 */
	@Test
	public void testModificationAZero() {
		try {
			panier.ajouterUnArticle(article, 2);
			panier.modifierQuantiteLignePanier(article, 0);

			Assert.assertFalse(panier.articleDejaDansLePanier(article));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			e.printStackTrace();
			Assert.fail("Vérifier l'appel de la méthode ajouter article : la quantité demandée est supérieur au stock");
		}
	}

	/**
	 * Test si l'exception stock est levée si on ttende de modifier pour une
	 * quantité supérieur au stock
	 * @throws ExceptionQuantiteDemandeeSuperieureAuStock
	 * @throws IllegalArgumentException
	 */
	@Test(expected = ExceptionQuantiteDemandeeSuperieureAuStock.class)
	public void testModificationSuperieurStock0()
			throws IllegalArgumentException, ExceptionQuantiteDemandeeSuperieureAuStock {
		panier.ajouterUnArticle(article, 2);
		panier.modifierQuantiteLignePanier(article, 1234);
	}
	
	/**
	 * Vérifie que le total ht d'une ligne est bien calculer
	 * Ne doi pas remonter d'exception
	 */
	@Test
	public void calculTotalHt() {
		try {
			panier.ajouterUnArticle(article, 3);
			LignePanier lignePanier = panier.getLignePanier(article);
			
			double totalHt = article.getPrixHt() * lignePanier.getQuantite(); 
			
			Assert.assertEquals(totalHt, lignePanier.getTotalHt());
		} catch (IllegalArgumentException | ExceptionQuantiteDemandeeSuperieureAuStock e) {
			e.printStackTrace();
			Assert.fail("Vérifier l'appel à la méthode ajouter article : la quantité n'est pas valide");
		}
	}

}
