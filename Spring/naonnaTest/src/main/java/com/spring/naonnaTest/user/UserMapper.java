package com.spring.naonnaTest.user;

import java.util.HashMap;

public interface UserMapper {
	
	UserVO getUserInfo(String forPerson);
	void insertUserInfo(UserVO vo);
	UserVO myUserInfo(String nickname);
	void updateInfo(UserVO vo);
	void updateProfile(UserVO vo);
	int getUserNick(String nickname);
	
	
	void teamMemdelete(String nickname);
	int teamDraw(String nickname);
	void minTeamMem(HashMap<String,Object> map);
}
