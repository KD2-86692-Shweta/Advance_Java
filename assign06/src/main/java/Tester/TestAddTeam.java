package Tester;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;
import com.cdac.entity.Team;

import static com.cdac.utils.HybernateUtils.getSessionFactory;

import java.util.Scanner;

public class TestAddTeam {

	public static void main(String[] args) {
	try(SessionFactory sf=getSessionFactory(); Scanner sc=new Scanner(System.in)){
		TeamDao teamDao=new TeamDaoImpl();
//		System.out.println("\"Enter user details -name varchar , \"\\r\\n\""
//				+ "+ abbrevation varchar , \"\r\n"
//				+ "					+ \"varchar owner, String maxplayerage, String password, \"\r\n"
//				+ "					+ \"String confirmPassword, LocalDate dob,\\r\\n\"\r\n"
//				+ "					+ \"			UserRole role, double regAmount\"");
//		
		
		Team newteam=new Team(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
		System.out.println(teamDao.AddTeam(newteam));
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}