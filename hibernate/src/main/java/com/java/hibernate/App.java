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
	// 4 states - Transient, Persistent, Detached, Removed
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
    	//Now the object is in Transient state, the data is not yet in session or database
    	student.setCity("Chennai"); 
    
    	session.save(student); 

    	tx.commit(); //Now the object is in Persistent state, the data is in session or database
    	session.close(); // Now the data is in Detached state, it's in database but not with session 
    	factory.close();
    }
}
