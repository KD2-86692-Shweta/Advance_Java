package com.cdac.dao;

import java.util.List;

import com.cdac.entity.Team;

public interface TeamDao {
       String AddTeam(Team team);
       List<Team> DisplayAllTeams();
       List<Team> DisplayWithMaxAgeAverage(int maxage,double maxbatiing);
       List<Team> DisplayOwnerAbbrivation(int maxage,double maxvating);
       String UpdateMAxAge(int newmaxage,String teamName);
       String deleteById(Long id);
       Team displayAllPlayerById(Long teamId);
	   String RemovePlayerFromTeam(long nextLong, long nextLong2);
}
