package fr.demos.formation.septiemearche.metier;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livre")
public class Livre extends Article {
	
	@Column(name = "auteur_livre", nullable = false)
	private String auteur;
	@Column(name = "isbn_livre", nullable = false)
	private String isbn;
	@Column(name = "editeur_livre", nullable = false)
	private String editeur;
	@Column(name = "genre_livre", nullable = false)
	private String genre;
	@Column(name = "date_livre", nullable = false)
	private LocalDate date;
	
	// constructeur livre dematerialise
	public Livre(String argReference, double argPrixHt, String argNom, String argUrlImage, String argFormat, String argUrlDownload,
			String argAuteur, String argIsbn, String argEditeur, String argGenre) {
		super(argReference, argPrixHt, argNom, argUrlImage, argFormat, argUrlDownload);
		this.auteur = argAuteur;
		this.isbn = argIsbn;
		this.editeur = argEditeur;
		this.genre = argGenre;
	}
	
	// constructeur livre materialise neuf
	public Livre(String argReference, double argPrixHt, String argNom, String argUrlImage, int argStock,
			String argAuteur, String argIsbn, String argEditeur, String argGenre) {
		super(argReference, argPrixHt, argNom, argUrlImage, argStock);
		this.auteur = argAuteur;
		this.isbn = argIsbn;
		this.editeur = argEditeur;
		this.genre = argGenre;
	}

	// constructeur livre materialise non neuf
	public Livre(String argReference, double argPrixHt, String argNom, String argUrlImage, int argStock, Etat argEtat,
			String argAuteur, String argIsbn, String argEditeur, String argGenre) {
		super(argReference, argPrixHt, argNom, argUrlImage, argStock, argEtat);
		this.auteur = argAuteur;
		this.isbn = argIsbn;
		this.editeur = argEditeur;
		this.genre = argGenre;
	}

	@Override
	public String toString() {
		if (super.getMateriel() == null){		
		return "Livre Dematerialise [auteur=" + auteur + ", isbn=" + isbn + ", editeur=" + editeur + ", genre=" + genre + ", date="
				+ date + ", getPrixHt()=" + getPrixHt() + ", getRef()=" + getReference() + ", getNom()=" + getNom()
				+ ", getUrlImage()=" + getUrlImage() + ", getFormat()=" + super.getImmateriel().getFormat() + ", getUrlDownload()=" 
				+ super.getImmateriel().getUrlDownload() + "]";
		} else {
		return "Livre materiel [auteur=" + auteur + ", isbn=" + isbn + ", editeur=" + editeur + ", genre=" + genre + ", date="
				+ date + ", PrixHt=" + getPrixHt() + ", Ref=" + getReference() + ", Nom=" + getNom()
				+ ", getUrlImage()=" + getUrlImage() + ", mat�rialis�" + ", Stock=" + getStock() + ", Etat=" 
				+ super.getMateriel().getEtat() + "]";
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
