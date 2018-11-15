package com.spring.naonnaTest.matching;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MatchingVO {
	private String matchingID;
	private String homeTeam;
	private String awayTeam;
	private String groundName;
	private String matchLocation;
	private Date playDate;
	private int people;
	private int matFin;
	
	public String getMatchingID() {
		return matchingID;
	}
	public void setMatchingID(String matchingID) {
		this.matchingID = matchingID;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public String getGroundName() {
		return groundName;
	}
	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}
	public String getMatchLocation() {
		return matchLocation;
	}
	public void setMatchLocation(String matchLocation) {
		this.matchLocation = matchLocation;
	}
	public Date getPlayDate() {
		return playDate;
	}
	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getMatFin() {
		return matFin;
	}
	public void setMatFin(int matFin) {
		this.matFin = matFin;
	}
	

	
}
