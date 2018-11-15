package com.spring.naonnaTest.team;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.naonnaTest.ground.GroundVO;
import com.spring.naonnaTest.user.UserMapper;

@Service("teamService")
public class TeamServiceImpl implements TeamService {

	@Autowired
	private SqlSession sqlSession;	

	@Override
	public ArrayList<TeamVO> getTeamlistJson(TeamVO teamvo){
		ArrayList<TeamVO> teamlist = null;
		TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
		teamlist = teamMapper.getTeamlist(teamvo);
		
		return teamlist;
	}
	
	@Override
	public ArrayList<TeamVO> getTeamfindson(TeamVO teamvo) {
		ArrayList<TeamVO> teamlist = null;
		try {
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			teamlist = teamMapper.findTeam(teamvo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return teamlist;
		
	}
	
	@Override
	public void insertTeam(TeamVO teamvo) {
		TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
		int res = teamMapper.addTeam(teamvo);
		System.out.println("teamvo.getNickname() + teamvo.getTeam_name() = " + teamvo.getNickname() + teamvo.getTeam_name());
		teamMapper.insertCap(teamvo);
		System.out.println("res = " + res);
						
	}
	
	@Override
	public TeamVO That_Team_Info(String team_name) {
		
		TeamVO ThatTeamInfo = new TeamVO();
		TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
		ThatTeamInfo = teamMapper.getThatTeamInfo(team_name);
		
		return ThatTeamInfo;
	}
	
	@Override
	public TeamVO atMatchDetail(String team_name) {
		TeamVO atTheMatch = null;
		System.out.println("team_name = " + team_name);
		try {
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			atTheMatch = teamMapper.atMatchDetail(team_name);
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		return atTheMatch;
	}
	
	@Override
	public void insertMember(TeamVO vo) {
		System.out.println("insertMember DAO");
		try {
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			teamMapper.insertTeamMember(vo);
			teamMapper.plusTeamPeople(vo);
			teamMapper.joinConfirm(vo);
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	@Override
	public ArrayList<TeamMemberVO> memberPrint(String team_name) {
		ArrayList<TeamMemberVO> list = null;
		
		try {
			TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
			list = teamMapper.printTeamMember(team_name);
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		return list;
		
	}
	
	@Override
	public void updateTeam(HashMap<String,String> map) {		 
		
		TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
		 try {
			 teamMapper.updateTeamName(map);
		 }
		 catch(Exception e) {
			 e.getMessage();
			 e.getStackTrace();
		 }	 
	}

	@Override
	public int teamCut(String nickname , String hometeam) {
		TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
		int i=0;
		try {
		     teamMapper.catNumZero(nickname);
		     teamMapper.matchingdel(hometeam);
		 i = teamMapper.teamdelete(nickname);
		}
		catch(Exception e) {
			e.getMessage();
			e.getStackTrace();
		}
		return i;
	}
}
