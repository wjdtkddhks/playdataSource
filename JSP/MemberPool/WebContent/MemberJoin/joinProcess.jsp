<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%
	request.setCharacterEncoding("UTF-8");
 	String id = request.getParameter("id");
 	String password = request.getParameter("password");
 	String name = request.getParameter("name");
 	int age = Integer.parseInt(request.getParameter("age"));
 	String gender = request.getParameter("gender");
 	String email = request.getParameter("email");
 	
 	Connection conn = null;
 	PreparedStatement ptmt = null;
 	
 	try{
 		Context init = new InitialContext();
 		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
 		conn = ds.getConnection();
 		
 		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
 		
 		ptmt = conn.prepareStatement(sql);
 		ptmt.setString(1, id);
 		ptmt.setString(2, password);
 		ptmt.setString(3, name);
 		ptmt.setInt(4, age);
 		ptmt.setString(5, gender);
 		ptmt.setString(6, email);
 		int res = ptmt.executeUpdate();
 		
 		if(res != 0){
 			out.println("<script>");
 			out.println("alert('가입성공!!!')");
 			out.println("location.href='loginForm.jsp'");
 			out.println("</script>");
 		}else{
 			out.println("<script>");
 			out.println("alert('가입실패!!!')");
 			out.println("location.href='joinForm.jsp'");
 			out.println("</script>");	
 		}
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