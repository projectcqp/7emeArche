package fr.demos.formation.septiemearche.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.formation.septiemearche.data.AdresseDao;
import fr.demos.formation.septiemearche.data.ArticleDiversDao;
import fr.demos.formation.septiemearche.data.CompteDao;
import fr.demos.formation.septiemearche.data.TvaDao;
import fr.demos.formation.septiemearche.metier.Adresse;
import fr.demos.formation.septiemearche.metier.ArticleDivers;
import fr.demos.formation.septiemearche.metier.Compte;
import fr.demos.formation.septiemearche.metier.Tva;

@WebServlet("/ControlerTestTva")
public class ControlerTestTva extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// appel de l'interface
	@Inject
	private TvaDao tvaDao;
	@Inject
	private AdresseDao adresseDao;
	@Inject
	private CompteDao compteDao;
	@Inject
	private ArticleDiversDao articleDiversDao;

	public ControlerTestTva() {
		super();
		// TODO Auto-generated constructor stub
	} // constructeur

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet controler tva");
		
		
// ######## TEST TvaDao ########	
		ArrayList<Tva> mesTva = null;
		
		// test tvaDao.selectAll()
		try {
			mesTva = (ArrayList<Tva>) tvaDao.selectAll();
			for (Tva tva : mesTva) {
				System.out.println("j'itère sur une tva : " + tva.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception dans selectAll TVA :" + e);
		}

		// test tvaDao.select(1)
		try {
			Tva tva = tvaDao.select("1");
			System.out.println("Voici la tva demandée : " + tva.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception dans select TVA :" + e);
		}
		
		// test tvaDao.selectSearch(normal ou 20.0 ou 3)
		ArrayList<Tva> mesTvaSearch = null;
		try {
			mesTvaSearch = (ArrayList<Tva>) tvaDao.selectSearch("intermédiaire");
			for (Tva tva : mesTvaSearch) {
				System.out.println("le criteria de recherche retourne une tva : " + tva.toString());
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception dans selectSearch TVA :" + e);
		}
// ######## Fin TEST TvaDao ########		

		
		
// ######## TEST AdresseDao ########
		ArrayList<Adresse> mesAdresses = null;
		
		// test adresseDao.selectAll()
		try {
			mesAdresses = (ArrayList<Adresse>) adresseDao.selectAll();
			for (Adresse adresse : mesAdresses) {
				System.out.println("j'itère sur une adresse : " + adresse.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception dans selectAll Adresse :" + e);
		}

		// test adresseDao.select(5)
		try {
			Adresse adresse = adresseDao.select("5");
			System.out.println("Voici l'adresse demandée : " + adresse.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception dans select Adresse :" + e);
		}
		
		// test adresseDao.selectSearch()
		ArrayList<Adresse> mesAdressesSearch = null;
		try {
//			mesAdressesSearch = (ArrayList<Adresse>) adresseDao.selectSearch("facturatio");
			mesAdressesSearch = (ArrayList<Adresse>) adresseDao.selectSearch("75013");
			for (Adresse adresse : mesAdressesSearch) {
				System.out.println("le criteria de recherche retourne une adresse : " + adresse.toString());
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception dans selectSearch Adresse :" + e);
		}
// ######## FIN TEST AdresseDao ########		
	
		
		
// ######## TEST CompteDao ########
		
		ArrayList<Compte> mesComptes = null;
		
		// test compteDao.selectAll()
		try {
			mesComptes = (ArrayList<Compte>) compteDao.selectAll();
			for (Compte compte : mesComptes) {
				System.out.println("j'itère sur un compte : " + compte.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception dans selectAll Compte :" + e);
		}
		
		
		// test compteDao.select(2)
		try {
			Compte compte = compteDao.select("2");
			System.out.println("Voici le compte demandé : " + compte.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception dans select Compte :" + e);
		}

		// test compteDao.selectSearch(	nom, email2, 4)
		ArrayList<Compte> mesComptesSearch = null;
		try {
			//mesComptesSearch = (ArrayList<Compte>) compteDao.selectSearch("nom");
			//mesComptesSearch = (ArrayList<Compte>) compteDao.selectSearch("email2");
			mesComptesSearch = (ArrayList<Compte>) compteDao.selectSearch("2");
			for (Compte compte : mesComptesSearch) {
				System.out.println("le criteria de recherche retourne un compte : " + compte.toString());
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception dans selectSearch Compte :" + e);
		}
		
// ######## FIN TEST CompteDao ########		
		
	

// ######## TEST ArticleDiversDao ########
		
				ArrayList<ArticleDivers> mesArticlesDivers = null;
				
				// test articleDiversDao.selectAll()
				try {
					mesArticlesDivers = (ArrayList<ArticleDivers>) articleDiversDao.selectAll();
					for (ArticleDivers articleDivers : mesArticlesDivers) {
						System.out.println("j'itère sur un compte : " + articleDivers.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("exception dans selectAll ArticleDivers :" + e);
				}
				
				
				// test mesArticlesDivers.select(2)
				try {
					ArticleDivers articleDivers = articleDiversDao.select("2");
					System.out.println("Voici l'article divers demandé : " + articleDivers.toString());
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("exception dans select ArticleDivers :" + e);
				}

				// test compteDao.selectSearch(dvd)
				ArrayList<ArticleDivers> mesArticlcesDiversSearch = null;
				try {
					//mes
					mesArticlcesDiversSearch = (ArrayList<ArticleDivers>) articleDiversDao.selectSearch("dvd");
					for (ArticleDivers articleDivers : mesArticlcesDiversSearch) {
						System.out.println("le criteria de recherche retourne un article divers : " + articleDivers.toString());
						}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("exception dans selectSearch ArticleDivers :" + e);
				}
				
// ######## FIN TEST ArticleDiversDao ########		
				
				
	}// do get

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}// do post

} // class
