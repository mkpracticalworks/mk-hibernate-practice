package dn.hibernate4.gradle.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dn.hibernate4.gradle.example.model.DnPersonDetail;
import dn.hibernate4.gradle.example.util.DnHibernateUtil;
import dn.hibernate4.gradle.example.util.DnPersonDetailUtil;

/**
 * @author Muthukumar Thangavinayagam
 *
 */

public class DnHibernate4GradleUpdateExample {

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
			session.close();
			System.out.println("Person Records Added..");

			session = sessionFactory.openSession();

			Scanner scan = new Scanner(System.in);
			Transaction transaction = session.beginTransaction();
			System.out.println("Enter Person No. : ");
			Long id = scan.nextLong();
			System.out.println("Enter the Person Name to replace : ");
			String personName = scan.next();

			Criteria criteria = session.createCriteria(DnPersonDetail.class);
			criteria.add(Restrictions.eq("id", id));

			DnPersonDetail personDetail = (DnPersonDetail) criteria.uniqueResult();

			if (personDetail != null) {
				System.out.println("Person found:");
				System.out.println(personDetail.getId() + " - " + personDetail.getName());
			}
			
			// Person detail updated into database. 
			personDetail.setId(id);
			personDetail.setName(personName);

			session.update(personDetail);

			System.out.println(personName+" successfully updated");
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}
}
