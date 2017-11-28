package fr.demos.formation.septiemearche.web;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.demos.formation.septiemearche.data.ArticleDao;
import fr.demos.formation.septiemearche.metier.Article;
import fr.demos.formation.septiemearche.metier.Compte;
import fr.demos.formation.septiemearche.metier.Panier;

@WebListener
public class ListenerPanier implements HttpSessionListener {
	
	@Inject private ArticleDao articleDaoCDI;
	private static final int RECORDS_PER_PAGE = 5;
	
    public ListenerPanier() {
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
    	
    	ArrayList<Article> catalogue1;
    	
		try {
			catalogue1 = (ArrayList<Article>) articleDaoCDI.selectSearch("", 0, RECORDS_PER_PAGE);
	    	arg0.getSession().setAttribute("catalogue1", catalogue1);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	// je crée un panier au démarrage de la session
    	Panier p = new Panier();
    	arg0.getSession().setAttribute("panier", p);
    	
    	String jspCourante = "/test.jsp";
    	arg0.getSession().setAttribute("jspCourante", jspCourante);
    	
    	// Je mets compte dans la session
    	// si compte null je ne suis pas connecté à un compte
    	Compte compte = null;
    	arg0.getSession().setAttribute("compteSession", compte);

    	
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 

    }
	
}
