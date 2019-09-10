package dn.hibernate4.gradle.example;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dn.hibernate4.gradle.example.model.DnPersonDetail;
import dn.hibernate4.gradle.example.util.DnHibernateUtil;
import dn.hibernate4.gradle.example.util.DnPersonDetailUtil;

/**
 * @author Muthukumar Thangavinayagam
 *
 */

public class DnHibernate4FetchDataExample {

	public static void main(String[] args) {
		Session session = null; //
		try {
			SessionFactory sessionFactory = DnHibernateUtil.getSessionFactory();
			List<DnPersonDetail> personList = Arrays.asList(DnPersonDetailUtil.arrayOfPersons);
			session = sessionFactory.openSession();
			for (DnPersonDetail dnPersonDetail : personList) {
				Transaction transaction = session.beginTransaction();
				session.persist(dnPersonDetail);
				transaction.commit();
			}

			@SuppressWarnings("unchecked")
			List<DnPersonDetail> persons = session.createQuery(" FROM DnPersonDetail").list();
			for (DnPersonDetail person : persons) {
				System.out.println(" Person Name :"+person.getName()+" Age"+person.getAge()+" ContactNumber: "+person.getContactNumber()+" "+person.getAddress());
			}

			System.out.println("Person Records Added..");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

}
