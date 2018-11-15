package com.spring.springmember;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImp implements MemberService {
	
	@Autowired(required=false)
	private MemberDAO memberDAO = null;

	@Override
	public int insertMember(MemberVO memberVO) throws Exception {
		return memberDAO.insertMember(memberVO);
	}

	@Override
	public int userCheck(MemberVO memberVO) throws Exception {
		return memberDAO.userCheck(memberVO);
		
	}

	@Override
	public ArrayList<MemberVO> getMemberlist() throws Exception {
		return memberDAO.getMemberlist();
	}

	@Override
	public MemberVO selectMember(MemberVO memberVO) throws Exception {
		return memberDAO.selectMember(memberVO);
	}

	@Override
	public int deleteMember(MemberVO memberVO) throws Exception {
		return memberDAO.deleteMember(memberVO);
	}

	@Override
	public int updateMember(MemberVO memberVO) throws Exception {
		return memberDAO.updateMember(memberVO);
	}

}
