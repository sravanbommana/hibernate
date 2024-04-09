package com.java.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = factory.openSession();
    	Query query = session.createQuery("select e.empId, e.name, b.accountNo from Employee as e INNER JOIN e.account as b");
    	List<Object []> list = query.getResultList();
    	for(Object[] arr: list) {
    		System.out.println(Arrays.toString(arr));
    	}
    	session.close();
    	factory.close();
    	
    }
}
