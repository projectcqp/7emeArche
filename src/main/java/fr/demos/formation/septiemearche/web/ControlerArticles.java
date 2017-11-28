package fr.demos.formation.septiemearche.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.formation.septiemearche.data.ArticleDao;
import fr.demos.formation.septiemearche.data.ArticleDiversDao;
import fr.demos.formation.septiemearche.data.LivreDao;
import fr.demos.formation.septiemearche.metier.Article;

@WebServlet("/ControlerArticles")
public class ControlerArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ArticleDao articleDaoCDI;

	private static final int RECORDS_PER_PAGE = 5;

	private static Logger logger = Logger.getLogger("Log");

	public ControlerArticles() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		int page = 1;
		List<Article> catalogue1 = new ArrayList<>();
		String pageString = request.getParameter("page");
		// cas de la gestion de la pagination : appui sur une href
		if (pageString != null) {
			page = Integer.parseInt(pageString);
			String critereRecherche = (String) session.getAttribute("critereRecherche");
			int firstOfPage = (page - 1) * RECORDS_PER_PAGE;
			try{
				catalogue1 = articleDaoCDI.selectSearch(critereRecherche, firstOfPage, RECORDS_PER_PAGE);
			}
			catch(Exception ex){
				logger.info("pb acces base de donnees pendant la recherche 1");
				request.setAttribute("messageErreur", "pb acces base de donnees pendant la recherche 1");
			}
			session.setAttribute("currentPage", page);
		}
		// cas de la recherche initiale, lors du premier appel de la fenetre
		// (sans critère de recherche)
		else {
			int noOfPages = 0;
			try{
				// on calcule le nombre de pages de resultats
				noOfPages = calculNbPagesPourPagination("");
				// on recupere les articles, en les paginant
				catalogue1 = articleDaoCDI.selectSearch("", 0, RECORDS_PER_PAGE);
				for (Article a:catalogue1){
					System.out.println("art " +a.getReference());
				}
			}
			catch(Exception ex){
				logger.info("pb acces base de donnees pendant la recherche 2");
				ex.printStackTrace();
				request.setAttribute("messageErreur", "pb acces base de donnees pendant la recherche 2");
			}
			session.setAttribute("critereRecherche", "");
			session.setAttribute("noOfPages", noOfPages);
			session.setAttribute("currentPage", 1);
		}
		
		session.setAttribute("catalogue1", catalogue1);
		// je renseigne la nouvelle jsp courante
		String jspCourante = "/Accueil.jsp";
		session.setAttribute("jspCourante",jspCourante);
		// appel de la vue
		RequestDispatcher rd = request.getRequestDispatcher("/Accueil.jsp");
		rd.forward(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		int page = 1;
		List<Article> catalogue1 = new ArrayList<>();
		
		String action = request.getParameter("action");
		// cas du lancement de la recherche par bouton rechercher avec critere
		if (action != null && action.equals("Rechercher")) {
			String critereRecherche = request.getParameter("recherche").toUpperCase();
			// on conserve le critere de recherche, tant qu'on ne fait pas une nouvelle recherche
			session.setAttribute("critereRecherche", critereRecherche);
			int noOfPages=0;	
			try{
				// on calcule le nombre de pages de resultats
				noOfPages = calculNbPagesPourPagination(critereRecherche);
				// on recupere les articles, en les paginant	
				catalogue1 = articleDaoCDI.selectSearch(critereRecherche, 0, RECORDS_PER_PAGE);
			}
			catch(Exception ex){
				logger.info("pb acces base de donnees pendant la recherche 3");
				request.setAttribute("messageErreur", "pb acces base de donnees pendant la recherche 3");
			}
			session.setAttribute("noOfPages", noOfPages);
			session.setAttribute("currentPage", 1);
		}
		session.setAttribute("catalogue1", catalogue1);
		
		// je renseigne la nouvelle jsp courante
		String jspCourante = "/Accueil.jsp";
		session.setAttribute("jspCourante", jspCourante);
		// appel de la vue
		RequestDispatcher rd = request.getRequestDispatcher("/Accueil.jsp");
		rd.forward(request, response);
	}

	private int calculNbPagesPourPagination(String rechercheCritere) {
		// nombre total d'articles issus de la recherche
		long noOfRecords = articleDaoCDI.countElementsSearch(rechercheCritere);
		// nombre de pages
		return (int) Math.ceil(noOfRecords * 1.0 / RECORDS_PER_PAGE);
	}


}