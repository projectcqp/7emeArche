package fr.demos.formation.septiemearche.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.demos.formation.septiemearche.exceptions.ExceptionQuantiteDemandeeSuperieureAuStock;
import fr.demos.formation.septiemearche.metier.ArticleDivers;
import fr.demos.formation.septiemearche.metier.Livre;
import fr.demos.formation.septiemearche.metier.Panier;

public class PanierMockitoTest {

	private Panier panier;
	private Livre livreNeufMock;
	private ArticleDivers articleDiversNeufMock;
	
	@Before
	public void setUp() throws Exception {
		
		panier = new Panier();
		
		// je crée mon mock
		livreNeufMock = mock(Livre.class);
		//je lui défini un comportement
		when(livreNeufMock.getPrixHt()).thenReturn(20.0);

		articleDiversNeufMock = mock(ArticleDivers.class);
		when(articleDiversNeufMock.getPrixHt()).thenReturn(12.0);
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPrixTotal() {
		try {
			panier.ajouterUnArticle(livreNeufMock, 1);
			panier.ajouterUnArticle(articleDiversNeufMock, 2);
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// lance le test
		assertEquals("vérification prix total", 44, panier.getPrixTotal(),0.01);

		// v�rifie si on a fait au moins une foit getPrixHt
		verify(livreNeufMock, atLeast(1)).getPrixHt();

	}

	@Test
	public void testGetArticlesCumulesPanier() {
		try {
			panier.ajouterUnArticle(livreNeufMock, 1);
			panier.ajouterUnArticle(articleDiversNeufMock, 2);
		} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("vérification quantité totale panier", 3, panier.getArticlesCumulesPanier());
	}
	
}
