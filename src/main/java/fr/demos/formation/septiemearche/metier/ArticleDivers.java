package fr.demos.formation.septiemearche.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "article_divers")
@PrimaryKeyJoinColumn(name = "id_article_article_divers")
public class ArticleDivers extends Article {

	@Column(name = "nature_article_divers", nullable = false)
	private String nature;

	// constructeur vide pour hibernate
	public ArticleDivers() {
	}

	// constructeur article divers dematerialise
	public ArticleDivers(String argReference, double argPrixHt, String argNom, String argUrlImage, Tva argTva, String argFormat,
			String argUrlDownload, String argNature) {
		super(argReference, argPrixHt, argNom, argUrlImage, argTva, argFormat, argUrlDownload);
		super.setType("ArticleDivers");
		this.nature = argNature;
	}

	// constructeur article divers materialise neuf
	public ArticleDivers(String argReference, double argPrixHt, String argNom, String argUrlImage, Tva argTva, int argStock,
			String argNature) {
		super(argReference, argPrixHt, argNom, argUrlImage, argTva, argStock);
		super.setType("ArticleDivers");
		this.nature = argNature;
	}

	// constructeur article divers materialise neuf ou non
	public ArticleDivers(String argReference, double argPrixHt, String argNom, String argUrlImage, Tva argTva, int argStock,
			Etat argEtat, String argNature) {
		super(argReference, argPrixHt, argNom, argUrlImage, argTva, argStock, argEtat);
		super.setType("ArticleDivers");
		this.nature = argNature;
	}

	@Override
	public String toString() {
		if (super.getMaterialise() == null) {
			return "ArticleDivers [nature=" + nature +  super.getDematerialise().getFormat() + "ref : " + getReference() + "nom article : " + getNom()
					+ ", getUrlDownload()=" + super.getDematerialise().getUrlDownload() + "]";
		} else {
			return "ArticleDivers [nature=" + nature + ", ref : " + getReference() + "nom article : " + getNom() +" , Etat=" + super.getMaterialise().getEtat() + "]";
		}
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

}
