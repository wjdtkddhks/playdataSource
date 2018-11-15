package com.spring.springmybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MybatisController {
		
	@Autowired
	private MemberDAOService memberDAOService;
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisController.class);
	
	@RequestMapping("/list.do")
	public ModelAndView main(Locale locale) {
		logger.info("Welcome list.", locale);
		
		//view 화면인 main.jsp에 DB로부터 읽어온 데이터를 보여준다.
		ModelAndView result = new ModelAndView();
		//addObject view에 넘어가는 데이터
		List<MemberVO> memberList = memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		
		return result;
	}
	
	//insert 버튼 클릭 시 값을 가져와서 list.jsp로 화면전환 해준다.
	/*@RequestMapping("/insert.do")
	public ModelAndView insert(MemberVO member) {
		memberDAOService.insertMember(member);
		
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		
		return result;
	}*/
	
	@RequestMapping("/insert.do")
	public ModelAndView insert2(MemberVO member) {
	
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", member.getId());
		map.put("name", member.getName());
		map.put("email", member.getEmail());
		map.put("phone", member.getPhone());
		memberDAOService.insertMember2(map);
		
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		
		return result;
	}
	
	@RequestMapping("/updateForm.do")
	public ModelAndView updateForm(MemberVO member) {
		String id = member.getId();
		member = memberDAOService.getMember(id);
		System.out.println("updateForm complete");
		
		ModelAndView result = new ModelAndView();
		result.addObject("member", member);
		result.setViewName("updateForm");
		
		return result;
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(MemberVO member) {
		memberDAOService.updateMember(member);
		System.out.println("update complete");
		
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		
		return result;
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView delete(MemberVO member) {
		String id = member.getId();
		memberDAOService.deleteMember(id);
		System.out.println("delete complete");
		
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		
		return result;
	}
}
