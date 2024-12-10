package com.cdac.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="player")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Player extends BaseEntity{
	
	   @Column(length=50)
       private String firstName;
	   
	   @Column(length=50)
       private String lastName;
	   
	   
       private LocalDate dob;
       
       @Column (name="batting_avg")
       private double battingAvg;
       @Column (name="wickets_taken")
       private int wiketsTaken;
       
      
       
       @ManyToOne
       @JoinColumn(name="team_id")
       private Team playersTeam;

	

       
	public Player(String firstName, String lastName, LocalDate dob, double battingAvg, int wiketsTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wiketsTaken = wiketsTaken;
		
	}
  
	
}
//3.3 Create Player POJO 
//for the players table 
//Refer - 
//players(id bigint primary key auto_increment,first_name varchar(20),last_name varchar(20),dob date,batting_avg double,wickets_taken int,team_id int ,constraint fk_teams foreign key (team_id) references teams(team_id)
