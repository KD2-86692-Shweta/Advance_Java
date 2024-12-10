package com.cdac.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.cdac.utils.HybernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

import com.cdac.entity.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String AddTeam(Team team) {
		String msg="added team Failed....!";
		
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			
			Serializable userId=session.save(team);
			tx.commit();
			
			msg="Successfully inserted"+team.getId();
			
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
				throw e;
			}
			
		}
		return msg;
	}

	@Override
	public List<Team> DisplayAllTeams() {
		String jpql="select t from Team t";
		List<Team> team=null;
		
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
			team = session.createQuery(jpql,Team.class).getResultList();
			tx.commit();
		}catch (RuntimeException e) {
			if(tx != null) {
				tx.rollback();
				throw e;
				
			}
		}
		return team;
	}

	@Override
	public List<Team> DisplayWithMaxAgeAverage(int maxPlayerAge,double battingAvg) {
	     List<Team> team=null;
			String jpql="Select t from Team t where t.maxPlayerAge < :mage and t.battingAvg>:bavg";
		Session session=getSessionFactory().getCurrentSession();
	    
	    Transaction tx=session.beginTransaction();
	    
	    try {
	    	team=session.createQuery(jpql,Team.class).setParameter("mage",maxPlayerAge).setParameter("bavg",battingAvg).getResultList();
	    	tx.commit();
	    }catch (RuntimeException e) {
			if(tx != null) {
				tx.rollback();
				throw e;
			}
		}
		
		return team;
	}

	@Override
	public List<Team> DisplayOwnerAbbrivation(int maxage, double maxbating) {
		List<Team> team=null;
		
		String jpql="Select new com.cdac.entity.Team(owner,abbrevation) from Team t where  t.maxPlayerAge < :mage and  t.battingAvg > :bavg";
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			team=session.createQuery(jpql,Team.class).setParameter("mage", maxage).setParameter("bavg", maxbating).getResultList();
			tx.commit();
		}catch (RuntimeException e) {
			if(tx !=null) {
				tx.rollback();
				throw e;
			}
		}
		return team;
	}

	@Override
	public String UpdateMAxAge(int newmaxage, String teamName) {
    Team team=null;
    String msg="maxage updation fail";
		
		String jpql="select u from Team u where u.name= :teamName";
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
			team=session.createQuery(jpql,Team.class).setParameter("teamName",teamName).getSingleResult();
			team.setMaxPlayerAge(newmaxage);
			//session.evict(team);
			tx.commit();
			
			msg="successfully changed..!";
			
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}
		
		return msg;
	}

	@Override
	public String deleteById(Long id) {
		String msg="Fail to delete";
		Team team=null;
		Session session=getSessionFactory().getCurrentSession();
		Transaction tx= session.beginTransaction();
		
		try{
		  
			team=session.get(Team.class,id);
			if(team != null) {
				session.delete(team);
				msg="Msg deleted successfully !";
			}
			tx.commit();
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		
		return msg;
	}

	

	

	
	
	
	
	
	
	
	

}
