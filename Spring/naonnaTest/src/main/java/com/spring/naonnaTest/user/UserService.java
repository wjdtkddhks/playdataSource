package com.spring.naonnaTest.user;

import java.util.HashMap;

public interface UserService {
	
	UserVO distMember(String forPerson);
	void insertUser(UserVO vo);
	UserVO printUser(String forPerson);
	UserVO goMyPage(String nickname);
	void updateInfo(UserVO vo);
	void updateProfile(UserVO vo);
	int nickcheck(String nickname);
	UserVO getTeamUser (String nickname);
	
	int goWithdrawTeam(String nickname);
	void minusTeam(HashMap<String,Object> map);
	
	
	
	
}
