<%@page import="oracle.sql.CLOB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*" %>

<%
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	StringBuffer sb = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	String sql = "insert into clobtable values(2, empty_clob())";
	String sql2 = "select content from clobtable where num=2 for update";
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, "hr", "123456");
		conn.setAutoCommit(false);
		
		sb = new StringBuffer();
		for(int i=0; i<=10000; i++){
			sb.append("홍길동");}
		
		ptmt = conn.prepareStatement(sql);
		ptmt.executeUpdate();
		ptmt.close();
		
		ptmt = conn.prepareStatement(sql2);
		rs=ptmt.executeQuery();
		
		if(rs.next()){
			oracle.sql.CLOB clob = (oracle.sql.CLOB)(rs).getClob("content");
			BufferedWriter bw = new BufferedWriter(clob.getCharacterOutputStream());
			bw.write(sb.toString());
			bw.close();
		}
		ptmt.close();
		conn.commit();
		conn.setAutoCommit(true);
		out.println("데이터를 저장했습니다.");
		
		rs.close();
		ptmt.close();
		conn.close();
		
	}catch(Exception e){
		out.println("데이터를 저장했습니다." + e.getMessage());
		e.printStackTrace();
	}
	
%>