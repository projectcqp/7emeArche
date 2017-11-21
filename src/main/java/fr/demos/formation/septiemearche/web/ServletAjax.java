package fr.demos.formation.septiemearche.web;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class ServletAjax
 */
@WebServlet("/ServletAjax")
public class ServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet ajax");
		// je dis � tomcat d'utiliser les accente et caract�res sp�ciaux
		request.setCharacterEncoding("UTF-8");		
		
		// on utilise un outil printwriter car on sort de java
		// on en a besoin pour �crire sur le r�seau
		PrintWriter out = response.getWriter();
		
		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();

		// je stocke le param�tre de requete (la valeur du id du bouton)
		String actionBouton = request.getParameter("actionBouton");
		
		
		// si on clique sur ajouter au panier
		// TODO : v�rification nom utilisateur et mdp pour valider connection
		if (actionBouton != null && actionBouton.equals("boutonAjoutArticle")) {

			// ### je r�cup�re la quantit� mais c'est un string ###
			String stringQuantiteAjoutee = request.getParameter("quteAjoutPanier");
			// transforme stringQuantit�Ajoutee en intQuantiteAjoutee
			int intQuantiteAjoutee = Integer.parseInt(stringQuantiteAjoutee);

			// ### je r�cupere la r�f de l'article ###
			String refArticle = request.getParameter("idArticle");

			// ### je r�cup�re l'arraylist du controlerArticle en le castant en arrayList
			ArrayList<Article> catalogue1 = (ArrayList<Article>) session.getAttribute("catalogue1");

			// et je cherche l'article de cette r�f###
			// pour chaque article du catalogue
			for (Article article : catalogue1) {
				// l� o� r�f de l'article est la m�me que celle r�cup�r�e dans le bouton
				if (article.getReference().equals(refArticle)) {
					// Je me connecte au panier de la session en le castant
					Panier p = (Panier) session.getAttribute("panier");
					// ### je d�clenche la m�thode panier ajouterArticle###
					try {
						p.ajouterUnArticle(article, intQuantiteAjoutee);

						// je cr��e mon objet json pour le retour d'infos
						
						//on informe le navigateur du type mime
						response.setContentType("application/json");
						
						// je renvoie les infos en jason dans la r�ponse http vers la page jsp
						// la r�ception de cette r�ponse est l'�tape n� 4 du xhr.readyState
						//je g�n�re le jason manuellement mais on pourrait utiliser un outil pour le g�n�rer
						out.println("{\"nouveauQteCumuPanier\":" + p.getArticlesCumulesPanier() + ",\"nouveauPxTotalPanier\":" + p.getPrixTotal() + "}");
							
					} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
						String message = e.getMessage();
						int quantiteStock = e.getQuantiteStock();
						// je mets les �l�ments du message dans une variable
						// unique pour la mettre en argument du setAttribute
						String messageExceptionQDSAS = message + quantiteStock;
						// je mets � disposition le message en EL pour la requete
						request.setAttribute("ExceptionQuantiteDemandeeSuperieureAuStock", messageExceptionQDSAS);
						// je mets dans la session la référence de l'article mis
						// dans le panier
						session.setAttribute("referenceArticlePanier", refArticle);
					}
					// break pour arr�ter de boucler car on aura qu'une seule
					// fois cet article (référence unique)
					break;
				} // if
			} // for article catalogue
		
						
			
	    	
	    	
		} // if bouton ajouter au panier		
		
		
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
