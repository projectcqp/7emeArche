package fr.demos.formation.septiemearche.test;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.demos.formation.septiemearche.metier.Adresse;
import fr.demos.formation.septiemearche.metier.Article;
import fr.demos.formation.septiemearche.metier.Commande;
import fr.demos.formation.septiemearche.metier.Compte;
import fr.demos.formation.septiemearche.metier.Etat;
import fr.demos.formation.septiemearche.metier.Livre;
import fr.demos.formation.septiemearche.metier.Panier;
import fr.demos.formation.septiemearche.metier.Tva;


/**
 * @author STAGIAIRE
 *
 */
public class CommandeTest {
		private Panier panier;
		private Commande commande;
	
	@Before
	public void initPanier() {
		panier = new Panier();

panier.ajouterUnArticle(new Livre("Reference", 10, "Nom", "UrlImage", new Tva(1, 10, "A"), 10, Etat.OCCASION_BON, "Auteur", "Isbn","Editeur", "Genre"), 1);
///panier.ajouterUnArticle(new Livre("Reference", 13, "Nom", "UrlImage", new Tva(1, 10, "A"), "Format", "UrlDownload", "auteur", "Isbn", "Editeur", "enre";
		///panier.ajouterUnArticle(a, quantiteAjoutee);new ArticleDivers("Reference", 10, "Nom", "UrlImage", new Tva(1, 10, "a"), 10, "nature");getClass()


commande = new Commande(panier);
	}

	public CommandeTest(Article article) {}

	/**
	 * Test si le panier et la commande on le même nombre de lignes
	 * 
	 */
	@Test
	public void testNombreLignes() {
		Assert.assertEquals(
		panier.getSizeContenuPanier(),
		commande.getSize()
		);
	}
	
	/**
	 * Test si le panier et la commande on le même nombre d'article
	 * 
	 */
	@Test
	public void testNombreArticles() {
		Assert.assertEquals(
				panier.getArticlesCumulesPanier(),
		commande.getNombreArticle());
	}
	
	/**
	 * Test si le montant total ht du panier  et de la commande sont identique
	 * 
	 */
	@Test
	public void testTotalHt() {
		Assert.assertEquals(
				panier.getMontantTotalHorsTaxes(),
				commande.getTotalHt());
	}
	
	/**
	 * Test si le montant de la TVA du panier  et de la commande sont identiques
	 * 
	 */
	@Test
	public void testTotalTva() {
		Assert.assertEquals(
				panier.getMontantTva(),
				commande.getMontantTva());
	}
	
}
