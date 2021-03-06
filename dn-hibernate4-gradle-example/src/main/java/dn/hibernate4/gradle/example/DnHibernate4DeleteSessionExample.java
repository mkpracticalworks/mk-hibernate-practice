package dn.hibernate4.gradle.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dn.hibernate4.gradle.example.model.DnPersonDetail;
import dn.hibernate4.gradle.example.util.DnHibernateUtil;

/**
 * @author Muthukumar Thangavinayagam
 *
 */

public class DnHibernate4DeleteSessionExample {
	public static void main(String[] args) {
		Session session = null; //
		try {
			SessionFactory sessionFactory = DnHibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			DnPersonDetail person = (DnPersonDetail) session.load(DnPersonDetail.class, Long.valueOf(3));
			System.out.println(" Person Name :" + person.getName() + " Age" + person.getAge() + " ContactNumber: "
					+ person.getContactNumber() + " " + person.getAddress());

			person.setAddress("Bangalore, India");

			session.saveOrUpdate(person);

			// Delete the object
			session.delete(person);

			transaction.commit();

		} catch (Exception e) {
			System.out.println("Err msg ..." + e);
		} finally {
			session.close();
		}
	}
}