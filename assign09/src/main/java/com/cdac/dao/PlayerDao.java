package com.cdac.dao;

import java.util.List;

import com.cdac.entity.Player;
import com.cdac.entity.Team;

public interface PlayerDao {
	String addPlayer(Long teamid,Player player);
	
	
}
