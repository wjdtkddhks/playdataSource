package com.spring.naonnaTest.team;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring.naonnaTest.ground.GroundVO;

public interface TeamMapper {
	
	public ArrayList<TeamVO> getTeamlist(TeamVO teamvo);  // 팀 목록 가져오기 
	public ArrayList<TeamVO> findTeam(TeamVO teamvo);
	public int addTeam (TeamVO teamvo);
	public TeamVO getThatTeamInfo(String team_name);
	public void insertCap(TeamVO teamvo);
	public TeamVO atMatchDetail(String team_name);
	void insertTeamMember(TeamVO vo);
	void plusTeamPeople(TeamVO vo);
	void joinConfirm(TeamVO vo);
	public ArrayList<TeamMemberVO> printTeamMember(String team_name);
	
	void updateTeamName(HashMap<String,String> map);
	int teamdelete(String nickname);
	void catNumZero(String nickname);
	void matchingdel(String hometeam);
	
	
}
