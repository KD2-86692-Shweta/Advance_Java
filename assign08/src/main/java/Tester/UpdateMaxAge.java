package Tester;
import static com.cdac.utils.HybernateUtils.getSessionFactory;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

public class UpdateMaxAge {
public static void main(String[] args) {
	try(SessionFactory session=getSessionFactory(); Scanner sc=new Scanner(System.in)){
		System.out.println("Ener team name, updated max age");
		TeamDao teamdao=new TeamDaoImpl();
		teamdao.UpdateMAxAge(sc.nextInt(),sc.next());
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
