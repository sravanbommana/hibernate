package com.java.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	Student student = new Student();
    	student.setId(12);
    	student.setName("User2");
    	student.setCity("Chennai");
    	Certificate cert = new Certificate();
    	cert.setCourse("Java");
    	cert.setDuration("30 days");
    	student.setCerificate(cert);
    	session.save(student);
    	tx.commit();
    	session.close();
    	factory.close();
    }
}
