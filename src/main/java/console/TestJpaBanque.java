package console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import banque.Adresse;
import banque.AssuranceVie;
import banque.Banque;
import banque.Compte;
import banque.LivretA;
import banque.Operation;
import banque.Virement;
import banque.Client;


public class TestJpaBanque {

	private static final Logger LOG = LoggerFactory.getLogger(TestJpaBanque.class);

	/**Represente une appliction de type ORM (Object Relationnal Mapping)
	 *  permettant de lier une base de données relationnelle (bibiothèque)
	 *  à notre objet java 
	 * @param args
	 */
	public static void main(String[] args) {


		EntityManagerFactory emfBanque = Persistence.createEntityManagerFactory("banque");
		
	

			//entity manager banque
			EntityManager emBanque = emfBanque.createEntityManager();
			EntityTransaction etBanque = emBanque.getTransaction();
			etBanque.begin();
			
			//Instanciation et initialisation de l'objet 1
			Client cl1 = new Client("Tanon", "Ange", LocalDate.of(1986,9,7), new Adresse(83, "Route du Rhin", 67000, "Strasbourg"));
			Banque bq1 = new Banque("LCL");			
			Compte cpt1 = new Compte("15789", 5000);
			cl1.setBanque(bq1);
			Operation op1 = new Operation(LocalDateTime.of(LocalDate.of(2018, 3, 15), LocalTime.of(14,26)), 20, "transfert d'argent");
			op1.setCompte(cpt1);
			LivretA lia1 =new LivretA("14758", 2000, 1200);
			AssuranceVie assV1 = new AssuranceVie("35841", 900, LocalDate.of(2020, 5, 30), 2000);
			Virement vir1 = new Virement(LocalDateTime.of(2018, 5, 4, 17, 38), 250.0, "virement", "justine");
			vir1.setCompte(cpt1);
			
			
			
			
			
			//Instanciation et initialisation de l'objet 2
			Client cl2 = new Client("Fatim", "Diallo", LocalDate.of(1988,11,5), new Adresse(42, "Avenue François Mittérand", 68000, "Mulhouse"));
			Banque bq2 = new Banque("Credit Mutuel");			
			Compte cpt2 = new Compte("15725", 250);
			cl2.setBanque(bq2);
			Operation op2 = new Operation(LocalDateTime.of(LocalDate.of(2017, 11, 30), LocalTime.of(15,22)), 50, "retrait");
			op2.setCompte(cpt2);
			LivretA lia2 =new LivretA("52369", 1600, 800);
			AssuranceVie assV2 = new AssuranceVie("35561", 550, LocalDate.of(2022, 8, 13), 452);
			Virement vir2 = new Virement(LocalDateTime.of(2017, 5, 14, 23, 47), 1452.75, "virement", "Arnaud");
			vir2.setCompte(cpt2);
			
			
			
			
			//Persistence de l'objet 1 en base
			emBanque.persist(cl1);
			emBanque.persist(bq1);
			emBanque.persist(cpt1);
			emBanque.persist(op1);
			emBanque.persist(lia1);
			emBanque.persist(assV1);
			emBanque.persist(vir1);
			
			
			
			//Persistence de l'objet 2 en base
			emBanque.persist(bq2);
			emBanque.persist(cl2);
			emBanque.persist(cpt2);
			emBanque.persist(op2);
			emBanque.persist(lia2);
			emBanque.persist(assV2);
			emBanque.persist(vir2);
			
			//Ajout des objets persistents depuis la base
			cl1.getCompte().add(cpt1);
			cpt2.getClient().add(cl2);
			
			etBanque.commit();
			emBanque.close();
			
			
			
			//Suppression d'une operation dont le montant est >=50
			emBanque = emfBanque.createEntityManager();
			etBanque = emBanque.getTransaction();
			etBanque.begin();
			
			cpt2 = emBanque.find(Compte.class, 3L);
			
			List<Operation> ops = cpt2.getOperation().stream().filter(p->p.getMontant()>=50).collect(Collectors.toList());
			for (Operation op : ops){
				if (op != null)
					emBanque.remove(op);
			}
				
			emBanque.merge(cpt2);
		
			
			
			
			
			
			etBanque.commit();
			
			LOG.info("Liste de client avec ses infos");
			LOG.info(cl1.toString());
			emBanque.close();
			

		}
	}

