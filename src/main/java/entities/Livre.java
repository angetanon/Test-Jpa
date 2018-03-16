package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**Représente la table livre dans la base de donnée
 * @author diginamic
 *
 */
@Entity
public class Livre {
	/**
	 * Identifiant du livre
	 */
	@Id
	private int id;
	
	/**
	 * Titre du livre
	 */
	@Column(name="TITRE")
	private String titre;
	
	/**
	 * Auteur du livre
	 */
	@Column(name="AUTEUR")
	private String auteur;

	/**
	 *Constructeur 
	 */
	public Livre() {

	}

	/**
	 * @return L'identifiant du livre
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param identifiant
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return titre du livre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre du livre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return auteur du livre
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur du livre
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}

}
