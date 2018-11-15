package com.spring.springmember;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member.mo")
public class MemberController {
	
	@Autowired
	private MemberService memberService = null;
	
	@RequestMapping(params="method=joinForm")
	public String joinForm() throws Exception {
		return "joinForm";
	}

	@RequestMapping(params="method=insertMember")
	public String insertMember(MemberVO memberVO, Model model) throws Exception {
		int check = memberService.userCheck(memberVO);
		if(check  == -1) {
			int result = memberService.insertMember(memberVO);
		
			if(result!=0){  	
				model.addAttribute("loginIs", "joinSuccess");
				return "loginForm";
			}
				
			model.addAttribute("loginIs", "joinFail");
			return "loginForm";
		}
		model.addAttribute("loginIs", "alreadId");
		return "joinForm";
	}

	@RequestMapping(params="method=userCheck")
	public String userCheck(MemberVO memberVO, HttpSession session, Model model) throws Exception {
		int check = memberService.userCheck(memberVO);
		
		if (check == 1)
		{
			session.setAttribute("id", memberVO.getId());
			return "main";
		}
		else if (check == 0)
		{
			model.addAttribute("loginIs", "passFail");
			return "loginForm";
		}
		
		model.addAttribute("loginIs", "allFail");
		return "loginForm";
	}

	@RequestMapping(params="method=getMemberlist")
	public String getMemberlist(Model model) throws Exception {
		ArrayList<MemberVO> memberList = memberService.getMemberlist();
		model.addAttribute("MemberList", memberList);
		return "member_list";
	}
	
	@RequestMapping(params="changeMember=updateSuccess")
	public String getMemberlistUpdate(Model model) throws Exception {
		ArrayList<MemberVO> memberList = memberService.getMemberlist();
		model.addAttribute("MemberList", memberList);
		model.addAttribute("changeMember", "updateSuccess");
		return "member_list";
	}
	
	@RequestMapping(params="changeMember=deleteSuccess")
	public String getMemberlistDelete(Model model) throws Exception {
		ArrayList<MemberVO> memberList = memberService.getMemberlist();
		model.addAttribute("MemberList", memberList);
		model.addAttribute("changeMember", "deleteSuccess");
		return "member_list";
	}

	@RequestMapping(params="method=selectMember")
	public String selectMember(MemberVO memberVO, Model model) throws Exception {
		MemberVO vo = memberService.selectMember(memberVO);
		model.addAttribute("MemberVO", vo);
		return "member_info";
	}
	
	@RequestMapping(params="method=updateForm")
	public String updateForm(MemberVO memberVO, Model model) throws Exception {
		MemberVO vo = memberService.selectMember(memberVO);
		model.addAttribute("MemberVO", vo);
		return "member_updateForm";
	}

	@RequestMapping(params="method=deleteMember")
	public String deleteMember(MemberVO memberVO, Model model) throws Exception {
		int check = memberService.deleteMember(memberVO);
		if(check == 1) {
			return "redirect:/member.mo?changeMember=deleteSuccess";
		}
		return "redirect:/member.mo?method=getMemberlist";
	}

	@RequestMapping(params="method=updateMember")
	public String updateMember(MemberVO memberVO, Model model) throws Exception {
		int check = memberService.updateMember(memberVO);
		if(check == 1) {
			return "redirect:/member.mo?changeMember=updateSuccess";
		}
		return "redirect:/member.mo?method=getMemberlist";
	}
	

}
