package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/**Représente la table Emprunt dans la base de donnée
 * @author diginamic
 *
 */
@Entity
public class Emprunt {
	/**
	 * Identifiant de la table Emprunt
	 */
	@Id
	private int id;

	/**
	 *Date de début de l'emprunt 
	 */
	@Column(name = "DATE_DEBUT")
	private LocalDate dateDebut;
	
	/**
	 * Date de fin de l'emprunt
	 */
	@Column(name = "DATE_FIN")
	private LocalDate dateFin;
	
	/**
	 * Délai de l'emprunt
	 */
	@Column(name = "DELAI")
	private int delai;
	

	
	/**
	 * Client ayant fait des emprunts
	 */
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;

	

	

	/**
	 * Contructructeur sans paramètre
	 */
	public Emprunt() {

	}
	
	/**
	 * @return le client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return l'identifiant
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
	 * @return date de debut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return date de fin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return le delai de l'emprunt
	 */
	public int getDelai() {
		return delai;
	}

	/**
	 * @param le delai de l'emprunt
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai
				+ ", client=" + client + "]";
	}
}