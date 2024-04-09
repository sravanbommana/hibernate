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
    	// Creation part
    	/*
    	Employee emp = new Employee();
    	emp.setEmpId(10);
    	emp.setName("Tim");
    	BankAccount account1 = new BankAccount();
    	account1.setAccountNo("4565788979");
    	account1.setBranchName("Nagpur");
    	account1.setEmployee(emp);
    	BankAccount account2 = new BankAccount();
    	account2.setAccountNo("6878898844");
    	account2.setBranchName("Hyderabad");
    	List<BankAccount> list= new ArrayList<BankAccount>();
    	list.add(account1);
    	list.add(account2);
    	account2.setEmployee(emp);
    	emp.setAccount(list);
    	session.save(emp);
    	session.save(account1);
    	session.save(account2); */
    	// Data Reading Part
    	Employee emp = (Employee)session.get(Employee.class, 10);
    	System.out.println(emp.getName());
    	List<BankAccount> accountList = emp.getAccount();
    	accountList.stream().forEach(act -> System.out.println(act.getAccountNo()));
    	tx.commit();
    	session.close();
    	factory.close();
    	
    }
}
