<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:include page='admincheck.jsp' />

<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	
	Connection conn = null;
	PreparedStatement ptmt = null;
	String sql = "update member set password=?, name=?, age=?, gender=?, email=? where id=?";
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, password);
		ptmt.setString(2, name);
		ptmt.setInt(3, age);
		ptmt.setString(4, gender);
		ptmt.setString(5, email);
		ptmt.setString(6, id);
		int res = ptmt.executeUpdate();
		
		if(res != 0){
			out.println("<script>");
			out.println("alert('수정성공!!!')");
			out.println("location.href='member_list.jsp'");
			out.println("</script>");
		}else{
			out.println("<script>");
			out.println("alert('수정실패!!!')");
			out.println("location.href='member_list.jsp'");
			out.println("</script>");			
		}		
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}finally{
 		try{
 			if(ptmt != null) ptmt.close();
 			if(conn != null) conn.close();
 		}catch(Exception e){
 			e.printStackTrace();
 		}
	}
%>