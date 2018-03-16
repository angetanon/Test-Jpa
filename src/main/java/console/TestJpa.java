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

public class TestJpa {

	private static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);

	/**Represente une appliction de type ORM (Object Relationnal Mapping)
	 *  permettant de lier une base de données relationnelle (bibiothèque)
	 *  à notre objet java 
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projet-JPA");
		EntityManager entityManager = factory.createEntityManager();

		Livre lv = entityManager.find(Livre.class, 1);

		LOG.info("Liste des livres");
		LOG.info(lv.toString());
		LOG.info("");

		TypedQuery<Livre> query = entityManager.createQuery("select l from Livre l where l.titre='Germinal'",
				Livre.class);
		Livre lv2 = query.getResultList().get(0);
		LOG.info("Liste des livres nommées Germinal");
		LOG.info(lv2.toString());
		LOG.info("");

		TypedQuery<Client> query2 = entityManager
				.createQuery("select cl from Client cl, Emprunt e where e.client=cl.id", Client.class);
		List<Client> cls = query2.getResultList();
		LOG.info("Liste des clients ayant un emprunts");
		for (Client cl : cls) {
			LOG.info(cl.toString());
		}
		LOG.info("");

		TypedQuery<Emprunt> query4 = entityManager
				.createQuery("select e from Emprunt e, Client cl where cl.id=e.client", Emprunt.class);
		List<Emprunt> em4 = query4.getResultList();
		LOG.info("Liste des emprunts faits par les clients");
		for (Emprunt e4 : em4) {
			LOG.info(e4.toString());
		}
		LOG.info("");

		TypedQuery<Emprunt> query3 = entityManager
				.createQuery("select e from Client cl, Emprunt e where e.client=cl.id and nom ='YU'", Emprunt.class);
		List<Emprunt> ems1 = query3.getResultList();
		LOG.info("Liste des clients ayant un emprunts dont le nom est YU");
		for (Emprunt e1 : ems1) {
			LOG.info(e1.toString());

		}
		LOG.info("");

		

		TypedQuery<Emprunt> query5 = entityManager.createQuery("from Emprunt", Emprunt.class);
		List<Emprunt> em5 = query5.getResultList();
		LOG.info("Liste des clients ayant un emprunts");
		for (Emprunt e1 : em5) {
			LOG.info(e1.toString());

			entityManager.close();
			factory.close();

		}
	}
}
