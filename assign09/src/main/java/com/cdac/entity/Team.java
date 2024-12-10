package com.cdac.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString(callSuper=true, exclude = "player")
@NoArgsConstructor
//@Table(name="team")

public class Team extends BaseEntity {

	@Column(length=100, unique=true)
	private String name;
	
	@Column (length=10 , unique=true)
	private String abbrevation;
	
	@Column(length=20, nullable=false)
	private String owner;
	
	@Column(name="max_player_age")
	private int maxPlayerAge;
	
	@Column (name="batting_avg")
	private double battingAvg;
	
	@Column (name="wickets_taken")
	private int wicketsTaken;
	

	 @OneToMany(mappedBy="playersTeam",orphanRemoval = true )
	 private List<Player> player=new ArrayList<>();
	 
	 public void addPlayer(Player player) {
		 this.player.add(player);
		 player.setPlayersTeam(this);
	 }
	public Team( String owner, String abbrevation) {
		super();
		this.owner = owner;
		this.abbrevation = abbrevation;
	}


	public Team(String name, String abbrevation, String owner, int maxPlayerAge, double battingAvg, int wicketsTaken) {
		super();
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}
	
	public void removePlayer(Player play) {
		this.player.remove(play);
		play.setPlayersTeam(null);
	}

	
	
}
