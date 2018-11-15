<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%
	String id="";

	if(session.getAttribute("id") == null || (!((String)session.getAttribute("id")).equals("admin"))){
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
	
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	String id_info = request.getParameter("id");
	String sql = "select * from member where id=?";
	
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
		<tr><td colspan=2 class='td_title'><%=rs.getString("id")%>의 정보</td></tr>
		<tr>
			<td>아이디 : </td>
			<td><%=rs.getString("id")%></td>
		</tr>
		<tr>
			<td>아이디 : </td>
			<td><%=rs.getString("password")%></td>
		</tr>
		<tr>
			<td>이름 : </td>
			<td><%=rs.getString("name")%></td>
		</tr>
		<tr>
			<td>나이 : </td>
			<td><%=rs.getInt("age")%></td>
		</tr>
		<tr>
			<td>성별 : </td>
			<td><%=rs.getString("gender")%></td>
		</tr>
		<tr>
			<td>이메일 : </td>
			<td><%=rs.getString("email")%></td>
		</tr>
		<tr>
			<td colspan=2><a href="member_list.jsp">리스트로 돌아가기</a></td>
		</tr>
	</table>
</body>
</html>