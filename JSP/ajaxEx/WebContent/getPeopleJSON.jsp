<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="dbinfo.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");	
	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	String sql ="";
	
	try{
		Class.forName(driverName);
		con = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		sql = "select * from people order by id asc";
		
		ptmt = con.prepareStatement(sql);
		rs = ptmt.executeQuery();
%>
[
<%
		while(rs.next()){
			String id = rs.getString("id");
			String name = rs.getString("name");
			String job = rs.getString("job");
			String address = rs.getString("address");
			String bloodtype = rs.getString("bloodtype");
			
			if(rs.getRow()>1){
				out.print(",");
			}
%>
	{
		"id" : "<%=id %>",
		"name" : "<%=name %>",
		"job" : "<%=job %>",
		"address" : "<%=address %>",
		"bloodtype" : "<%=bloodtype %>"
	}	
<%
		}
%>
]
<% 
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs != null)try{rs.close();}catch(SQLException e){}
		if(ptmt != null)try{ptmt.close();}catch(SQLException e){}
		if(con != null)try{con.close();}catch(SQLException e){}
	}
%>