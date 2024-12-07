package com.cdac.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.cdac.utils.HybernateUtils.getSessionFactory;

import java.io.Serializable;

import com.cdac.entity.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String AddTeam(Team team) {
		String msg="added tem Failed....!";
		
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			
			Serializable userId=session.save(team);
			tx.commit();
			
			msg="Successfully inserted"+team.getTeam_id();
			
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
				throw e;
			}
			
		}
		return msg;
	}

}
