package fr.demos.formation.septiemearche.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import fr.demos.formation.septiemearche.data.ArticleDao;
import fr.demos.formation.septiemearche.data.ArticleDiversDao;
import fr.demos.formation.septiemearche.data.LivreDao;
import fr.demos.formation.septiemearche.metier.Article;

@WebServlet("/ControlerArticles")
public class ControlerArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// appel de l'interface on pourra choisir son dao si plusieurs
	@Inject
	ArticleDao articleDaoCDI;

	@Inject
	private ArticleDiversDao articleDiversDao;

	@Inject
	private LivreDao livreDao;

	private static Logger logger = Logger.getLogger("Log");

	public ControlerArticles() {
		super();
		// TODO Auto-generated constructor stub
	} // constructeur

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 1;
		int recordsPerPage = 5;

		HttpSession session = request.getSession();

		ArrayList<Article> catalogue = new ArrayList<Article>();
		try {
			catalogue = (ArrayList<Article>) articleDaoCDI.selectAll();
			session.setAttribute("catalogue", catalogue);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Le catalogue d'articles n'a pas été récupéré");
		}
	
		
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));

		ArrayList<Article> catalogue1;
		try {
			// calcule le premier élément du lot d'articles de la page - 1
			// car la méthode query.setFirstResult(firstOfPage) commence le compte à 0
			int firstOfPage = (page - 1) * recordsPerPage;
			catalogue1 = (ArrayList<Article>) articleDaoCDI.select(firstOfPage, recordsPerPage);

			// nombre total d'articles présents dans le catalogue global
			int noOfRecords = catalogue.size();

			// nombre de pages
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

			session.setAttribute("catalogue1", catalogue1);
			session.setAttribute("noOfPages", noOfPages);
			session.setAttribute("currentPage", page);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Les articles de la page n'ont pas pu être récupérés");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/Accueil.jsp");
		rd.forward(request, response);

		//TODO vérifier si jspCourante utilisée (après une recherche ?)
		// je renseigne la nouvelle jsp courante après chaque rd.forward
		String jspCourante = "/Accueil.jsp";
		session.setAttribute("jspCourante", jspCourante);

	}// do get

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// je dis à tomcat d'utiliser les accents et caract�res sp�ciaux
		request.setCharacterEncoding("UTF-8");

		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();

		// je stocke le paramètre de requete (le name du bouton)
		String action = request.getParameter("action");

		// si on clique sur Voir les articles j'affiche la page articles
		// TODO : vérification nom utilisateur et mdp pour valider connection

		// si bouton rechercher
		if (action != null && action.equals("Rechercher")) {

			// recherche va renseigner le "string critere" en argument de la
			// m�thode select
			String recherche = request.getParameter("recherche").toUpperCase();

			// version avec injection
			ArrayList<Article> catalogue;
			try {
				catalogue = (ArrayList<Article>) articleDaoCDI.selectSearch(recherche);
				session.setAttribute("catalogue", catalogue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			// je mets le critère de recherche dans la requete pour le cas où on
			// ne trouve rien
			String critereRecherche = request.getParameter("recherche");
			session.setAttribute("critereRecherche", critereRecherche);

			// je récupère la requête et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/Accueil.jsp");
			rd.forward(request, response);

			// je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la
			// même que le forward)
			String jspCourante = "/Accueil.jsp";
			session.setAttribute("jspCourante", jspCourante);

		} // if Rechercher

	}// do post

} // class
