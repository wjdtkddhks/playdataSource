<%@page import="oracle.sql.CLOB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	StringBuffer sb = null;
	
	String sql = "insert into clobtable values(3, ?)";
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		sb = new StringBuffer();
		for(int i=0; i<=10000; i++){
			sb.append("홍길동");}
		
		ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, sb.toString());
		ptmt.executeUpdate();

		out.println("데이터를 저장했습니다.");

	}catch(Exception e){
		out.println("데이터를 저장했습니다." + e.getMessage());
		e.printStackTrace();
	}finally{
		try{
			if(ptmt !=null) ptmt.close();
			if(conn !=null) conn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
%>