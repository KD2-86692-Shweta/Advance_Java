package com.cdac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long team_id; 
	
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
	
	
	
	public Team() {
		super();
	}
	

//	public Team(int maxPlayerAge, double battingAvg) {
//		super();
//		this.maxPlayerAge = maxPlayerAge;
//		this.battingAvg = battingAvg;
//	}



	public Team( String owner, String abbrevation) {
		super();
		this.owner = owner;
		this.abbrevation = abbrevation;
	}


	public Team(Long team_id, String name, String abbrevation, String owner, int maxPlayerAge, double battingAvg,
			int wicketsTaken) {
		super();
		this.team_id = team_id;
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
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

	public Long getTeam_id() {
		return team_id;
	}
	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbrevation() {
		return abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMaxPlayerAge() {
		return maxPlayerAge;
	}
	public void setMaxPlayerAge(int maxPlayerAge) {
		this.maxPlayerAge = maxPlayerAge;
	}
	public double getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner
				+ ", maxPlayerAge=" + maxPlayerAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken
				+ "]";
	}
	
	
}
