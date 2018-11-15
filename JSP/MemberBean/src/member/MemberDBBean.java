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

	public ArrayList<MemberDataBean> getMemberList() {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		ArrayList<MemberDataBean> member_list = null;
		String sql = "select * from member";

		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();

			if(rs.next()) {
				member_list = new ArrayList<MemberDataBean>();
				do {
				MemberDataBean obj = new MemberDataBean();
				obj.setId(rs.getString("id"));
				obj.setPassword(rs.getString("password"));
				obj.setName(rs.getString("name"));
				obj.setAge(rs.getInt("age"));
				obj.setGender(rs.getString("gender"));
				obj.setEmail(rs.getString("email"));
				member_list.add(obj);
				}while(rs.next());
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

	public int userCheck(String id, String password) throws Exception {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id =?";
		int result = 0;

		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery();

			if (rs.next()) {
				if (password.equals(rs.getString("password"))) {
					result = 0;
				} else {
					result = 1;
				}
			} else {
				result = -1;
			}

		} catch (Exception e) {
			System.out.println("유저 체크 오류!!!" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
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

	public int deleteMember(String id) throws Exception{
		Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "delete from member where id =?";
		int result = 0;

		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("유저 삭제 오류!!!" + e.getMessage());
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

	public MemberDataBean getMember(String id) throws Exception {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		MemberDataBean obj = null;
		String sql = "select * from member where id = ?";

		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery();
			rs.next();
			
			obj = new MemberDataBean();
			obj.setId(rs.getString("id"));
			obj.setPassword(rs.getString("password"));
			obj.setName(rs.getString("name"));
			obj.setAge(rs.getInt("age"));
			obj.setGender(rs.getString("gender"));
			obj.setEmail(rs.getString("email"));

		} catch (Exception e) {
			System.out.println("유저 정보 출력 오류!!!" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
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
		return obj;
	}
	
	public int updateMember(MemberDataBean obj) throws Exception{
		Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "update member set password=?, name=?, age=?, gender=?, email=? where id=?";
		int result = 0;
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, obj.getPassword());
			ptmt.setString(2, obj.getName());
			ptmt.setInt(3, obj.getAge());
			ptmt.setString(4, obj.getGender());
			ptmt.setString(5, obj.getEmail());
			ptmt.setString(6, obj.getId());
			result = ptmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("유저 삭제 오류!!!" + e.getMessage());
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

}
