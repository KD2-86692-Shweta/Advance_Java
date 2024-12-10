package Tester;

import org.hibernate.SessionFactory;

import com.cdac.dao.PlayerDao;
import com.cdac.dao.PlayerDaoImpl;
import com.cdac.entity.Player;
import com.cdac.entity.Team;

import static com.cdac.utils.HybernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;
public class AddPlayerDetails {

	public static void main(String[] args) {
		
		try(SessionFactory session = getSessionFactory(); Scanner sc=new Scanner(System.in)){
			
			PlayerDao playerDao=new PlayerDaoImpl();
			
			System.out.println("Enter Team Id");
			Long teamId=sc.nextLong();
			
			
			
			
			System.out.println("Enter Player information : First Name" + "Last Name " + "Dob" +"Batting Averge"+"Team" +
			"Wickets Taken ");
			
			Player player=new Player(sc.next(),sc.next(),LocalDate.parse(sc.next()),sc.nextDouble(),sc.nextInt());
			playerDao.addPlayer(teamId,player);
			
			
			
		}
	}

}
