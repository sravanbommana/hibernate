package com.java.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    	Transaction tx  = session.beginTransaction();
    	EmployeeOne emp1 = new EmployeeOne();
    	EmployeeOne emp2 = new EmployeeOne();
    	
    	Project project1 = new Project();
    	Project project2 = new Project();
    	
    	emp1.setId(21);
    	emp1.setName("John");
    	emp2.setId(11);
    	emp2.setName("Doe");
    	
    	project1.setPid(1234);
    	project1.setProjectName("Library Management");
    	project2.setPid(5678);
    	project2.setProjectName("Banking Management");
    	
    	List<EmployeeOne> empList1 = new ArrayList();
    	List<EmployeeOne> empList2 = new ArrayList();
    	
    	empList1.add(emp1);
    	empList1.add(emp2);
    	empList2.add(emp2);
    	
    	List<Project> projectList1 = new ArrayList();
    	List<Project> projectList2 = new ArrayList();
    	
    	projectList1.add(project1);
    	projectList1.add(project2);
    	projectList2.add(project2);
    	
    	emp1.setProject(projectList1);
    	emp2.setProject(projectList2);
    	project1.setEmployee(empList1);
    	project2.setEmployee(empList2);
    	
    	session.save(emp1);
    	session.save(emp2);
    	session.save(project1);
    	session.save(project2);
    	
    	tx.commit();
    	session.close();
    	factory.close();
    	
    }
}
