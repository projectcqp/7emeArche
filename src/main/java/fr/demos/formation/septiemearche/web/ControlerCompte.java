package fr.demos.formation.septiemearche.web;

import java.io.IOException;
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

import fr.demos.formation.septiemearche.data.CompteDao;
import fr.demos.formation.septiemearche.exceptions.ExceptionPasswordFail;
import fr.demos.formation.septiemearche.metier.Article;
import fr.demos.formation.septiemearche.metier.Compte;
import fr.demos.formation.septiemearche.metier.CompteLogin;

@WebServlet("/ControlerCompte")
public class ControlerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//à supprimer
	@Inject	private CompteLogin compteLoginCDI;
	
	@Inject	private CompteDao compteDao;
	
	private static Logger logger = Logger.getLogger("Log");
	
	// a g�rer dans Compte.java puis instancier un compte et le r�cup�rer
//	private boolean connecteAuCompte = false;

	public ControlerCompte() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();
		
		// je récupère la requ�te et je renvoie vers la JSP
		RequestDispatcher rd = request.getRequestDispatcher("/GestionCompte.jsp");
		rd.forward(request, response);
		
		//je renseigne la nouvelle jsp courante après chaque rd.forward (la même que le forward)
    	String jspCourante = "/GestionCompte.jsp";
    	session.setAttribute("jspCourante", jspCourante);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// je dis � tomcat d'utiliser les accente et caractères spéciaux
		request.setCharacterEncoding("UTF-8");
		
		// j'identifie et je stocke la session actuelle
		HttpSession session = request.getSession();
		
		// je stocke le param�tre de requete (le name du bouton)
		String action = request.getParameter("action");
		
		
		
		// on clique sur OK pour se connecter à un compte
		if (action != null && action.equals("Connexion")) {
						
			// je récupère email et password
			String emailP = request.getParameter("e_mail_compte");
			String email = emailP.toLowerCase();
			String password = request.getParameter("password_compte");
			Compte compteConnecte = null;
			try {
				
				compteConnecte = compteDao.select(email, password);
		    	session.setAttribute("compteSession", compteConnecte);
		    	
				if(compteConnecte == null){
					logger.error("Le compte session est null : " + compteConnecte);
			    	String messageErreurConnexion = "Echec connexion, l'email ou le mot de passe est erroné";
			    	request.setAttribute("messageErreurConnexion", messageErreurConnexion);
				} //if

	
			} catch (Exception e) {
				logger.fatal("exception connexion datasource SQL dans select(String email, String password) de CompteDao");
			}
			
			// je récupère la requête et je renvoie vers la JSP
			// pas besoin de changer la jspCourante car c'est la même
			String uriCible = (String)session.getAttribute("jspCourante");
			RequestDispatcher rd = request.getRequestDispatcher(uriCible);
			rd.forward(request, response);

		} // if connexion

			
			
		// if bouton Se  déconnecter
		if (session.getAttribute("compteSession") != null && action != null && action.equals("Deconnexion")) {

			// je d�connecte
			// je redéfinis la valeur de ma variable
			// il fait de l'autoboxing donc pas besoin de lui mettre un objet  mais la valeur compatible avec le type
			session.setAttribute("compteSession", null);
			
			// je récupère la requ�te et je renvoie vers la JSP
			// mais si je me d�connecte dans la page gestion de compte je dois changer de page !
			if (session.getAttribute("jspCourante").equals("/GestionCompte.jsp")){

				// on va dire qu'on retourne à l'acceuil apr�s une d�connexion du compte
				RequestDispatcher rd = request.getRequestDispatcher("/Accueil.jsp");
				rd.forward(request, response);

				//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
		    	String jspCourante = "/Accueil.jsp";
		    	session.setAttribute("jspCourante", jspCourante);
				
			} else {
			String uriCible = (String)session.getAttribute("jspCourante");
			RequestDispatcher rd = request.getRequestDispatcher(uriCible);
			rd.forward(request, response);
			// pas besoin de changer la jspCourante car c'est la même
			}
			
		} // if bouton Se déconnecter

		
		
		// if bouton Créer un Compte	
		if (session.getAttribute("compteSession") == null && action != null && action.equals("Creer un compte")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/CreerCompte.jsp");
			rd.forward(request, response);
			
			//je renseigne la nouvelle jsp courante après chaque rd.forward (la même que le forward)
	    	String jspCourante = "/CreerCompte.jsp";
	    	session.setAttribute("jspCourante", jspCourante);
			
		} // if bouton Cr�er un Compte
		
		// if bouton voir le compte	
		if (session.getAttribute("compteSession") != null && action != null && action.equals("Compte Utilisateur")) {

					RequestDispatcher rd = request.getRequestDispatcher("/GestionCompte.jsp");
					rd.forward(request, response);
					
					//je renseigne la nouvelle jsp courante après chaque rd.forward (la même que le forward)
			    	String jspCourante = "/GestionCompte.jsp";
			    	session.setAttribute("jspCourante", jspCourante);
					
				} // if bouton voir le compte

		// TODO gérer tentative de création de compte avec un email existant
		// ###	if bouton Valider (nouveau compte)   ###
		if (action != null && action.equals("Valider")) {
			
			// pour compte
			String paramEmail = request.getParameter("e_mail_compte");
			String paramPassword = request.getParameter("password_compte");
			String paramNom = request.getParameter("nom_compte");
			String paramPrenom = request.getParameter("prenom_compte");
			String paramTelephone = request.getParameter("telephone_compte");
			String paramDateNaissance = request.getParameter("dateNaissance_compte");
			// pour adresse facturation
			String paramVoie_adresse_facturation = request.getParameter("voie_adresse_facturation");
			String paramComplement_adresse_facturation = request.getParameter("complement_adresse_facturation");
			String paramCode_postal_adresse_facturation = request.getParameter("code_postal_adresse_facturation");
			String paramVille_adresse_facturation = request.getParameter("ville_adresse_facturation");
			String paramPays_adresse_facturation = request.getParameter("pays_adresse_facturation");
		
			// pour adresse livraison
			String paramVoie_adresse_livraison = request.getParameter("voie_adresse_livraison");
			String paramComplement_adresse_livraison = request.getParameter("complement_adresse_livraison");
			String paramCode_postal_adresse_livraison = request.getParameter("code_postal_adresse_livraison");
			String paramVille_adresse_livraison = request.getParameter("ville_adresse_livraison");
			String paramPays_adresse_livraison = request.getParameter("pays_adresse_livraison");
		
			// créer adresseFacturation
			// créer adresse livraison identique facturation ou comme renseignée dans formulaire
			
			//créer compte avec adresses
			Compte c=new Compte ();
			try {
				compteDao.insert(c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// je r�cup�re la requ�te et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/Validation_inscription.jsp");
			rd.forward(request, response);
			
			//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
	    	String jspCourante = "/Validation_inscription.jsp";
	    	session.setAttribute("jspCourante", jspCourante);

		} // if bouton Cr�er un Compte


	} // do post

}
