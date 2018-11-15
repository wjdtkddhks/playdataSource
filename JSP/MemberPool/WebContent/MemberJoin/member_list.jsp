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
	String sql = "select * from member order by id";
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		ptmt = conn.prepareStatement(sql);
		rs=ptmt.executeQuery();
		
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
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
	<%while(rs.next()){  %>
		<tr>
		<td><a href='member_info.jsp?id=<%=rs.getString("id")%>'><%=rs.getString("id")%></a></td>
		<td><a href='member_delete.jsp?id=<%=rs.getString("id")%>'>삭제</a></td>
		<td><a href='member_update.jsp?id=<%=rs.getString("id")%>'>수정</a></td>
		</tr>	
	<%} %>
	</table>
</body>
</html>