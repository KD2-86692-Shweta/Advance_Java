package com.cdac.dao;

import com.cdac.entity.Player;
import com.cdac.entity.Team;

import static com.cdac.utils.HybernateUtils.getSessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addPlayer(Long teamid,Player player) {
		
		String msg="User Registration Fail .. !";
	
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			session.persist(player);
			
			Team team=session.get(Team.class, teamid);
			if(team == null) {
				System.out.println("team with id = "+teamid+ "Not Found ");
			}
			team.addPlayer(player);
			
			tx.commit();
			msg="Player Added Successfully";
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}

	

}