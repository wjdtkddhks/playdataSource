<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	String sql ="insert into student (num, name) values(13, '홍길동')";
	String sql2 = "select * from student where num=12";
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		conn.setAutoCommit(false);
		
		ptmt = conn.prepareStatement(sql);
		ptmt.executeUpdate();
		ptmt.close();
		
		ptmt = conn.prepareStatement(sql2);
		rs = ptmt.executeQuery();
		if(!rs.next()){
			conn.rollback();
			out.println("<h3>데이터 삽입에 문제가 발생하여 롤백하였습니다.</h3>");
		}else{
			conn.commit();
			out.println("<h3>데이터 삽입이 모두 완료되었습니다.</h3>");
		}
		conn.setAutoCommit(true);
		
	}catch(Exception e){
		out.println("<h3>데이터 삽입에 실패하였습니다.</h3>" + e.getMessage());
		e.printStackTrace();
	}finally{
		try{
			if(rs != null) rs.close();
			if(ptmt != null) ptmt.close();
			if(conn != null) conn.close();
		}catch(Exception ignored){}
	}
%>