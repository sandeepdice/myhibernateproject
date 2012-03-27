package helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class RunThis {
	public static void main(String[] args) {
		/*
		 * Configuration.configure().buildSessionFactory() is used when using XML based hbm files
		 * instead of JPA
		 */
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
	}
}
