package com.spring.springchat;


import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	MemberDAO memberDAO;
	
	@RequestMapping(value="loginForm.do")
	public String home() { //파라미터값은 사실상 쓸모없음, 비어도 됨
		System.out.println("HomeController.java에서 시작.");
		return "loginForm";
	}
	
	@RequestMapping(value="joinForm.do")
	public String joinForm() { //파라미터값은 사실상 쓸모없음, 비어도 됨
		System.out.println("joinForm.java에서 시작.");
		return "joinForm";
	}
	
	@RequestMapping(value="client_chat.do")
	public String client_chat() { //파라미터값은 사실상 쓸모없음, 비어도 됨
		System.out.println("client_chat.java에서 시작.");
		return "client_chat";
	}
	
	@RequestMapping(value="memberinsert.do")
	public String memberinsert(MemberVO vo) { //파라미터값은 사실상 쓸모없음, 비어도 됨
		System.out.println("memberinsert.java에서 시작.");
		memberDAO.insertMember(vo);
		return "redirect:/loginForm.do";
	}
	
	@RequestMapping(value="memberCheck.do")
	public String memberCheck(MemberVO vo, HttpSession session, HttpServletResponse response) throws Exception{ //파라미터값은 사실상 쓸모없음, 비어도 됨
		System.out.println("memberCheck.do에서 시작.");
		int res = memberDAO.userCheckMember(vo);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		if(res == 1) {
			session.setAttribute("id", vo.getId());
			String name = memberDAO.pickName(vo);
			session.setAttribute("name", name);
			writer.print("<script>alert('로그인 성공');location.href='./client_chat.do';</script>");
		}else {
			writer.print("<script>alert('로그인 실패');location.href='./loginForm.do';</script>");
		}
		
		return null;
	}
}
