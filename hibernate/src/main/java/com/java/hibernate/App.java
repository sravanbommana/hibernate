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
    	Student student = (Student)session.get(Student.class, 6);
    	Student student1 = (Student)session.load(Student.class, 1);

    	System.out.println(student.getCity());
    	session.close();
    	factory.close();
    	
    	
    }
}
