package dn.hibernate4.gradle.example;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dn.hibernate4.gradle.example.model.DnPersonDetail;
import dn.hibernate4.gradle.example.util.DnHibernateUtil;

/**
 * @author Muthukumar Thangavinayagam
 *
 */
public class DnHibernate4GradleApplication {

	public static void main(String[] args) {
		SessionFactory sessionFactory = DnHibernateUtil.getSessionFactory();

		List<DnPersonDetail> personList = Arrays.asList(arrayOfPersons);
		Session session = sessionFactory.openSession();
		for (DnPersonDetail dnPersonDetail : personList) {
			Transaction transaction = session.beginTransaction();
			session.persist(dnPersonDetail);
			transaction.commit();
		}
		session.close();
		System.out.println("Employee Record Added..");
	}

	private static DnPersonDetail[] arrayOfPersons = {

			new DnPersonDetail("person1", 53, "person1@domain.com", "111111", "India"),
			new DnPersonDetail("person2", 63, "person2@domain.com", "22222", "India"),
			new DnPersonDetail("person3", 33, "person3@domain.com", "33333", "India"),
			new DnPersonDetail("Muthukumar", 37, "mk@domain.com", "44444", "India")

	};
}
