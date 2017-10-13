package fr.demos.formation.septiemearche.metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Alexandre
 * 
 *         Une adresse appartient à un client un client peut avoir plusieurs
 *         adresse
 */
@Entity
@Table(name = "adresse")
public class Adresse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_adresse")
	private int id;
	
	@Column(name = "nom_adresse", nullable = false)
	private String nomAdresse;
	
	@Column(name="voie_adresse", nullable = false)
	private String voie;
	
	@Column(name="complement_adresse")
	private String complement;
	
	@Column(name="code_postal_adresse", nullable = false)
	private String codePostal;
	
	@Column(name="ville_adresse", nullable = false)
	private String ville;
	
	@Column(name="pays_adresse", nullable = false)
	private String pays;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomAdresse() {
		return nomAdresse;
	}
	public void setNomAdresse(String nomAdresse) {
		this.nomAdresse = nomAdresse;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", nomAdresse=" + nomAdresse + ", voie=" + voie + ", complement=" + complement
				+ ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays + "]";
	}
	
	
	
	
}
	