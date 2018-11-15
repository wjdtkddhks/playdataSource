<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="member.MemberDBBean"%>
<%request.setCharacterEncoding("UTF-8"); %>

<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	MemberDBBean manager = MemberDBBean.getInstance();
	int result = manager.userCheck(id, password);
		
		if(result == 0){
			session.setAttribute("id", id);
			out.println("<script>");
			out.println("location.href='main.jsp'");
			out.println("</script>");
		}else if(result == 1){
			out.println("<script>");
			out.println("alert('패스워드가 일치하지 않습니다. 확인해주세요.')");
			out.println("location.href='loginForm.jsp'");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('일치하는 정보가 없습니다. 확인해주세요.')");
			out.println("location.href='loginForm.jsp'");
			out.println("</script>");
		}
%>