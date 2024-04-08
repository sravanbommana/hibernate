package com.java.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FirstLevelCacheExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Student student = session.get(Student.class, 14);
		System.out.println(student);
		// Here we are fetching the same object but hibernate query will be fired only once due to cache
		
		Student student1 = session.get(Student.class, 14);
		System.out.println(student1);
		session.close();
		factory.close();
		
	}
}
