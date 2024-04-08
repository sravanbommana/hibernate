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
		/* Transaction tx = session.beginTransaction();
		Student student = new Student();
    	student.setId(16);
    	student.setName("Raghava");
    	student.setCity("Hyderabad");
    	Certificate cert = new Certificate();
    	cert.setCourse("C#");
    	cert.setDuration("30 days");
    	student.setCerificate(cert);
    	session.save(student);
    	tx.commit(); */
		//String stmtQuery = "from Student where name=:x";
		String stmtQuery = "from Student as s where s.name=:x and s.city=:c";
		Query query = session.createQuery(stmtQuery);
		query.setParameter("x", "Ram");
		query.setParameter("c", "Bengaluru");
		List<Student> list = query.list();
		for(Student ele: list) {
			System.out.println(ele.getCerificate().getCourse());
		}
		session.close();
		factory.close();
		
	}
}
