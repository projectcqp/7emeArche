package fr.demos.formation.septiemearche.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_article")
	private int id;
	@Column(name="reference_article", nullable = false)
	private String reference;
	@Column(name = "prix_ht_article", nullable = false)
	private double prixHt;
	@Column(name = "nom_article", nullable = false)
	private String nom;
	@Column(name = "description_article", nullable = false)
	private String description;
	@Column(name = "url_image_article", nullable = false)
	private String urlImage;
	@OneToOne
	private Materialise materiel;
	@OneToOne
	private Dematerialise immateriel;
	@Column(name = "stock_article")
	private int stock;
	@ManyToOne
	private Tva tva;

	
	// constructeur vide pour hibernate
	public Article() {
		super();
	}
	
	// constructeur si dematerialise pdf, iso, exe...
	// id est à 0, il sera renseigné par hibernate lors du premier enregistrement en BDD
	public Article(String argReference, double argPrixHt, String argNom, String argUrlImage, String argFormat, String argUrlDownload) {
		super();
		this.reference = argReference;
		this.prixHt = argPrixHt;
		this.nom = argNom;
		this.urlImage = argUrlImage;
		this.stock = 1;
		this.immateriel = new Dematerialise(argFormat, argUrlDownload);
	}

	// constructeur si materialise et neuf car 80% de l'activite = livres neufs
	// id est à 0, il sera renseigné par hibernate losr du premier enregistrement en BDD
	public Article(String argReference, double argPrixHt, String argNom, String argUrlImage, int argStock) {
		super();
		this.reference = argReference;
		this.prixHt = argPrixHt;
		this.nom = argNom;
		this.urlImage = argUrlImage;
		this.stock = argStock;
		this.materiel = new Materialise(Etat.NEUF);
	}

	// constructeur si materialise livre, dvd, cd...
	// + arguments stock et etat)
	// id est à 0, il sera renseigné par hibernate losr du premier enregistrement en BDD
	public Article(String argReference, double argPrixHt, String argNom, String argUrlImage, int argStock, Etat argEtat) {
		super();
		this.reference = argReference;
		this.prixHt = argPrixHt;
		this.nom = argNom;
		this.urlImage = argUrlImage;
		this.stock = argStock;
		this.materiel = new Materialise(argEtat);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public double getPrixHt() {
		return prixHt;
	}

	public void setPrixHt(double prixHt) {
		this.prixHt = prixHt;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Materialise getMateriel() {
		return materiel;
	}

	public void setMateriel(Materialise materiel) {
		this.materiel = materiel;
	}

	public Dematerialise getImmateriel() {
		return immateriel;
	}

	public void setImmateriel(Dematerialise immateriel) {
		this.immateriel = immateriel;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Tva getTva() {
		return tva;
	}

	public void setTva(Tva tva) {
		this.tva = tva;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", reference=" + reference + ", prixHt=" + prixHt + ", nom=" + nom
				+ ", description=" + description + ", urlImage=" + urlImage + ", materiel=" + materiel + ", immateriel="
				+ immateriel + ", stock=" + stock + ", tva=" + tva + "]";
	}

}
