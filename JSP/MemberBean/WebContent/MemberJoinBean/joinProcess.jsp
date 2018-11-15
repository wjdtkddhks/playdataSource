<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="member.MemberDBBean" %>
<%request.setCharacterEncoding("UTF-8");%>

<jsp:useBean id="member" class="member.MemberDataBean"></jsp:useBean>
<jsp:setProperty name="member" property="*" />

<%
		MemberDBBean manager = MemberDBBean.getInstance();
		int result = manager.insertMember(member);
 		
 		if(result != 0){
 			out.println("<script>");
 			out.println("alert('가입성공!!!')");
 			out.println("location.href='loginForm.jsp'");
 			out.println("</script>");
 		}else{
 			out.println("<script>");
 			out.println("alert('가입실패!!!')");
 			out.println("location.href='joinForm.jsp'");
 			out.println("</script>");	
 		}

%>