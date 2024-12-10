package Tester;

import java.util.Scanner;
import static com.cdac.utils.HybernateUtils.getSessionFactory;
import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

public class DeteleWithId {

	public static void main(String[] args) {
		try(SessionFactory session=getSessionFactory(); Scanner sc=new Scanner(System.in)){
			 
			TeamDao teamDao=new TeamDaoImpl();
			System.out.println("Enter id to delete");
			teamDao.deleteById(sc.nextLong());
			
		}catch (Exception e) {
			e.printStackTrace();		}

	}

}
