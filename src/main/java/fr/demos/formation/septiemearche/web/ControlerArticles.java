package fr.demos.formation.septiemearche.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.formation.poe.cinegrandearche.data.ArticleDAO;
import fr.demos.formation.poe.cinegrandearche.data.ArticleDAOMySql;
import fr.demos.formation.poe.cinegrandearche.metier.Article;
import fr.demos.formation.poe.cinegrandearche.metier.Livre;

@WebServlet("/ControlerArticles")
public class ControlerArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// appel de l'interface on pourra choisir son dao si plusieurs
	@Inject ArticleDAO articleDaoCDI;


	public ControlerArticles() {
		super();
		// TODO Auto-generated constructor stub
	} // constructeur

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();

		// je r�cup�re la requ�te et je renvoie vers la JSP
		RequestDispatcher rd = request.getRequestDispatcher("/Articles.jsp");
		rd.forward(request, response);

		// je renseigne la nouvelle jsp courante apr�s chaque rd.forward
		String jspCourante = "/Articles.jsp";
		session.setAttribute("jspCourante", jspCourante);

	}// do get

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// je dis � tomcat d'utiliser les accents et caract�res sp�ciaux
		request.setCharacterEncoding("UTF-8");

		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();

		// je stocke le param�tre de requete (le name du bouton)
		String action = request.getParameter("action");

		// si on clique sur Voir les articles j'affiche la page articles
		// TODO : v�rification nom utilisateur et mdp pour valider connection
		if (action != null && action.equals("Voir les articles")) {

			// je r�cup�re la requ�te et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/Articles.jsp");
			rd.forward(request, response);

			// je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la
			// m�me que le forward)
			String jspCourante = "/Articles.jsp";
			session.setAttribute("jspCourante", jspCourante);

		} // if bouton Voir les articles

		// si bouton rechercher
		if (action != null && action.equals("Rechercher")) {
			
			// recherche va renseigner le "string critere" en argument de la m�thode select
			String recherche = request.getParameter("recherche").toUpperCase();
			
			// chercher en BDD les correspondance
			// it�rer et mettre les r�sultats dans catalogue dans session
			// apr�s une recherche on ne remet pas le catalogue � son �tat d'avant la recherche
			// il faudra faire une nouvelle recherche ou appeler select sans argument
			
			//ancienne version
//			try {
//				ArticleDAOMySql articleDAOMySql = new ArticleDAOMySql();
//				ArrayList<Article> catalogue = (ArrayList<Article>) articleDAOMySql.select(recherche);
//				session.setAttribute("catalogue", catalogue);
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			// version avec injection
			ArrayList<Article> catalogue = (ArrayList<Article>) articleDaoCDI.select(recherche);
			session.setAttribute("catalogue", catalogue);

			
			//je mets le crit�re de recherche dans la requete pour le cas o� on ne trouve rien
			String critereRecherche = request.getParameter("recherche");
			session.setAttribute("critereRecherche", critereRecherche);
			
			// je r�cup�re la requ�te et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/Articles.jsp");
			rd.forward(request, response);

			// je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la
			// m�me que le forward)
			String jspCourante = "/Articles.jsp";
			session.setAttribute("jspCourante", jspCourante);
			
		}// if Rechercher

		
		
	}// do post

} // class
}