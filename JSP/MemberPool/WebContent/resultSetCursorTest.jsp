<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="javax.naming.*" %>
<%

	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	String sql ="select * from student";
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		ptmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
		
		rs = ptmt.executeQuery();
		
		rs.last();
		
		out.println(rs.getInt(1) + ", " + rs.getString(2) + "<br/>");
		rs.first();
		out.println(rs.getInt(1) + ", " + rs.getString(2) + "<br/>");
		rs.absolute(3);
		out.println(rs.getInt(1) + ", " + rs.getString(2) + "<br/>");
		
	}catch(Exception e){
		out.println("<h3>데이터 읽어오기 실패!!!</h3>");
		e.printStackTrace();
		
	}finally{
		try{
			if(rs != null) rs.close();
			if(ptmt != null) ptmt.close();
			if(conn != null) conn.close();
		}catch(Exception ignored){}
	}
	
	
%>