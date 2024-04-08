package com.java.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.Cacheable;

/**********************************************************************************************************
 * For enabling second level cache folloe beklow instructions
 * 1. add dependencies (hibernate-ehcache, ehcache) in pom.xml
 * 2. set propertiers (cache.use_second_level_cache, cache.region.factory_class) in hibernate 
 * config file 
 * 3. add @Cache, @Cacheable in entity class
 ***********************************************************************************************************/

public class SecondLevelCacheExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session1 = factory.openSession();
		Student student1 = session1.get(Student.class, 14);
		System.out.println(student1);
		session1.close();
		Session session2 = factory.openSession();
		Student student2 = session2.get(Student.class, 14);
		System.out.println(student2);
		session2.close();
		factory.close();
		
	}
}
