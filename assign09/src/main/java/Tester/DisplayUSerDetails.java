package Tester;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

import static com.cdac.utils.HybernateUtils.getSessionFactory;
public class DisplayUSerDetails {
   public static void main(String[] args) {
	
	   try(SessionFactory sf=getSessionFactory()){
		   TeamDao teamDao=new TeamDaoImpl();
		   teamDao.DisplayAllTeams().forEach(System.out::println);
	   }catch(Exception e){
		   e.printStackTrace();
	   }
}
}
