<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	String sql = "select * from member where id=?";
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn=ds.getConnection();
		
		ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id);
		rs = ptmt.executeQuery();
		
		if(rs.next()){
			if(password.equals(rs.getString("password"))){
				session.setAttribute("id", id);
				out.println("<script>");
				out.println("location.href='main.jsp'");
				out.println("</script>");
			}
		}
		
		out.println("<script>");
		out.println("alert('일치하는 정보가 없습니다. 확인해주세요.')");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");

	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}finally{
 		try{
 			if(ptmt != null) ptmt.close();
 			if(conn != null) conn.close();
 		}catch(Exception xe){
 			xe.printStackTrace();
 		}
 	}
%>