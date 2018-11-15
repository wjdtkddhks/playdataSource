package com.spring.naonnaTest.admin;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping(value="joinAdmin.do" , method = RequestMethod.POST)
	public String insert_Admin (AdminVO vo, HttpServletResponse response ) throws Exception {	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
				
		int check = adminService.insertAdmin(vo);	
		
		System.out.println("check :"+ check);
		
		if(check == 1) {
			out.println("<script>");
			out.println("alert('회원가입이 완료되었습니다.');");
			out.println("alert('로그인 해주세요.');");
			out.println("location.href='home.do';");
			out.println("</script>");			
			out.close();
			
		}else {
			out.println("<script>");
			out.println("alert('회원가입이 실패했습니다.다시 가입해주세요');");
			out.println("location.href='home.do';");
			out.println("</script>");			
			out.close();
		}
		

		return null;
		
	}
	
	@RequestMapping(value="login_a.do" , method = RequestMethod.POST)
	public ModelAndView AdminLogin(AdminVO vo, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ModelAndView aaa = new ModelAndView();
		AdminVO man = null;
		int check = adminService.userCheck(vo);
		System.out.println("check :" + check);
		if(check ==1 ) {
			
			
			man = adminService.getAdminInfo(vo);
			System.out.println("man_관리자 :" + man.getGround_admin());
			System.out.println("man_그라운드네임 :" + man.getGround_name());
			
			session.setAttribute("admin", man.getGround_admin());
			session.setAttribute("groundName", man.getGround_name());
			aaa.setViewName("manager_index");
			
			
		}
		else if(check == 0){
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다. 다시 로그인해주세요.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}else{
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return aaa;
		
		
	}
		
	
	@RequestMapping("idcheck.do")
    @ResponseBody
    public Map<Object, Object> idcheck(@RequestBody String admin) {
        
        int count = 0;
        Map<Object, Object> map = new HashMap<Object, Object>();
 
        count = adminService.idcheck(admin);
        map.put("cnt", count);
 
        return map;
    }
	
	@RequestMapping(value="logout_a.do")
	public ModelAndView AdminLogout( HttpSession session, HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		session.invalidate();
		
		out.println("<script>");
		out.println("alert('로그아웃 되었습니다.');");
		out.println("location.href='home.do';");
		out.println("</script>");			
		out.close();
		

		return null;
		
	}
}
