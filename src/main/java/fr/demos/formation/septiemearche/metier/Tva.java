package fr.demos.formation.septiemearche.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @author Fabrice LUNEAU
* 
*         Modélise les taux de TVA.
*
*         Une TVA à un taux un libellé
*
*         Un article à un taux de TVA et un seul
*/

@Entity
@Table(name = "tva")
public class Tva {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tva")
	private int id;
	@Column(name = "taux_tva", nullable = false)
	private float taux;
	@Column(name = "libelle_tva", nullable = false, unique = true)
	private String libelle;

	public Tva() {
	}

	public Tva(int id, float taux, String libelle) {
		super();
		this.id = id;
		this.taux = taux;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Calcule un montant TTC d'après l'argument HT en appliquant le taux de
	 * l'objet TVA
	 * 
	 * @param ht
	 * @return
	 */
	public double calculerTtc(double ht) {
		return ht * (1 + taux / 100);
	}

	/**
	 * Calcule un montant HT d'après le paramètre TTC en appliquant le taux de
	 * l'objet TVA
	 * 
	 * @param ttc
	 * @return
	 */
	public double calculerHt(double ttc) {
		return ttc / (1 + taux / 100);
	}

	/**
	 * Calcule le montant de la TVA d'après le paramètre HT en appliquant le
	 * taux de l'objet TVA
	 * 
	 * @param ht
	 * @return
	 */
	public double calculerTvaDepuisHt(double ht) {
		return ht * (taux / 100);
	}

	/**
	 * Calcule le montant de la TVA d'après le paramètre TTC en appliquant le
	 * taux de l'objet TVA
	 * 
	 * @param ttc
	 * @return
	 */
	public double calculerTvaDepuisTtc(double ttc) {
		return calculerHt(ttc) * (taux / 100);
	}

	@Override
	public String toString() {
		return "TVA" + ", Id = " + id + ", Libellé = " + libelle + ", Taux = " + taux + "%";
	}

}
