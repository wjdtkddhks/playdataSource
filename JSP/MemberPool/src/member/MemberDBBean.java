package member;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDBBean {
	private static MemberDBBean instance = new MemberDBBean();

	public static MemberDBBean getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/OracleDB");
		return ds.getConnection();
	}

	public int insertMember(MemberDataBean obj) throws Exception {
		Connection conn = null;
		PreparedStatement ptmt = null;
		int result = 0;

		try {
			conn = getConnection();
			ptmt = conn.prepareStatement("insert into member values(?,?,?,?,?,?)");
			ptmt.setString(1, obj.getId());
			ptmt.setString(2, obj.getPassword());
			ptmt.setString(3, obj.getName());
			ptmt.setInt(4, obj.getAge());
			ptmt.setString(5, obj.getGender());
			ptmt.setString(6, obj.getEmail());
			result = ptmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("가입 오류" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (ptmt != null)
				try {
					ptmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return result;
	}
	
	public ArrayList<MemberDataBean> getMemberList(){
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		ArrayList<MemberDataBean> member_list = null;
		String sql = "select * from member";
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				MemberDataBean obj = new MemberDataBean();
				obj.setId(rs.getString("id"));
				obj.setPassword(rs.getString("password"));
				obj.setName(rs.getString("name"));
				obj.setAge(rs.getInt("age"));
				obj.setGender(rs.getString("gender"));
				obj.setEmail(rs.getString("email"));
				member_list.add(obj);
			}
		} catch (Exception e) {
			System.out.println("가입 오류" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (ptmt != null)
				try {
					ptmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return member_list;
	}

}
