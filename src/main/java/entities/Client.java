package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



/**Représente la table Client dans la base de donnée
 * @author diginamic
 *
 */
@Entity
public class Client {

	/**
	 * Identifiant du client
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/**
	 * Nom du client
	 */
	@Column(name="NOM")
	private String nom;
	
	/**
	 *Prenom du client 
	 */
	@Column(name="PRENOM")
	private String prenom;
	
	
	
	/**
	 * Liste des emprunt clients
	 */
	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunt = new HashSet<Emprunt>();

	/**
	 * Constructeur 
	 */
	public Client() {
		
	}

	/**
	 * @return identifiant du client
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
	 * @return nom du client
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom du identifiant
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return prenom du client
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom du client
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	/**
	 * @return l'emprunt du client
	 */
	public Set<Emprunt> getEmprunt() {
		return emprunt;
	}

	/**
	 * @param emprunt du client
	 */
	public void setEmprunt(Set<Emprunt> emprunt) {
		this.emprunt = emprunt;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom  + "]";
	}
}
