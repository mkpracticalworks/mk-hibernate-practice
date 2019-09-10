package com.dn.hibernate.example;


import com.dn.hibernate.example.model.DnEmployee;
import com.dn.hibernate.example.util.DnHibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Muthukumar Thangavinayagam
 *
 */
public class DnHibernate4EmployeeApplication 
{
    public static void main( String[] args )
    {
       SessionFactory sessionFactory = DnHibernateUtil.getSessionFactory();
       Session session = sessionFactory.openSession();
       Transaction transaction = session.beginTransaction();
       
       DnEmployee employee = new DnEmployee();
       				employee.setName("sangeetha");
       				employee.setPhoneNumber("332222");
       				employee.setEmail("sangeetha@kannakuruchi.com");
       				employee.setAddress("kannakuruchi");
       				
       				session.persist(employee);
       				transaction.commit();
       				session.close();
       System.out.println("Employee Record Added..");
    }
}
