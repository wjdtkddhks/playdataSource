package com.spring.springchat;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAOService implements MemberDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int userCheckMember(MemberVO vo) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.userCheckMember(vo.getId());
		System.out.println(res);
		return res;
	}

	@Override
	public int insertMember(MemberVO vo) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.insertMember(vo);
		System.out.println(res);
		return res;
	}

	@Override
	public String pickName(MemberVO vo) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		String name = memberMapper.pickName(vo.getId());
		System.out.println(name);
		return name;
	}

}
