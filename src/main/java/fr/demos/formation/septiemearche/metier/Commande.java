package fr.demos.formation.septiemearche.metier;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Alexandre BIGOT
 *
 */
@Entity
@Table()
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_article")

	private Compte compte;
	private String numCommande;
	private String numFacture;
	@Transient
	private LocalDateTime dateCommande;
	@OneToMany
	private ArrayList<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();
	
	public Commande() {}
		
	public Commande(Compte compte, String numCommande, String numFacture, LocalDateTime dateCommande,
			ArrayList<LigneCommande> lignesCommande) {
		super();
		this.compte = compte;
		this.numCommande = numCommande;
		this.numFacture = numFacture;
		this.dateCommande = dateCommande;
		this.lignesCommande = lignesCommande;
	}
	
	
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public String getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(String numCommande) {
		this.numCommande = numCommande;
	}
	public String getNumFacture() {
		return numFacture;
	}
	public void setNumFacture(String numFacture) {
		this.numFacture = numFacture;
	}
	public LocalDateTime getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(LocalDateTime dateCommande) {
		this.dateCommande = dateCommande;
	}
	public ArrayList<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}
	public void setLignesCommande(ArrayList<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}
	

	
	
	
	}