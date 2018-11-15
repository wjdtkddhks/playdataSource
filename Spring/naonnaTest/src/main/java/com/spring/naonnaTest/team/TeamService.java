package com.spring.naonnaTest.team;

import java.util.ArrayList;
import java.util.HashMap;

public interface TeamService {
	
	ArrayList<TeamVO> getTeamlistJson(TeamVO teamvo);
	ArrayList<TeamVO> getTeamfindson(TeamVO teamvo);
	public void insertTeam(TeamVO teamvo);
	TeamVO That_Team_Info(String team_name);
	TeamVO atMatchDetail(String team_name);
	void insertMember(TeamVO vo);
	ArrayList<TeamMemberVO> memberPrint(String team_name);
	
	void updateTeam( HashMap<String,String> map);
	int teamCut(String nickname , String hometeam);
	
}
