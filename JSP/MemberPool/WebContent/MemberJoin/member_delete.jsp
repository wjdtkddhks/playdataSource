<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>


<jsp:include page='admincheck.jsp' />
<%
	
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	String id_info = request.getParameter("id");
	String sql = "delete from member where id = ?";
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id_info);
		int res = ptmt.executeUpdate();
		
		if(res != 0){
			out.println("<script>");
			out.println("alert('삭제 성공!')");
			out.println("location.href='member_list.jsp'");
			out.println("</script>");
		}
		else{
			out.println("<script>");
			out.println("alert('삭제 실패!')");
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
 		}catch(Exception xe){
 			xe.printStackTrace();
 		}
 	}
%>