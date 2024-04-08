package com.java.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/**********************************************************
		String query = "delete from Student as s where s.city=:c";
		Query q1 = session.createQuery(query);
		q1.setParameter("c", "Sacramento");
		int res = q1.executeUpdate();
		System.out.println("Deleted records "+res); 
		************************************************************/
		String query1 = "update Student set city=:c where name=:n";
		Query q2 = session.createQuery(query1);
		q2.setParameter("c", "Dallas");
		q2.setParameter("n", "John");
		int res = q2.executeUpdate();
		tx.commit();
		session.close();
		factory.close();
	}
}
