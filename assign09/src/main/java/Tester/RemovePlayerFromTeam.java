package Tester;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;
import static com.cdac.utils.HybernateUtils.getSessionFactory;

import java.util.Scanner;
public class RemovePlayerFromTeam {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getSessionFactory();Scanner sc=new Scanner(System.in)){
		
		TeamDao team=new TeamDaoImpl();
	    System.out.println("Enter Team id and Player id : ");
	   System.out.println(team.RemovePlayerFromTeam(sc.nextLong(),sc.nextLong()));
	   
		}
		
		

	}

}
