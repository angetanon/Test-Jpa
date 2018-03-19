package banque;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Virement extends Operation{
	

	private String beneficiaire;
	
	
	public Virement() {

	}



	public Virement(LocalDateTime date, double montant, String motif, String beneficiaire) {
		super(date, montant, motif);
		this.beneficiaire = beneficiaire;
	}







	public String getBeneficiaire() {
		return beneficiaire;
	}


	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}





	@Override
	public String toString() {
		return "Virement [beneficiaire=" + beneficiaire + "]";
	}


	
	

}
