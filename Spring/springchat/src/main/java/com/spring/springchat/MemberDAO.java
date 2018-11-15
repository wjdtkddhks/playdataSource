package com.spring.springchat;

public interface MemberDAO {
	
	int userCheckMember(MemberVO vo);
	int insertMember(MemberVO vo);
	String pickName(MemberVO vo);
}
