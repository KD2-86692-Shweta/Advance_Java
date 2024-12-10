package com.cdac.dao;

import java.util.List;

import com.cdac.entity.Player;

public interface PlayerDao {
	String addPlayer(Long teamid,Player player);
	
	List<Player> displayAllPlayerById(Long teamId);
}
