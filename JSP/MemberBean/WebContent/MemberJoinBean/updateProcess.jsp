<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="member.MemberDBBean" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id='member' class='member.MemberDataBean' />
<jsp:setProperty name='member' property='*' />
<jsp:include page='admincheck.jsp' />

<% 
	MemberDBBean manager = MemberDBBean.getInstance();
	int result = manager.updateMember(member);
	
	if(result != 0){
		out.println("<script>");
		out.println("alert('수정성공!!!')");
		out.println("location.href='member_list.jsp'");
		out.println("</script>");
	}else{
		out.println("<script>");
		out.println("alert('수정실패!!!')");
		out.println("location.href='member_list.jsp'");
		out.println("</script>");			
	}
%>
