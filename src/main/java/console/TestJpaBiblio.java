package console;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import entities.Client;
import entities.Emprunt;
import entities.Livre;

public class TestJpaBiblio {

	private static final Logger LOG = LoggerFactory.getLogger(TestJpaBiblio.class);

	/**Represente une appliction de type ORM (Object Relationnal Mapping)
	 *  permettant de lier une base de données relationnelle (bibiothèque)
	 *  à notre objet java 
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory emfBibliotheque = Persistence.createEntityManagerFactory("projet-JPA");

		
		//entity manager bibliothèque
		EntityManager emBiblio = emfBibliotheque.createEntityManager();

		Livre lv = emBiblio.find(Livre.class, 1);

		LOG.info("Liste des livres");
		LOG.info(lv.toString());
		LOG.info("");

		TypedQuery<Livre> query = emBiblio.createQuery("select l from Livre l where l.titre='Germinal'",
				Livre.class);
		Livre lv2 = query.getResultList().get(0);
		LOG.info("Liste des livres nommées Germinal");
		LOG.info(lv2.toString());
		LOG.info("");

		TypedQuery<Client> query2 = emBiblio
				.createQuery("select cl from Client cl, Emprunt e where e.client=cl.id", Client.class);
		List<Client> cls = query2.getResultList();
		LOG.info("Liste des clients ayant un emprunts");
		for (Client cl : cls) {
			LOG.info(cl.toString());
		}
		LOG.info("");

		TypedQuery<Emprunt> query4 = emBiblio
				.createQuery("select e from Emprunt e, Client cl where cl.id=e.client", Emprunt.class);
		List<Emprunt> em4 = query4.getResultList();
		LOG.info("Liste des emprunts faits par les clients");
		for (Emprunt e4 : em4) {
			LOG.info(e4.toString());
		}
		LOG.info("");

		TypedQuery<Emprunt> query3 = emBiblio
				.createQuery("select e from Client cl, Emprunt e where e.client=cl.id and nom ='YU'", Emprunt.class);
		List<Emprunt> ems1 = query3.getResultList();
		LOG.info("Liste des clients ayant un emprunts dont le nom est YU");
		for (Emprunt e1 : ems1) {
			LOG.info(e1.toString());

		}
		LOG.info("");

		

		TypedQuery<Emprunt> query5 = emBiblio.createQuery("from Emprunt", Emprunt.class);
		List<Emprunt> em5 = query5.getResultList();
		LOG.info("Liste des clients ayant un emprunts");
		for (Emprunt e1 : em5) {
			LOG.info(e1.toString());

			emBiblio.close();			
			emfBibliotheque.close();
			
			
		

		}
	}
}
