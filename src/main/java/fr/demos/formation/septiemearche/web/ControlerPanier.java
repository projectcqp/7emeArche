package fr.demos.formation.septiemearche.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.formation.septiemearche.exceptions.ExceptionQuantiteDemandeeSuperieureAuStock;
import fr.demos.formation.septiemearche.metier.Article;
import fr.demos.formation.septiemearche.metier.Panier;

@WebServlet("/ControlerPanier")
public class ControlerPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControlerPanier() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();
		
		// je récupère la requête et je renvoie vers la JSP
		RequestDispatcher rd = request.getRequestDispatcher("/Panier.jsp");
		rd.forward(request, response);
		
		//je renseigne la nouvelle jsp courante après chaque rd.forward (la même que le forward)
    	String jspCourante = "/Panier.jsp";
    	session.setAttribute("jspCourante", jspCourante);


	} // do get

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();

		// je stocke le paramêtre de requete (le name du bouton)
		String action = request.getParameter("action");


		
		// si on clique sur Voir le panier j'affiche la page Panier
		if (action != null && action.equals("Voir le panier")) {
			// je r�cup�re la requ�te et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/Panier.jsp");
			rd.forward(request, response);
			
			//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
	    	String jspCourante = "/Panier.jsp";
	    	session.setAttribute("jspCourante", jspCourante);
			
		} // si on clique sur voir le panier

	
		
		
// ########### événements Panier.jsp ###########
	
		
		// si on clique sur Modifier
		if (action != null && action.equals("Modifier")) {

			String stringQuantiteModifiee = request.getParameter("quantiteDansPanier");
			int intQuantiteModifiee = Integer.parseInt(stringQuantiteModifiee);

			String refArticleLigne = request.getParameter("refArticle");
		
			Panier p = (Panier) session.getAttribute("panier");

			try {
				p.modifierQuantiteLignePanier(refArticleLigne, intQuantiteModifiee);
			} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
				String message = e.getMessage();
				int quantiteStock = e.getQuantiteStock();
				
				String messageExceptionQDSAS = message + quantiteStock;
				request.setAttribute("ExceptionQuantiteDemandeeSuperieureAuStock", messageExceptionQDSAS);
				session.setAttribute("referenceArticlePanier", refArticleLigne);
			}
			
			// je récupère la requête et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/Panier.jsp");
			rd.forward(request, response);
			
			//je renseigne la nouvelle jsp courante après chaque rd.forward (la même que le forward)
	    	String jspCourante = "/Panier.jsp";
	    	session.setAttribute("jspCourante", jspCourante);
	    	
		} // si on clique sur modifier

		
		
		// si on clique sur supprimer
		if (action != null && action.equals("Supprimer")) {

			String refArticleLigne = request.getParameter("refArticle");
		
			Panier p = (Panier) session.getAttribute("panier");

			p.supprimerLignePanier(refArticleLigne);
			
			// je récupère la requête et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/Panier.jsp");
			rd.forward(request, response);
			
			//je renseigne la nouvelle jsp courante après chaque rd.forward (la même que le forward)
	    	String jspCourante = "/Panier.jsp";
	    	session.setAttribute("jspCourante", jspCourante);
			
		} // si on clic bouton supprimer	


	} // do post
}
