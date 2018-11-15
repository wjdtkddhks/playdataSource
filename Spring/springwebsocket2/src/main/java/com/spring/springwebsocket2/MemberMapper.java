package com.spring.springwebsocket2;

public interface MemberMapper {

	int insertMember(MemberVO vo);
	int userCheckMember(String id);
	String pickNameMember(String id);
}
