<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="member.MemberDBBean" %>
<jsp:useBean id='member' class='member.MemberDataBean' />

<%
	if(session.getAttribute("id") == null || (!((String)session.getAttribute("id")).equals("admin"))){
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
	
	String id_info = request.getParameter("id");
	MemberDBBean manager = MemberDBBean.getInstance();
	member = manager.getMember(id_info);
%>
<html>
<head>
<title>member_info</title>
<style>
	table{
		margin: 20px auto;
		width: 400px;
		border: 1px solid gray;
		text-align: center;
	}
	.td_title{
		font-weight: bold;
		font-size: x-large;
	}
</style>
</head>
<body>
	<table border=1>
		<tr><td colspan=2 class='td_title'><%=member.getId()%>의 정보</td></tr>
		<tr>
			<td>아이디 : </td>
			<td><%=member.getId()%></td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><%=member.getPassword()%></td>
		</tr>
		<tr>
			<td>이름 : </td>
			<td><%=member.getName()%></td>
		</tr>
		<tr>
			<td>나이 : </td>
			<td><%=member.getAge()%></td>
		</tr>
		<tr>
			<td>성별 : </td>
			<td><%=member.getGender()%></td>
		</tr>
		<tr>
			<td>이메일 : </td>
			<td><%=member.getEmail()%></td>
		</tr>
		<tr>
			<td colspan=2><a href="member_list.jsp">리스트로 돌아가기</a></td>
		</tr>
	</table>
</body>
</html>