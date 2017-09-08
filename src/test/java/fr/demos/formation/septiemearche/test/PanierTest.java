package fr.demos.formation.septiemearche.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.demos.formation.septiemearche.exceptions.ExceptionQuantiteDemandeeSuperieureAuStock;
import fr.demos.formation.septiemearche.metier.ArticleDivers;
import fr.demos.formation.septiemearche.metier.Etat;
import fr.demos.formation.septiemearche.metier.Livre;
import fr.demos.formation.septiemearche.metier.Panier;

public class PanierTest {
	
	Panier p;
	// à mockiter dans le before
	Livre lNeuf;
	Livre lOccasion;
	Livre lDemat;
	ArticleDivers adNeuf;
	ArticleDivers adOccasion;
	ArticleDivers adDemat;
	
	

	// 6 article (livre/art divers : neuf/pas neuf/immat)
	// tester en premier l'insertion des lignes panier et les insérer dans chaque test (4 lignes)
	@Before
	public void setUp() throws Exception {
		
		// ### livre standard matériel neuf ###
//		lNeuf = new Livre("refDuLivreLNeuf", 20.00, "nomLNeuf", "UrlImageLNeuf", 10, "auteur de lNeuf", "isbn de lNeuf", "editeur de lNeuf", "genre de lNeuf");	

		//livre standard matériel occasion
		lOccasion = new Livre("refDuLivreLOccasion", 15.00, "nomLOccasion", "UrlImageLOccasion", 10, Etat.OCCASION_MOYEN, "auteur de lOccasion", "isbn de lOccasion", "editeur de lOccasion", "genre de lOccasion");
		//livre dématerialise
		lDemat = new Livre("refDuLivreLDemat", 10.00, "nomLDemat", "UrlLDemat", "format lDemat", "URL telechargement lDemat",
				"auteur lDemat", "isbn lDemat", "editeur lDemat", "genre lDemat");

		//Article divers standard matériel neuf
		adNeuf = new ArticleDivers("refAdNeuf", 12.00, "nom adNeuf", "URL image adNeuf", 10, "type article adNeuf", "caractéristiques adNeuf");
		//Article divers matériel occasion
		adOccasion = new ArticleDivers("refAdOccasion", 8.00, "nom adOccasion", "URL image adOccasion", 10, Etat.OCCASION_MOYEN, "type articel adOccasion", "caractéristique adOccasion");
		//Article divers dématérialisé"
		adDemat = new ArticleDivers("refAdDemat", 8.00, "nom adDemat", "URL image adDemat", "format adDemat", "URL download adDemat","type article adDemat", "caractéristiques adDemat");		
		
		p = new Panier();
		
	}

	@After
	public void tearDown() throws Exception {
	}

// ##### Je décide de tester chaque constructeur sur la création de la nouvelle ligne #####
	
	// ### Livre Neuf - CREATION ###
	@Test
	public void testCreationLignePanierLivreMatNeuf() {

		try {
			p.ajouterUnArticle(lNeuf, 1);
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Livre matériel neuf bien ajouté ?
		assertEquals("lignePanier livreMat Neuf non inséré", "refDuLivreLNeuf", p.iterator().next().getArticle().getRef());
		
		// Y a il bien un seul article ? (sans utiliser la méthode de panier)
		int i = 0;
		Iterator it= p.iterator();
		while (it.hasNext()){
			i++;
			it.next();
		}
		assertEquals("une ou plusieurs lignePanier de trop", 1, i);	
	} // test

	
	
	// ### Livre Occasion - CREATION ###
	@Test
	public void testCreationLignePanierLivreMatOccasion() {
		
		try {
			p.ajouterUnArticle(lOccasion, 1);
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Livre matériel neuf bien ajouté ?
		assertEquals("lignePanier livreMat Occasion non inséré", "refDuLivreLOccasion", p.iterator().next().getArticle().getRef());
		
		// Y a il bien un seul article ? (sans utiliser la méthode de panier)
		int i = 0;
		Iterator it= p.iterator();
		while (it.hasNext()){
			i++;
			it.next();
		}
		assertEquals("une ou plusieurs lignePanier de trop", 1, i);	
	} // test
	
	
	// ### Livre dématérialisé - CREATION ###
	@Test
	public void testCreationLignePanierLivreDemat() {
		
		try {
			p.ajouterUnArticle(lDemat, 1);
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Livre matériel neuf bien ajouté ?
		assertEquals("lignePanier livre Démat non inséré", "refDuLivreLDemat", p.iterator().next().getArticle().getRef());
		
		// Y a il bien un seul article ? (sans utiliser la méthode de panier)
		int i = 0;
		Iterator it= p.iterator();
		while (it.hasNext()){
			i++;
			it.next();
		}
		assertEquals("une ou plusieurs lignePanier de trop", 1, i);	
	} // test
	
	
	
	// ### ArticleDivers Neuf - CREATION ###
	@Test
	public void testCreationLignePanierArticleDiversNeuf() {
		
		try {
			p.ajouterUnArticle(adNeuf, 1);
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Livre matériel neuf bien ajouté ?
		assertEquals("lignePanier article divers Neuf non inséré", "refAdNeuf", p.iterator().next().getArticle().getRef());
		
		// Y a il bien un seul article ? (sans utiliser la méthode de panier)
		int i = 0;
		Iterator it= p.iterator();
		while (it.hasNext()){
			i++;
			it.next();
		}
		assertEquals("une ou plusieurs lignePanier de trop", 1, i);	
	} // test
	
	
	
	// ### ArticleDivers Occasion - CREATION ###
	@Test
	public void testCreationLignePanierArticleDiversOccasion() {
		
		try {
			p.ajouterUnArticle(adOccasion, 1);
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Livre matériel neuf bien ajouté ?
		assertEquals("lignePanier article divers Occasion non inséré", "refAdOccasion", p.iterator().next().getArticle().getRef());
		
		// Y a il bien un seul article ? (sans utiliser la méthode de panier)
		int i = 0;
		Iterator it= p.iterator();
		while (it.hasNext()){
			i++;
			it.next();
		}
		assertEquals("une ou plusieurs lignePanier de trop", 1, i);	
	} // test
	
	
	
	// ### ArticleDivers dématérialisé - CREATION ###
	@Test
	public void testCreationLignePanierArticleDiversDemat() {
		
		try {
			p.ajouterUnArticle(adDemat, 1);
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Livre matériel neuf bien ajouté ?
		assertEquals("lignePanier article divers dématérialisé non inséré", "refAdDemat", p.iterator().next().getArticle().getRef());
		
		// Y a il bien un seul article ? (sans utiliser la méthode de panier)
		int i = 0;
		Iterator it= p.iterator();
		while (it.hasNext()){
			i++;
			it.next();
		}
		assertEquals("une ou plusieurs lignePanier de trop", 1, i);	
	} // test
	
	
	
// ##### Je teste l'ajout d'un article sur lignePanier éxistante #####
	
	// ### Livre Neuf - AUGMENTATION QTE ###
	@Test
	public void testAjouterLivreNeufLigneExistante(){
		
		try {
			p.ajouterUnArticle(lNeuf, 1);
			p.ajouterUnArticle(lNeuf, 1);
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
