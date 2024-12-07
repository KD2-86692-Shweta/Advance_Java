package Tester;

import static com.cdac.utils.HybernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

import com.cdac.utils.HybernateUtils;

public class TestHybernetBasic {
	
public static void main(String[] args) {
	try(SessionFactory sf= getSessionFactory()){
		System.out.println("Hibernate is running ... :) ");
	}catch(Exception e) {
		e.printStackTrace();
	}
}

}
