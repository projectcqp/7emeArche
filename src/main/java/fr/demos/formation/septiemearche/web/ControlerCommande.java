package fr.demos.formation.septiemearche.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControlerCommande
 */
@WebServlet("/ControlerCommande")
public class ControlerCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlerCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();
		
		// je r�cup�re la requ�te et je renvoie vers la JSP
		RequestDispatcher rd = request.getRequestDispatcher("/Commande.jsp");
		rd.forward(request, response);
		
		//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
    	String jspCourante = "/Commande.jsp";
    	session.setAttribute("jspCourante", jspCourante);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// if bouton valider commande
	// test siconnect� ou non, il faut �tre connecte� pour commander	
	
	
	
	
	}

}
