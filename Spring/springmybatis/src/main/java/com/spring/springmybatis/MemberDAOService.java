package com.spring.springmybatis;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAOService implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession; //Mybatis 라이브러지 제공 클래스(sqlSessionTemplete 객체가 들어감(자식이기때문에))
	
	public ArrayList<MemberVO> getMembers(){
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		//getMembers()의 메소드명과 mapper.xml의 id는 동일해야 한다.
		memberList = memberMapper.getMembers();
		System.out.println(memberMapper.getCount());
		//memberList = memberMapper.getMembers("tab_mybatis");
		
		return memberList;
	}
	
	public void insertMember(MemberVO member) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.insertMember(member);
		System.out.println("res = " + res);
	}
	
	public void insertMember2(HashMap<String, String> map) {
		System.out.println("hashmap");
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember2(map);
	}

	public MemberVO getMember(String id) {
		MemberVO member = new MemberVO();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		member = memberMapper.getMember(id);
		
		return member;
	}
	
	/*public MemberVO getMember(String id) {
		MemberVO member = new MemberVO();
		HashMap<String, String> vo = new HashMap<String, String>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		vo = memberMapper.getMember(id);
		member.setId(vo.get("id"));
		member.setName(vo.get("name"));
		member.setEmail(vo.get("email"));
		member.setPhone(vo.get("phone"));
		return member;
	}*/
	
	public void updateMember(MemberVO member) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.updateMember(member);
	}
	
	public void deleteMember(String id) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMember(id);
	}
}
