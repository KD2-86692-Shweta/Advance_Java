package Tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cdac.dao.PlayerDao;
import com.cdac.dao.PlayerDaoImpl;
import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;
import com.cdac.entity.Team;

import static com.cdac.utils.HybernateUtils.getSessionFactory;

import java.util.Scanner;

public class DisplayAllPlayersFromSpecifiedTeam {

	public static void main(String[] args) {
		try(SessionFactory session=getSessionFactory(); Scanner sc=new Scanner(System.in)){
		
			
		TeamDao teamDao=new TeamDaoImpl();
		System.out.println("Enter Team Id : ");
		
		Team team = teamDao.displayAllPlayerById(sc.nextLong());
		team.getPlayer().forEach(System.out::println);

		}
		

	}

}
