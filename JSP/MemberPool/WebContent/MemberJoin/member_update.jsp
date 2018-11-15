<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:include page='admincheck.jsp' />

<%
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	String id_info = request.getParameter("id");
	String sql = "select * from member where id =?";
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id_info);
		rs = ptmt.executeQuery();
		rs.next();
		
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
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
<form name='updateform' action='updateProcess.jsp?id=<%=rs.getString("id")%>' method='post'>
	<table border=1>
		<tr><td colspan=2 class='td_title'><%=id_info %>님의 정보</td></tr>
		<tr>
			<td>아이디 : </td>
			<td><%=rs.getString("id") %></td>	
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><input type='password' name='password' value='<%=rs.getString("password")%>' /></td>	
		</tr>
		<tr>
			<td>이름 : </td>
			<td><input type='text' name='name' value='<%=rs.getString("name")%>' /></td>	
		</tr>
		<tr>
			<td>나이 : </td>
			<td><input type='text' name='age' value='<%=rs.getInt("age")%>' /></td>	
		</tr>
		<tr>
			<td>성별 : </td>
			<td><input type='radio' id='gender1' name='gender' value='남' <%if(rs.getString("gender").equals("남")){ %>checked<%}%> /><label for='gender1'>남자</label>
			<input type='radio' id='gender2' name='gender' value='여' <%if(rs.getString("gender").equals("여")){ %>checked<%}%>/> <label for='gender2'>여자</label></td>	
		</tr>
		<tr>
			<td>이메일주소 : </td>
			<td><input type='text' name='email' value='<%=rs.getString("email")%>' /></td>	
		</tr>
		<tr>
		<td colspan=2><a href='javascript:updateform.submit()'>수정</a>&nbsp;&nbsp;
		<a href='member_list.jsp'>리스트로 돌아가기</a>
	</table>
</form>
</body>
</html>