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
    	Question que = new Question();
    	que.setId(12);
    	que.setQuestion("What is java ?");
    	Answer answer = new Answer();
    	answer.setId(100);
    	answer.setAnswer("Java is a programming language");
    	que.setAnswer(answer);
    	answer.setQuestion(que);
    	session.save(answer);
    	session.save(que);
    	tx.commit();
    	Question quest = (Question)session.get(Question.class, 12);
    	System.out.println(quest);
    	session.close();
    	factory.close();
    }
}
