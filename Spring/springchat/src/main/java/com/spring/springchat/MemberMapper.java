package com.spring.springchat;

public interface MemberMapper {

	int userCheckMember(String id);
	int insertMember(MemberVO vo);
	String pickName(String id);
}
