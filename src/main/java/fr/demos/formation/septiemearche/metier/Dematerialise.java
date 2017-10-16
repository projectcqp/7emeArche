package fr.demos.formation.septiemearche.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dematerialise")
public class Dematerialise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_dematerialise")
	private int id;
	
	@Column(name = "format_dematerialise")
	private String format;
	
	@Column(name = "url_download_dematerialise")
	private String urlDownload;
	
	// constructeur vide pour hibernate
	public Dematerialise() {
		super();
	}
	
	// id est à 0, il sera renseigné par hibernate lors du premier enregistrement en BDD
	public Dematerialise(String format, String urlDownload) {
		super();
		this.format = format;
		this.urlDownload = urlDownload;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getUrlDownload() {
		return urlDownload;
	}

	public void setUrlDownload(String urlDownload) {
		this.urlDownload = urlDownload;
	}

	@Override
	public String toString() {
		return "Dematerialise [id=" + id + ", format=" + format + ", urlDownload=" + urlDownload + "]";
	}
	
	
}
