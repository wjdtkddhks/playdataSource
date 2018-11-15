package com.spring.booktest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class MySQLConnectionTest {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	//mysql driver 6.0 >> "com.mysql.cj.jdbc.Driver"
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/book_ex?useSSL=false";
	//mysql 6.1 >> "jdbc:mysql://127.0.0.1:3306/book_ex?useSSL=false&serverTimezone=Asia/Seoul"
	
	private static final String USER = "zerosw";
	
	private static final String PW = "123456";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
