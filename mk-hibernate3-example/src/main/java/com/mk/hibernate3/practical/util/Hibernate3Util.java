package com.mk.hibernate3.practical.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate3Util {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory(){
		try{
		// Create the SessionFactory from hiberante.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		}catch (Throwable ex) {
		// Make sure you log the exception, as it might be swallowed
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void shutdown() {
		getSessionFactory().close();
	}

}
