package fr.demos.formation.septiemearche.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.formation.septiemearche.data.TvaDao;
import fr.demos.formation.septiemearche.metier.Tva;

@WebServlet("/ControlerTestTva")
public class ControlerTestTva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// appel de l'interface on pourra choisir son dao si plusieurs
	@Inject
	private TvaDao tvaDao;

	public ControlerTestTva() {
		super();
		// TODO Auto-generated constructor stub
	} // constructeur

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet controler tva");
		ArrayList<Tva> mesTva = null;
		
		// test tvaDao.selectAll()
		try {
			System.out.println("tvaDao.selectAll()");
			mesTva = (ArrayList<Tva>) tvaDao.selectAll();
			for (Tva tva : mesTva) {
				System.out.println("j'itère sur une tva : " + tva.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("exception dans selectAll TVA :" + e);
		}

		// test tvaDao.select(1)
		try {
			System.out.println("tvaDao.select(1)");
			Tva tva = tvaDao.select("1");
			System.out.println("Voici la tva demandée : " + tva.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("exception dans select TVA :" + e);
		}
		
	}// do get

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}// do post

} // class
