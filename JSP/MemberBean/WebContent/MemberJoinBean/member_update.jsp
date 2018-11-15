<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="member.MemberDBBean" %>
<%@ page import="member.MemberDataBean" %>
<jsp:include page='admincheck.jsp' />

<% request.setCharacterEncoding("UTF-8"); %>
<%
	String id_info = request.getParameter("id");
	MemberDBBean manager = MemberDBBean.getInstance();
	MemberDataBean member = manager.getMember(id_info);
%>
<html>
<head>
<title>member_update</title>
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
<form name='updateform' action='updateProcess.jsp?id=<%=member.getId() %>' method='post'>
	<table border=1>
		<tr><td colspan=2 class='td_title'><%=member.getId()%>님의 정보</td></tr>
		<tr>
			<td>아이디 : </td>
			<td><%=member.getId() %></td>	
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><input type='password' name='password' value='<%=member.getPassword()%>' /></td>	
		</tr>
		<tr>
			<td>이름 : </td>
			<td><input type='text' name='name' value='<%=member.getName()%>' /></td>	
		</tr>
		<tr>
			<td>나이 : </td>
			<td><input type='text' name='age' value='<%=member.getAge()%>' /></td>	
		</tr>
		<tr>
			<td>성별 : </td>
			<td><input type='radio' id='gender1' name='gender' value='남' <%if(member.getGender().equals("남")){ %>checked<%}%> /><label for='gender1'>남자</label>
			<input type='radio' id='gender2' name='gender' value='여' <%if(member.getGender().equals("여")){ %>checked<%}%>/> <label for='gender2'>여자</label></td>	
		</tr>
		<tr>
			<td>이메일주소 : </td>
			<td><input type='text' name='email' value='<%=member.getEmail()%>' /></td>	
		</tr>
		<tr>
		<td colspan=2><a href='javascript:updateform.submit()'>수정</a>&nbsp;&nbsp;
		<a href='member_list.jsp'>리스트로 돌아가기</a>
	</table>
</form>
</body>
</html>