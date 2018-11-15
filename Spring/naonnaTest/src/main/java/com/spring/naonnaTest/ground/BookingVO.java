package com.spring.naonnaTest.ground;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BookingVO {
	private String bookNumber;
	private String groundName;
	private String matchingID;
	private String nickname;
	private int assign;
	private Date startTime;
	private Date endTime;
	private int confirm;
	
	public String getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(String booknumber) {
		this.bookNumber = booknumber;
	}
	public String getGroundName() {
		return groundName;
	}
	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}
	public String getMatchingID() {
		return matchingID;
	}
	public void setMatchingID(String matchingID) {
		this.matchingID = matchingID;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getAssign() {
		return assign;
	}
	public void setAssign(int assign) {
		this.assign = assign;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getConfirm() {
		return confirm;
	}
	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}
	
	
}
