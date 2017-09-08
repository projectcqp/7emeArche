package fr.demos.formation.septiemearche.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.formation.septiemearche.metier.Compte;
import fr.demos.formation.septiemearche.metier.Panier;

/**
 * Servlet implementation class ControlerCommande
 */
@WebServlet("/ControlerCommande")
public class ControlerCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// déroulement de la commande
	// le client est dans la page ou il clique pour valider sa commande en déclenchant son paiement
	// interception par ControllerCommande en doPost, déclenche création commande
	// enregistrement commande dans BDD
	// select de la commande en BDD et affichage de la facture prête à imprimer
	
    public ControlerCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// je dis a tomcat d'utiliser les accents et caracteres speciaux
		request.setCharacterEncoding("UTF-8");
				
		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();

		// je stocke le param�tre de requete (le name du bouton)
		String action = request.getParameter("action");
		
		if (action != null && action.equals("Valider le paiement")) {
		// création commande
			// Je me connecte au panier de la session en le castant
			Panier p = (Panier) session.getAttribute("panier");
			// Je récupère le compte
			Compte c = (Compte) session.getAttribute("compte");
			
			if (c == null){
				//exception client non connecté à un compte commande impossible
			} else {
				// insert commande
				
				// select commande
				// afficher facture
				
				
				
			}
			
			
		} // si on clique sur Valider le paiement
		
		

		
	// if bouton valider commande
	// test siconnect� ou non, il faut �tre connecte� pour commander	
	
	
	
	
	}

}
