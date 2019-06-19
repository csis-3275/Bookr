package com.csis3275.Boundary;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FactoryGenerator {
	
	public static SessionFactory getFactory() {
		
		StandardServiceRegistry ssr = null;
		Metadata meta = null;
		SessionFactory factory = null;
		
		try {
			ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			meta = new MetadataSources(ssr).getMetadataBuilder().build();
			factory = meta.getSessionFactoryBuilder().build();
		}catch(Throwable ex) {
			System.err.println("Error: "+ex.getMessage());
		}
		
		return factory;
	}
}
