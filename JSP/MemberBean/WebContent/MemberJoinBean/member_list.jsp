<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@page import="java.util.*"%>
<%@ page import="member.MemberDataBean" %>
<%@ page import="member.MemberDBBean" %>

<%
	ArrayList<MemberDataBean> member_list = null;
	
	if(session.getAttribute("id") == null || (!((String)session.getAttribute("id")).equals("admin"))){
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
	
	MemberDBBean manager = MemberDBBean.getInstance();
	member_list = manager.getMemberList();
	
%>
<html>
<head>
<title>회원관리시스템 관리자 모드</title>
<style>
	table{
		margin: 20px auto;
		width: 400px;
		border: 1px solid gray;
		text-align: center;
		text-decoration: none;
	}
	.td_title{
		font-weight: bold;
		font-size: x-large;
	}
</style>
</head>
<body>
	<table border=1>
		<tr><td colspan=3 class='td_title'>회원 명단</td></tr>
		<tr><td>아이디</td><td>삭제</td><td>수정</td></tr>
	<%for(int i=0; i<member_list.size(); i++){
		MemberDataBean obj = member_list.get(i);
		%>
		<tr>
		<td><a href='member_info.jsp?id=<%=obj.getId()%>'><%=obj.getId()%></a></td>
		<td><a href='member_delete.jsp?id=<%=obj.getId()%>'>삭제</a></td>
		<td><a href='member_update.jsp?id=<%=obj.getId()%>'>수정</a></td>
		</tr>	
	<%} %>
	</table>
</body>
</html>