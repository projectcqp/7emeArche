package fr.demos.formation.septiemearche.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "article_divers")
@PrimaryKeyJoinColumn(name = "id_article_divers")
public class ArticleDivers extends Article {

	@Column(name = "type_article_divers")
	private String type;

	// constructeur vide pour hibernate
	public ArticleDivers() {
		super();
	}

	// constructeur article divers dematerialise
	public ArticleDivers(String argReference, double argPrixHt, String argNom, String argUrlImage, String argFormat,
			String argUrlDownload, String argType) {
		super(argReference, argPrixHt, argNom, argUrlImage, argFormat, argUrlDownload);
		this.type = argType;
	}

	// constructeur article divers materialise neuf
	public ArticleDivers(String argReference, double argPrixHt, String argNom, String argUrlImage, int argStock,
			String argType) {
		super(argReference, argPrixHt, argNom, argUrlImage, argStock);
		this.type = argType;
	}

	// constructeur article divers materialise non neuf
	public ArticleDivers(String argReference, double argPrixHt, String argNom, String argUrlImage, int argStock,
			Etat argEtat, String argType) {
		super(argReference, argPrixHt, argNom, argUrlImage, argStock, argEtat);
		this.type = argType;
	}

	@Override
	public String toString() {
		if (super.getMateriel() == null) {
			return "ArticleDivers [type=" + type + ", toString()=" + super.getImmateriel().getFormat()
					+ ", getUrlDownload()=" + super.getImmateriel().getUrlDownload() + "]";
		} else {
			return "ArticleDivers [type=" + type + ", toString()=" + ", Etat=" + super.getMateriel().getEtat() + "]";
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
