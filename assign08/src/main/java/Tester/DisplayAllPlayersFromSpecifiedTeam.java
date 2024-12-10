package Tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cdac.dao.PlayerDao;
import com.cdac.dao.PlayerDaoImpl;

import static com.cdac.utils.HybernateUtils.getSessionFactory;

import java.util.Scanner;

public class DisplayAllPlayersFromSpecifiedTeam {

	public static void main(String[] args) {
		try(SessionFactory session=getSessionFactory(); Scanner sc=new Scanner(System.in)){
		
		PlayerDao playerDao=new PlayerDaoImpl();
		System.out.println("Enter Team Id : ");
		playerDao.displayAllPlayerById(sc.nextLong()).forEach(System.out::println);
		
		}
		

	}

}
