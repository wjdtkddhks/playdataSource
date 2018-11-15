package com.spring.naonnaTest.team;

import org.springframework.stereotype.Component;

@Component
public class TeamVO {
	private String team_name;
	private String nickname;
	private String age;
	private String emblem;
	private String ability;
	private String intro;
	private int number_team;
	private String area;
		

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmblem() {
		return emblem;
	}
	public void setEmblem(String emblem) {
		this.emblem = emblem;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getNumber_team() {
		return number_team;
	}
	public void setNumber_team(int number_team) {
		this.number_team = number_team;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}


}
