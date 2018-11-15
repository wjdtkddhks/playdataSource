package com.spring.springwebsocket2;

public interface MemberDAO {
	
	public int insertMember(MemberVO vo);
	public int userCheckMember(MemberVO vo);
	public String pickNameMember(MemberVO vo);
}
