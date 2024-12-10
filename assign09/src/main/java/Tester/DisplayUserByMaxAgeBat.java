package Tester;
import java.util.Scanner;
import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

import static com.cdac.utils.HybernateUtils.getSessionFactory;
public class DisplayUserByMaxAgeBat {
public static void main(String[] args) {
	try(SessionFactory sf=getSessionFactory();Scanner sc=new Scanner (System.in) ){
		 
		TeamDao teamDao=new TeamDaoImpl();
		
		System.out.println("Enter Max Age and max batting avg : ");
		teamDao.DisplayWithMaxAgeAverage(
				sc.nextInt(),sc.nextDouble()).forEach(System.out::println);
		
	}
}
}
