<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.net.URLDecoder" %>
<%@ include file="dbinfo.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	//URLDecoder.decode()는 ajax()로 전달된 한글을 디코딩하기 위해 사용
	String id = URLDecoder.decode(request.getParameter("id"), "UTF-8");
	String name = URLDecoder.decode(request.getParameter("name"), "UTF-8");
	System.out.println("name = " + name);
	String job = URLDecoder.decode(request.getParameter("job"), "UTF-8");
	String address = URLDecoder.decode(request.getParameter("address"), "UTF-8");
	String bloodtype = URLDecoder.decode(request.getParameter("bloodtype"), "UTF-8");
	
	String sql ="";
	int cnt = 0;
	Connection con = null;
	PreparedStatement ptmt = null;
	
	try{
		Class.forName(driverName);
		con = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		sql = "insert into people(id, name, job, address, bloodtype) values(?,?,?,?,?)";
		ptmt = con.prepareStatement(sql);
		ptmt.setString(1, id);
		ptmt.setString(2, name);
		ptmt.setString(3, job);
		ptmt.setString(4, address);
		ptmt.setString(5, bloodtype);
		cnt = ptmt.executeUpdate();
		
		if(cnt == 1){
%>
		{"result" : "success"}
<% 			
		}
		
	}catch(Exception e){
		e.printStackTrace();
%>
		{"result" : "failure"}
<%
	}finally{
		if(ptmt != null)try{ptmt.close();}catch(SQLException e){}
		if(con != null)try{con.close();}catch(SQLException e){}
	}

%>