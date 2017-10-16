package fr.demos.formation.septiemearche.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materialise")
public class Materialise {

	@Id
	@Column(name = "id_materialise")
	private int id;
	@Column(name = "etat_materialise")
	@Enumerated(EnumType.STRING)
	private Etat etat;

	public Materialise() {
		super();
	}

	// id est à 0, il sera renseigné par hibernate lors du premier enregistrement en BDD
	public Materialise(Etat etat) {
		super();
		this.etat = etat;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Materialise [id=" + id + ", etat=" + etat + "]";
	}
	
}
