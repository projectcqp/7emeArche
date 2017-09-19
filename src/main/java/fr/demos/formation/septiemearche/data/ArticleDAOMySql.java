package fr.demos.formation.septiemearche.data;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import fr.demos.formation.septiemearche.metier.Article;

public class ArticleDAOMySql implements ArticleDao {
	
	//plus besoin du context en CDI
	//private Context context;
	@Resource(mappedName="java:comp/env/jdbc/7emeArche")
	// on mets datasource � disposition
	private DataSource dataSource;
		
	// dans le constructeur je lance le context (annuaire) et le datasource (pool de connexion)
	public ArticleDAOMySql() throws Exception {
		
		//avant CDI
		//context = new InitialContext();
		//dataSource = (DataSource) context.lookup("java:comp/env/jdbc/CineGrandeArche");
	}

	@Override
	public void insert(Article a) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Article a) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Article a) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article select(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<Article> select(String critere) {

		ArrayList<Article> catalogue = new ArrayList<Article>();

		try (Connection cx = dataSource.getConnection()){
			
			PreparedStatement contexteRequeteLivre = null;
			PreparedStatement contexteRequeteArticleDivers = null;
			
			// si pas de crit�re de recherche, j'envoie toute la BDD
			if (critere.equals("")){
				contexteRequeteLivre = cx.prepareStatement(
				"SELECT * FROM Livre JOIN Article ON Livre.reference_livre=Article.reference_article ORDER BY Article.nom ASC");
			
				contexteRequeteArticleDivers = cx.prepareStatement(
				"SELECT * FROM Article_divers JOIN Article ON Article_divers.reference_article_divers=Article.reference_article ORDER BY Article.nom ASC");
								
			// sinon j'envoie la s�lection sur le crit�re de recherche
				// TODO recherche sur articles divers contexteRequeteArticleDivers
			} else {
				
				String critereSQL = "%"+critere+"%";
				// upper(colonne) pour tout mettre virtuellement en MAJ et pouvoir comparer
				// on a aussi mis le critere re�u en MAJ
				
// ##### LIVRE #####
				contexteRequeteLivre = cx.prepareStatement(
				"SELECT * FROM Livre JOIN Article ON Livre.reference_livre=Article.reference_article "
				+ "WHERE upper(Article.reference_article) LIKE ? "
				+ "OR upper(Article.prix) LIKE ? "				
				+ "OR upper(Article.nom) LIKE ? "
				+ "OR upper(Article.description) LIKE ? "
				+ "OR upper(Article.type_article) LIKE ? "
				+ "OR upper(Article.etat) LIKE ? "
				+ "OR upper(Article.format) LIKE ? "
				+ "OR upper(Livre.auteur) LIKE ? "
				+ "OR upper(Livre.isbn) LIKE ? "
				+ "OR upper(Livre.editeur) LIKE ? "
				+ "OR upper(Livre.genre) LIKE ? "
				+ "OR upper(Livre.date) LIKE ? "				
				+ "ORDER BY Article.nom ASC");

				// je renseigne les valeurs des "?"
				contexteRequeteLivre.setString(1, critereSQL);
				contexteRequeteLivre.setString(2, critereSQL);
				contexteRequeteLivre.setString(3, critereSQL);
				contexteRequeteLivre.setString(4, critereSQL);
				contexteRequeteLivre.setString(5, critereSQL);
				contexteRequeteLivre.setString(6, critereSQL);
				contexteRequeteLivre.setString(7, critereSQL);
				contexteRequeteLivre.setString(8, critereSQL);
				contexteRequeteLivre.setString(9, critereSQL);
				contexteRequeteLivre.setString(10, critereSQL);
				contexteRequeteLivre.setString(11, critereSQL);
				contexteRequeteLivre.setString(12, critereSQL);
				
// ##### Article divers #####				
				contexteRequeteArticleDivers = cx.prepareStatement(
				"SELECT * FROM Article_divers JOIN Article ON Article_divers.reference_article_divers=Article.reference_article "
				+ "WHERE upper(Article.reference_article) LIKE ? "
				+ "OR upper(Article.prix) LIKE ? "				
				+ "OR upper(Article.nom) LIKE ? "
				+ "OR upper(Article.description) LIKE ? "
				+ "OR upper(Article.type_article) LIKE ? "
				+ "OR upper(Article.etat) LIKE ? "
				+ "OR upper(Article.format) LIKE ? "
				+ "OR upper(Article_divers.type_article_divers) LIKE ? "
				+ "OR upper(Article_divers.caracteristiques) LIKE ?"
				+ "ORDER BY Article.nom ASC");

				// je renseigne les valeurs des "?"
				contexteRequeteArticleDivers.setString(1, critereSQL);
				contexteRequeteArticleDivers.setString(2, critereSQL);
				contexteRequeteArticleDivers.setString(3, critereSQL);
				contexteRequeteArticleDivers.setString(4, critereSQL);
				contexteRequeteArticleDivers.setString(5, critereSQL);
				contexteRequeteArticleDivers.setString(6, critereSQL);
				contexteRequeteArticleDivers.setString(7, critereSQL);
				contexteRequeteArticleDivers.setString(8, critereSQL);
				contexteRequeteArticleDivers.setString(9, critereSQL);
				
			}// if else
			
			// stockage de l'ensemble des r�sultats Livre qu'on peut parcourrir
			ResultSet rs = contexteRequeteLivre.executeQuery();
			
			// on parcours chaque �l�ment de l'objet
			while (rs.next()) {
				
				Livre livre;
				
				// je r�cup�re chaque enregistrement de la colonne dans une variable
				String ref = rs.getString("reference_article");
				String auteur = rs.getString("auteur");
				String isbn = rs.getString("isbn");
				String editeur = rs.getString("editeur");
				String genre = rs.getString("genre");
				LocalDate date = rs.getDate("date").toLocalDate();
				Double prix = rs.getDouble("prix");
				String nom = rs.getString("nom");
				String description = rs.getString("description");
				String url_image = rs.getString("url_image");
				int stock = rs.getInt("stock");
				String format = rs.getString("format");
				// etat � utiliser apr�s modif
				Etat etat;
				if (format.equals("")){
					etat = Etat.valueOf(rs.getString("etat"));
				} else {
					etat = null;
				}
				String url_download = rs.getString("url_download");
				
				// maintenant je cr�e une instance de livre avec les donn�es
				// r�cup�r�es en BDD pour pouvoir l'utiliser
				// je dois identifier s'il s'agit d'un livre mat�riel ou non
				// ajouter un if livre ou else article divers

				if (format.equals("")){
					livre = new Livre(ref, prix, nom, url_image, stock, etat, auteur, isbn, editeur, genre);
				} else {
					livre = new Livre(ref, prix, nom, url_image, format, url_download, auteur, isbn, editeur, genre);
				} // if else
			
			// je remplis les attribut non obligatoires (non d�finis dans le constructeur)
			livre.setDescription(description);
			livre.setDate(date);
			livre.setUrlImage(url_image);
			
			// j'ajoute le livre dans mon catalogue
			catalogue.add(livre);
			
			} // while Livre next
			
			
			
			// stockage de l'ensemble des r�sultats article_divers qu'on peut parcourrir
			ResultSet rs2 = contexteRequeteArticleDivers.executeQuery();
			
			// on parcours caque �l�ment de l'objet
			while (rs2.next()) {
				
				ArticleDivers articleDivers;
				
				// je r�cup�re chaque enregistrement de la colonne dans une variable
				// attributs d'un article
				String ref = rs2.getString("reference_article");
				Double prix = rs2.getDouble("prix");
				String nom = rs2.getString("nom");
				String description = rs2.getString("description");
				String url_image = rs2.getString("url_image");
				Type type_article = Type.valueOf(rs2.getString("type_article"));
				int stock = rs2.getInt("stock");
				String format = rs2.getString("format");
				Etat etat;
				if (format.equals("")){
					etat = Etat.valueOf(rs2.getString("etat"));
				} else {
					etat = null;
				}
				String url_download = rs2.getString("url_download");
				
				// attributs d'un article divers
				String type_article_divers = rs2.getString("type_article_divers");
				String caracteristiques = rs2.getString("caracteristiques");
								
				// maintenant je cr�e une instance de article divers avec les donn�es
				// r�cup�r�es en BDD pour pouvoir l'utiliser
				// je dois identifier s'il s'agit d'un article mat�riel ou non

				if (format.equals("")){
					articleDivers = new ArticleDivers(ref, prix, nom, url_image, stock, etat, type_article_divers, caracteristiques);
				} else {
					articleDivers = new ArticleDivers(ref, prix, nom, url_image, format, url_download, type_article_divers, caracteristiques);
				} // if else
			
			// je remplis les attribut non obligatoires (non d�finis dans le constructeur)
			articleDivers.setDescription(description);
			
			// j'ajoute le livre dans mon catalogue
			catalogue.add(articleDivers);
			
			} // while articleDivers next

			
			
			
			
		
		} //try de la connexion
		catch (Exception ex) {
			ex.printStackTrace();
		} // try catch
		
		return catalogue;
	} // override select
*/
}// class
