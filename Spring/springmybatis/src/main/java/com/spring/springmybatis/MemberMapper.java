package com.spring.springmybatis;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberMapper {
	
	ArrayList<MemberVO> getMembers();
	//ArrayList<MemberVO> getMembers(String t);
	MemberVO getMember(String id);
	//HashMap<String, String> getMember(String id)
	int insertMember(MemberVO member);
	void insertMember2(HashMap<String, String> map);
	void updateMember(MemberVO member);
	void deleteMember(String id);
	int getCount();
}
