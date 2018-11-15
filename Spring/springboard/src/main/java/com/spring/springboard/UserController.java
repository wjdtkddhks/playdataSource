package com.spring.springboard;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user.do")
public class UserController {
	
	@Autowired
	private UserService userService = null;
	
	@RequestMapping(params="method=login") // value="/user.do?method=login"
	public String login(UserVO userVO, HttpSession session, Model model) throws Exception{
		System.out.println(userVO.toString());
		UserVO vo = userService.login(userVO);
		
		if(vo != null) {
			session.setAttribute("loginID", vo.getId());
			session.setAttribute("userName", vo.getId());
			session.setAttribute("userRole", vo.getRole());
			return "redirect:/board.do?method=getBoardList";
		}
		else {
			model.addAttribute("loginIs", "fail");
			return "loginForm";
		}
	}
	
	@RequestMapping(params="method=logout")
	public String logout(HttpSession session, Model model) throws Exception{
		session.invalidate();
		model.addAttribute("loginIs", "logout");
		return "loginForm";
	}

}
