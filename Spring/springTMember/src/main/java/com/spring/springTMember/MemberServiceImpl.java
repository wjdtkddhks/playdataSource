package com.spring.springTMember;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired(required=false)
	private MemberDAO memberDAO = null;
	
	public int insertMember(MemberVO memberVO) throws Exception{
		try {
			int res = memberDAO.insertMember(memberVO);
			return res;
		} catch (Exception e) {
			throw new Exception("회원등록 실패", e);
		}
	}
	
	public int userCheck(MemberVO memberVO) throws Exception{
		try {
			int res = memberDAO.userCheck(memberVO);
			return res;
		} catch (Exception e) {
			throw new Exception("회원확인 실패", e);
		}
	}
	
	public ArrayList<MemberVO> getMemberlist() throws Exception{
		try {
			ArrayList<MemberVO> member_list = memberDAO.getMemberlist();
			return member_list;
		} catch (Exception e) {
			throw new Exception("회원리스트 검색 실패", e);
		}
	}
	
	public MemberVO selectMember(MemberVO memberVO) throws Exception{
		try {
			MemberVO vo = memberDAO.selectMember(memberVO);
			return vo;
		} catch (Exception e) {
			throw new Exception("회원검색 실패", e);
		}
	}
	
	public int deleteMember(MemberVO memberVO) throws Exception{
		try {
			int res = memberDAO.deleteMember(memberVO);
			return res;
		} catch (Exception e) {
			throw new Exception("회원삭제 실패", e);
		}
	}
	
	public int updateMember(MemberVO memberVO) throws Exception{
		try {
			int res = memberDAO.updateMember(memberVO);
			return res;
		} catch (Exception e) {
			throw new Exception("회원수정 실패", e);
		}
	}
}
