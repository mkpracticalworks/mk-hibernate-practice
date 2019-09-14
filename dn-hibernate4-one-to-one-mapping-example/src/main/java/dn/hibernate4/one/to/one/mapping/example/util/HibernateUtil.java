package dn.hibernate4.one.to.one.mapping.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Muthukumar Thangavinayagam
 *
 */
public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY;

	static {
		try {
			// Creating Configuration Instance & Passing Hibernate Configuration File
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

			// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
			ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			// Creating Hibernate SessionFactory Instance
			SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistryObj);

		} catch (Throwable th) {

			System.err.println("Enitial SessionFactory creation failed" + th);

			throw new ExceptionInInitializerError(th);
		}

	}

	public static SessionFactory getSessionFactory() {

		return SESSION_FACTORY;

	}

}
