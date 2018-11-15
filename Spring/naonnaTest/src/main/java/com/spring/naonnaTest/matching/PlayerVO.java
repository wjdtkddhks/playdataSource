package com.spring.naonnaTest.matching;

import org.springframework.stereotype.Component;

@Component
public class PlayerVO {
	private String nickname;
	private String matchingID;
	private int people;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMatchingID() {
		return matchingID;
	}
	public void setMatchingID(String matchingID) {
		this.matchingID = matchingID;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
}
