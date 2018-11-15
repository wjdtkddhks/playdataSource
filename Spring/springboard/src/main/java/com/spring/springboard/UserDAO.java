package com.spring.springboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	private Connection con = null;
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;
	
	private final String USER_SEARCH = "select * from users where id=? and password=?";
	
	public UserVO login(UserVO userVO) {
		UserVO vo = null;
		try {
			con = JDBCUtil.getConnection();
			ptmt = con.prepareStatement(USER_SEARCH);
			ptmt.setString(1, userVO.getId());
			ptmt.setString(2, userVO.getPassword());
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setRole(rs.getString("role"));
			}
			
		} catch (Exception e) {
			System.out.println("login() ¿À·ù" + e.getMessage());
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(rs, ptmt, con);
		}
		return vo;
	}
}
