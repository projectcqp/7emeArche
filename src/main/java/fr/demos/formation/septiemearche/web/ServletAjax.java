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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet ajax");
		request.setCharacterEncoding("UTF-8");		
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();

		String actionBouton = request.getParameter("actionBouton");
		
		
		// si on clique sur ajouter au panier
		if (actionBouton != null && actionBouton.equals("boutonAjoutArticle")) {

			String stringQuantiteAjoutee = request.getParameter("quteAjoutPanier");
			int intQuantiteAjoutee = Integer.parseInt(stringQuantiteAjoutee);

			String refArticle = request.getParameter("idArticle");

			ArrayList<Article> catalogue1 = (ArrayList<Article>) session.getAttribute("catalogue1");

			for (Article article : catalogue1) {
				if (article.getReference().equals(refArticle)) {
					Panier p = (Panier) session.getAttribute("panier");
					response.setContentType("application/json");
					try {
						p.ajouterUnArticle(article, intQuantiteAjoutee);

						out.println("{\"nouveauQteCumuPanier\":" + p.getArticlesCumulesPanier() + ",\"nouveauPxTotalPanier\":" + p.getMontantTotalHorsTaxes() + ",\"nouveauMessageErreurAjoutPanier\":\"\"" + "}");
							
					} catch (ExceptionQuantiteDemandeeSuperieureAuStock e) {
						String message = e.getMessage();
						int quantiteStock = e.getQuantiteStock();
						String messageExceptionQDSAS = message + quantiteStock;
						request.setAttribute("ExceptionQuantiteDemandeeSuperieureAuStock", messageExceptionQDSAS);
						session.setAttribute("referenceArticlePanier", refArticle);
						
						System.out.println("{\"nouveauMessageErreurAjoutPanier\":\""+messageExceptionQDSAS + "\"}");
						out.println("{\"nouveauQteCumuPanier\":" + p.getArticlesCumulesPanier() + ",\"nouveauPxTotalPanier\":" + p.getMontantTotalHorsTaxes() + ",\"nouveauMessageErreurAjoutPanier\":\""+messageExceptionQDSAS + "\"}");

					}
					// break pour arr�ter de boucler car on aura qu'une seule
					// fois cet article (référence unique)
					break;
				} // if
			} // for article catalogue
		
		} // if bouton ajouter au panier		
			
	} // doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Renvoie les POST vers le doGet
		doGet(request, response);
	}

}
