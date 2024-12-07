package com.cdac.utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HybernateUtils {

	
	public static SessionFactory sessionfactory;
	
	static {
		System.out.println("In init block ");
		
		sessionfactory=new Configuration().configure().buildSessionFactory();
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionfactory;
	}
	
}
