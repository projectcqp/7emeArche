package fr.demos.formation.septiemearche.metier;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "livre")
@PrimaryKeyJoinColumn(name = "id_article_livre")
public class Livre extends Article {
		
	@Column(name = "auteur_livre", nullable = false)
	private String auteur;
	
	@Column(name = "isbn_livre", nullable = false)
	private String isbn;
	
	@Column(name = "editeur_livre", nullable = false)
	private String editeur;
	
	@Column(name = "genre_livre", nullable = false)
	private String genre;
	
	//TODO type, stockage et mettre dans constructeurs et toString
	//@Column(name = "date_livre", nullable = false)
	@Transient
	private LocalDate date;
	
	// Constructeur vide pour hibernate
	public Livre(){
	}
	
	// constructeur livre dematerialise
	public Livre(String argReference, double argPrixHt, String argNom, String argUrlImage, Tva argTva, String argFormat, String argUrlDownload,
			String argAuteur, String argIsbn, String argEditeur, String argGenre) {
		super(argReference, argPrixHt, argNom, argUrlImage, argTva, argFormat, argUrlDownload);
		super.setType("Livre");
		this.auteur = argAuteur;
		this.isbn = argIsbn;
		this.editeur = argEditeur;
		this.genre = argGenre;
	}
	
	// constructeur livre materialise neuf
	public Livre(String argReference, double argPrixHt, String argNom, String argUrlImage, Tva argTva, int argStock,
			String argAuteur, String argIsbn, String argEditeur, String argGenre) {
		super(argReference, argPrixHt, argNom, argUrlImage, argTva, argStock);
		super.setType("Livre");
		this.auteur = argAuteur;
		this.isbn = argIsbn;
		this.editeur = argEditeur;
		this.genre = argGenre;
	}

	// constructeur livre materialise non neuf
	public Livre(String argReference, double argPrixHt, String argNom, String argUrlImage, Tva argTva, int argStock, Etat argEtat,
			String argAuteur, String argIsbn, String argEditeur, String argGenre) {
		super(argReference, argPrixHt, argNom, argUrlImage, argTva, argStock, argEtat);
		super.setType("Livre");
		this.auteur = argAuteur;
		this.isbn = argIsbn;
		this.editeur = argEditeur;
		this.genre = argGenre;
	}

	@Override
	public String toString() {
		if (super.getMaterialise() == null){		
		return "Livre Dematerialise [auteur=" + auteur + ", isbn=" + isbn + ", editeur=" + editeur + ", genre=" + genre + ", date="
				+ date + ", getPrixHt()=" + getPrixHt() + ", getRef()=" + getReference() + ", getNom()=" + getNom()
				+ ", getUrlImage()=" + getUrlImage() + ", getFormat()=" + super.getDematerialise().getFormat() + ", getUrlDownload()=" 
				+ super.getDematerialise().getUrlDownload() + "]";
		} else {
		return "Livre materiel [auteur=" + auteur + ", isbn=" + isbn + ", editeur=" + editeur + ", genre=" + genre + ", date="
				+ date + ", PrixHt=" + getPrixHt() + ", Ref=" + getReference() + ", Nom=" + getNom()
				+ ", getUrlImage()=" + getUrlImage() + ", mat�rialis�" + ", Stock=" + getStock() + ", Etat=" 
				+ super.getMaterialise().getEtat() + "]";
		}
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
