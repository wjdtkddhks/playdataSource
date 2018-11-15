package com.spring.springboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "hr", "123456");
			} catch (ClassNotFoundException ce) {
				System.out.println("데이터베이스 연결 문제" + ce.getMessage());
				ce.printStackTrace();
			} catch (SQLException se) {
				System.out.println("데이터베이스 연결 문제" + se.getMessage());
				se.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 문제" + e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeResource(Statement stmt, Connection con) {
		try {	if(stmt != null) stmt.close(); } catch(Exception e) {stmt = null;}
		try {if(con != null) con.close(); } catch(Exception e) {con = null;}
	}
	
	public static void closeResource(ResultSet rs, Statement stmt, Connection con) {
		try {	if(rs != null) rs.close(); } catch(Exception e) {rs = null;}
		try {	if(stmt != null) stmt.close(); } catch(Exception e) {stmt = null;}
		try {if(con != null) con.close(); } catch(Exception e) {con = null;}
	}

}
