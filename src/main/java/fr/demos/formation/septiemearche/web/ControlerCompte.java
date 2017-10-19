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
import fr.demos.formation.septiemearche.data.CompteDao;
import fr.demos.formation.septiemearche.exceptions.ExceptionPasswordFail;
import fr.demos.formation.septiemearche.metier.Article;
import fr.demos.formation.septiemearche.metier.Compte;
import fr.demos.formation.septiemearche.metier.CompteLogin;

@WebServlet("/ControlerCompte")
public class ControlerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject	private CompteLogin compteLoginCDI;
	@Inject	private CompteDao compteDao;
	
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
		
		
		
		// je mets mon boolean connecteAuCompte en attribut de session pour
		// pouvoir utiliser EL
	//	session.setAttribute("connecteAuCompte", connecteAuCompte);

		// si on clique sur connection je me connecte
		// TODO ??? : v�rification nom utilisateur et mdp pour valider connection
		if (action != null && action.equals("Connexion")) {
						
			// je r�cup�re les email et password
			String emailP = request.getParameter("e_mail_compte");
			System.out.println("email" + emailP);
			String email = emailP.toLowerCase();
			String password = request.getParameter("password_compte");
			
			// je cr�e un objet pour tester ma connexion au compte
			//CompteLogin compteLogin = new CompteLogin();
			
			// j'appelle la m�thode pour me connecter avec les infos saisies dans la vue
			// et me retourner un compte ou null
			try {
				// remplacer par une vérification "ici" et supprimer compteLogin
				// Compte compteConnecte = compteLoginCDI.getCompteSiConnexionReussie(email, password);
				Compte compteConnecte = null;
				// compteDao.select(email,pwd) 
				
		    	session.setAttribute("compteSession", compteConnecte);
				if(compteConnecte == null){
					System.out.println("mon compteSession est null : " + compteConnecte);
			    	String messageErreurConnexion = "Echec connexion";
			    	request.setAttribute("messageErreurConnexion", messageErreurConnexion);
			    	// d�clencher un message mauvais identifiant ou email, exception ou pas ? pas de sortie en erreur...
				} //if

	
			} catch (Exception e) {
				System.out.println("exception connexion datasource SQL dans select(String email, String password) de CompteDAOMySql");			
			}
			
			//m�thode bourrin avant d'avoir un compte
//			// je red�fini la valeur de ma variable
//			// il fait de l'autoboxing donc pas besoin de lui mettre un objet  mais la valeur compatible avec le type
//			session.setAttribute("connecteAuCompte", true);

			// je r�cup�re la requ�te et je renvoie vers la JSP
			String uriCible = (String)session.getAttribute("jspCourante");
			RequestDispatcher rd = request.getRequestDispatcher(uriCible);
			rd.forward(request, response);

			// pas besoin de changer le jspCourante car c'est la m�me
		
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

		
		
		// if bouton voir le compte
		if (session.getAttribute("compteSession") != null && action != null && action.equals("Compte Utilisateur")) {
			// je r�cup�re la requ�te et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/GestionCompte.jsp");
			rd.forward(request, response);
			
			//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
	    	String jspCourante = "/GestionCompte.jsp";
	    	session.setAttribute("jspCourante", jspCourante);
			
		} // if bouton Voir le compte
		
		
		// if bouton Cr�er un Compte	
		if (session.getAttribute("compteSession") == null && action != null && action.equals("Creer un compte")) {
			
			// je r�cup�re la requ�te et je renvoie vers la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/CreerCompte.jsp");
			rd.forward(request, response);
			
			//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
	    	String jspCourante = "/CreerCompte.jsp";
	    	session.setAttribute("jspCourante", jspCourante);
			
		} // if bouton Cr�er un Compte
		
		// if bouton Cr�er un Compte	
		if (session.getAttribute("compteSession") != null && action != null && action.equals("Compte Utilisateur")) {

					// je r�cup�re la requ�te et je renvoie vers la JSP
					RequestDispatcher rd = request.getRequestDispatcher("/GestionCompte.jsp");
					rd.forward(request, response);
					
					//je renseigne la nouvelle jsp courante apr�s chaque rd.forward (la m�me que le forward)
			    	String jspCourante = "/GestionCompte.jsp";
			    	session.setAttribute("jspCourante", jspCourante);
					
				} // if bouton Cr�er un Compte

		
// ###	if bouton Valider (nouveau compte)   ###
		if (action != null && action.equals("Valider")) {
			
			
			String paramEmail = request.getParameter("e_mail_compte");
			String paramPassword = request.getParameter("password_compte");
			String paramNom = request.getParameter("nom_compte");
			String paramPrenom = request.getParameter("prenom_compte");
			String paramTelephone = request.getParameter("telephone_compte");
			String paramDateNaissance = request.getParameter("dateNaissance_compte");
			String paramAdresse = request.getParameter("adresse_compte");
			String paramAdresseLivraison = request.getParameter("adresse_livraison_compte");
			
			
			
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
