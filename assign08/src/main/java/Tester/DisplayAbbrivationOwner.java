package Tester;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

import static com.cdac.utils.HybernateUtils.getSessionFactory;

import java.util.Scanner;
public class DisplayAbbrivationOwner {

	public static void main(String[] args) {
		try(SessionFactory session=getSessionFactory(); Scanner sc=new Scanner(System.in)){
		 TeamDao teamDao= new TeamDaoImpl();
			System.out.println("Enter max age and max batting average : ");
		 teamDao.DisplayOwnerAbbrivation(sc.nextInt() ,sc.nextDouble()).forEach(team-> System.out.println(team.getOwner()+ " "+ team.getAbbrevation()));

	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}

