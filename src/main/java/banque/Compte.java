package banque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	protected String numero;
	protected double solde;
	
	@ManyToMany
	@JoinTable(name = "CLIENT_COMPTE", joinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"))
	private Set<Client> client = new HashSet<Client>();
	
	@OneToMany(mappedBy= "compte")
	private Set<Operation> operation = new HashSet<Operation>();
	
	
	public Compte() {
	
	}	
	
	public Compte(String numero, double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	public Set<Client> getClient() {
		return client;
	}


	public void setClient(Set<Client> client) {
		this.client = client;
	}


	public Set<Operation> getOperation() {
		return operation;
	}


	public void setOperation(Set<Operation> operation) {
		this.operation = operation;
	}


	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", client=" + client + ", operation="
				+ operation + "]";
	}
	
	
	
	
	

}
