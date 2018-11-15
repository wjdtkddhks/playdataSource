package com.spring.springwebsocket2;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	MemberDAO memberDAO;
	
	@RequestMapping(value = "client_chat.do", method = RequestMethod.GET)
	public String home2() {
		return "client_chat";
	}
	
	@RequestMapping(value ="client_chat_seoul.do", method = RequestMethod.GET)
	public String regionChat(HttpServletRequest request, Model model) {
		String region = request.getParameter("region");
		System.out.println("home4 region : " + region);
		model.addAttribute("region", region);
		return "client_chat_seoul";
	}
	
	@RequestMapping(value ="client_chat_onechat.do", method = RequestMethod.GET)
	public String onechat(HttpServletRequest request, Model model) {
		String userName = request.getParameter("userName");
		model.addAttribute("userName", userName);
		return "client_chat_onechat";
	}
	
	@RequestMapping(value = "joinForm.do")
	public String joinForm() {
		return "joinForm";
	}

	@RequestMapping(value = "loginForm.do")
	public String loginForm() {
		return "loginForm";
	}

	@RequestMapping(value = "/")
	public String home() {
		return "loginForm";
	}

	@RequestMapping(value = "memberinsert.do")
	public String memberinsert(MemberVO vo) {
		memberDAO.insertMember(vo);
		return "loginForm";
	}
	
	@RequestMapping(value = "memberCheck.do")
	public String userCheckMember(MemberVO vo, HttpSession session, HttpServletResponse response) {
		int res = memberDAO.userCheckMember(vo);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		try {
		PrintWriter writer = response.getWriter();
		
		if(res == 1) {
			session.setAttribute("id", vo.getId());
			String name = memberDAO.pickNameMember(vo);
			session.setAttribute("name", name);
			writer.write("<script>alert('로그인성공!!');location.href='./client_chat.do';</script>");
		}
		else {
			writer.print("<script>alert('로그인실패!!');location.href='./loginForm.do';</script>");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return null;
	}
}
