package com.spring.naonnaTest.message;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MessageVO {
	
	private String getPeople;
	private String sendPeople;
	private String matchingID;
	private String message;
	private int confirm;
	private int people;
	private String teamName;
	private String groundName;
	private Date messageDate;
	
	public String getGetPeople() {
		return getPeople;
	}
	public void setGetPeople(String getPeople) {
		this.getPeople = getPeople;
	}
	public String getSendPeople() {
		return sendPeople;
	}
	public void setSendPeople(String sendPeople) {
		this.sendPeople = sendPeople;
	}
	public String getMatchingID() {
		return matchingID;
	}
	public void setMatchingID(String matchingID) {
		this.matchingID = matchingID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getConfirm() {
		return confirm;
	}
	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getGroundName() {
		return groundName;
	}
	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	
}
