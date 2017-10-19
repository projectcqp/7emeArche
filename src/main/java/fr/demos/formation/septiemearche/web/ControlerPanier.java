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
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();
		
		// je r�cup�re la requ�te et je renvoie vers la JSP
		RequestDispatcher rd = request.getRequestDispatcher("/Panier.jsp");
		rd.forward(request, response);
		
		//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
    	String jspCourante = "/Panier.jsp";
    	session.setAttribute("jspCourante", jspCourante);


	} // do get

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// je dis � tomcat d'utiliser les accente et caract�res sp�ciaux
		request.setCharacterEncoding("UTF-8");
		
		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();

		// je stocke le param�tre de requete (le name du bouton)
		String action = request.getParameter("action");

// ########### �v�nements Article.jsp ###########
		// si on clique sur ajouter au panier
		// TODO : v�rification nom utilisateur et mdp pour valider connection
//		if (action != null && action.equals("Ajouter au panier")) {
//
//			// ### je r�cup�re la quantit� mais c'est un string ###
//			String stringQuantiteAjoutee = request.getParameter("quantiteAjouteePanier");
//			// transforme stringQuantit�Ajoutee en intQuantiteAjoutee
//			int intQuantiteAjoutee = Integer.parseInt(stringQuantiteAjoutee);
//
//			// ### je r�cupere la r�f de l'article ###
//			String refArticle = request.getParameter("refArticle");
//
//			// ### je r�cup�re l'arraylist du controlerArticle en le castant en arrayList
//			ArrayList<Article> catalogue = (ArrayList<Article>) session.getAttribute("catalogue");
//
//			// et je cherche l'article de cette r�f###
//			// pour chaque article du catalogue
//			for (Article article : catalogue) {
//				// l� o� r�f de l'article est la m�me que celle r�cup�r�e dans le bouton
//				if (article.getRef().equals(refArticle)) {
//					// Je me connecte au panier de la session en le castant
//					Panier p = (Panier) session.getAttribute("panier");
//					// ### je d�clenche la m�thode panier ajouterArticle###
//					try {
//						p.ajouterUnArticle(article, intQuantiteAjoutee);
//
//					} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
//						String message = e.getMessage();
//						int quantiteStock = e.getQuantiteStock();
//						// je mets les �l�ments du message dans une variable
//						// unique pour la mettre en argument du setAttribute
//						String messageExceptionQDSAS = message + quantiteStock;
//						// je mets � disposition le message en EL pour la requete
//						request.setAttribute("ExceptionQuantiteDemandeeSuperieureAuStock", messageExceptionQDSAS);
//						// je mets dans la session la r�f�rence de l'article mis
//						// dans le panier
//						session.setAttribute("referenceArticlePanier", refArticle);
//					}
//					// break pour arr�ter de boucler car on aura qu'une seule
//					// fois cet article (r�f�rence unique)
//					break;
//				} // if
//			} // for article catalogue
//			// je r�cup�re la requ�te et je renvoie vers la JSP
//			RequestDispatcher rd = request.getRequestDispatcher("/Articles.jsp");
//			rd.forward(request, response);
//			
//			//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
//	    	String jspCourante = "/Articles.jsp";
//	    	session.setAttribute("jspCourante", jspCourante);
//			
//		} // if bouton ajouter au panier

		
		// si on clique sur Voir le panier j'affiche la page Panier
		if (action != null && action.equals("Voir le panier")) {
			// je r�cup�re la requ�te et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/Panier.jsp");
			rd.forward(request, response);
			
			//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
	    	String jspCourante = "/Panier.jsp";
	    	session.setAttribute("jspCourante", jspCourante);
			
		} // si on clique sur voir le panier

	
		
		
// ########### �v�nements Panier.jsp ###########

		
		
		
		// si on clique sur Modifier
		if (action != null && action.equals("Modifier")) {

			// je r�cup�re la quantit� mais c'est un string
			String stringQuantiteModifiee = request.getParameter("quantiteDansPanier");
			// transforme stringQuantit�Ajoutee en intQuantiteAjoutee
			int intQuantiteModifiee = Integer.parseInt(stringQuantiteModifiee);

			// Je r�cupere la r�f de l'article pour identifier la ligne � modifier
			String refArticleLigne = request.getParameter("refArticle");
		
			// Je me connecte au panier de la session en le castant
			Panier p = (Panier) session.getAttribute("panier");

			// appel m�thode modifier quantite ligne panier
			try {
				p.modifierQuantiteLignePanier(refArticleLigne, intQuantiteModifiee);
			} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
				String message = e.getMessage();
				int quantiteStock = e.getQuantiteStock();
				// je mets les �l�ments du message dans une variable
				// unique pour la mettre en argument du setAttribute
				String messageExceptionQDSAS = message + quantiteStock;
				// je mets � disposition le message en EL pour la requete
				request.setAttribute("ExceptionQuantiteDemandeeSuperieureAuStock", messageExceptionQDSAS);
				// je mets dans la session la r�f�rence de l'article mis
				// dans le panier pour n'afficher l'exception que pour l'article concern�
				session.setAttribute("referenceArticlePanier", refArticleLigne);
			}
			
			// je r�cup�re la requ�te et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/Panier.jsp");
			rd.forward(request, response);
			
			//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
	    	String jspCourante = "/Panier.jsp";
	    	session.setAttribute("jspCourante", jspCourante);
	    	
		} // si on clique sur modifier

		
		
		// si on clique sur supprimer
		if (action != null && action.equals("Supprimer")) {

			// Je r�cupere la r�f de l'article pour identifier la ligne � supprimer
			String refArticleLigne = request.getParameter("refArticle");
		
			// Je me connecte au panier de la session en le castant
			Panier p = (Panier) session.getAttribute("panier");

			// je supprime la ligne panier
			// il faut la r�f�rence de la ligne � supprimer en argument
			
			p.supprimerLignePanier(refArticleLigne);
			
			// je r�cup�re la requ�te et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/Panier.jsp");
			rd.forward(request, response);
			
			//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
	    	String jspCourante = "/Panier.jsp";
	    	session.setAttribute("jspCourante", jspCourante);
			
		} // si on clic bouton supprimer	

	
	
	
	} // do post
}
