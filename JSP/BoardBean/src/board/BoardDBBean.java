package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDBBean {
	private static BoardDBBean instance = new BoardDBBean();
	
	public static BoardDBBean getInstance() {
		return instance;
	}
	
	private BoardDBBean() {}
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/OracleDB");
		return ds.getConnection();
	}
	
	private void close(ResultSet rs, PreparedStatement ptmt, Connection conn) {
		if(rs!=null) try{rs.close();}catch(SQLException ex) {}
		if(ptmt!=null) try{ptmt.close();}catch(SQLException ex) {}
		if(conn!=null) try{conn.close();}catch(SQLException ex) {}
	}
	
	public BoardDataBean getArticle(int num, int check) throws Exception{
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		BoardDataBean article = null;
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement("select * from board where num=?");
			ptmt.setInt(1, num);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				article = new BoardDataBean();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setPasswd(rs.getString("passwd"));
				article.setSubject(rs.getString("subject"));
				article.setEmail(rs.getString("email"));
				article.setContent(rs.getString("content"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				if(check == 0 ) {
					article.setReadcount(rs.getInt("readcount")+1);
					ptmt = conn.prepareStatement("update board set readcount = ? where num=?");
					ptmt.setInt(1, rs.getInt("readcount")+1);
					ptmt.setInt(2, num);
					ptmt.executeUpdate();
				}else {
					article.setReadcount(rs.getInt("readcount"));
				}
			}
		}catch(Exception e) {
			System.out.println("글 상세보기 출력 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs, ptmt, conn);
		}
		return article;	
	}
	
	public int getArticleCount() throws Exception {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			conn = getConnection();
			String sql = "select count(*) from board";
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			if(rs.next())			
				count = rs.getInt(1);
			
		}catch(Exception e) {
			System.out.println("글 갯수 불러오기 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs, ptmt, conn);
		}
		return count;
	}
	
	public ArrayList<BoardDataBean> getArticles(int start, int end) throws Exception{
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		ArrayList<BoardDataBean> articleList = null;
		String sql = null;
		
		try {
			conn = getConnection();
			
			sql = "select * from (select rownum rnum, num, writer, passwd, subject, email, content, reg_date, "
					+ "readcount, ref, re_step, re_level from (select * from board order by ref desc, re_step asc)) "
					+ "where rnum>=? and rnum<=?";
			
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, start);
			ptmt.setInt(2, end);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<BoardDataBean>();
				
				do {
					BoardDataBean article = new BoardDataBean();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setPasswd(rs.getString("passwd"));
					article.setSubject(rs.getString("subject"));
					article.setEmail(rs.getString("email"));
					article.setContent(rs.getString("content"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));
					
					articleList.add(article);
				}while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("글 리스트 출력 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs, ptmt, conn);
		}
		return articleList;
	}
	
	public void insertArticle(BoardDataBean article) throws Exception{
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		int number = 0;
		String sql = "";
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement("select max(num) from board");
			rs = ptmt.executeQuery();
			
			if(rs.next())
				number = rs.getInt(1)+1;
			else 
				number=1;
			
			rs.close();
			ptmt.close();
			
			if(num != 0) {
				sql = "update board set re_step=re_step+1 where ref=? and re_step > ?";
				ptmt = conn.prepareStatement(sql);
				ptmt.setInt(1, ref);
				ptmt.setInt(2, re_step);
				ptmt.executeUpdate();
				re_step = re_step + 1;
				re_level = re_level + 1;
			}else {
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			ptmt.close();
			
			sql = "insert into board(num, writer, passwd, subject, email, content, reg_date,"
					+ "readcount, ref, re_step, re_level) values(board_seq.nextval, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?)";
			
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, article.getWriter());
			ptmt.setString(2, article.getPasswd());
			ptmt.setString(3, article.getSubject());
			ptmt.setString(4, article.getEmail());
			ptmt.setString(5, article.getContent());
			//ptmt.setTimestamp(6, article.getReg_date());
			ptmt.setInt(6, article.getReadcount());
			ptmt.setInt(7, ref);
			ptmt.setInt(8, re_step);
			ptmt.setInt(9, re_level);
			ptmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("글쓰기 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs, ptmt, conn);
		}
	}
	
	public int passwdCheck(int num, String passwd) throws Exception{
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int check = -1;
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement("select passwd from board where num =?");
			ptmt.setInt(1, num);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				if(passwd.equals(rs.getString("passwd"))) {
					check=1;
				}else {
					check=0;
				}
			}
			
		} catch (Exception e) {
			System.out.println("비밀번호 체크 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs, ptmt, conn);
		}
		return check;
	}
	
	public void deleteArticle(int num) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement("delete from board where num =?");
			ptmt.setInt(1, num);
			ptmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("글 삭제 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			if(ptmt != null)try {ptmt.close();}catch(SQLException sqle) {}
			if(conn != null)try {conn.close();}catch(SQLException sqle) {}
		}
	}
	
	public int updateArticle(BoardDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement ptmt = null;
		int result =0;
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement("update board set subject =?, email=?, content=?, passwd=? where num =?");
			ptmt.setString(1, article.getSubject());
			ptmt.setString(2, article.getEmail());
			ptmt.setString(3, article.getContent());
			ptmt.setString(4, article.getPasswd());
			ptmt.setInt(5, article.getNum());
			result = ptmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("글 수정 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			if(ptmt != null)try {ptmt.close();}catch(SQLException sqle) {}
			if(conn != null)try {conn.close();}catch(SQLException sqle) {}
		}
		return result;
	}
	
	public int updatePassArticle(BoardDataBean article) throws Exception{
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql ="";
		String dbpasswd = "";
		int check =-1;
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement("select passwd from board where num=?");
			ptmt.setInt(1, article.getNum());
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				dbpasswd = rs.getString("passwd");
				if(article.getPasswd().equals(dbpasswd)) {
					sql = "update board set writer=?, passwd=?, subject=?, email=?, content=? where num=?";
					
					ptmt = conn.prepareStatement(sql);
					ptmt.setString(1, article.getWriter());
					ptmt.setString(2, article.getPasswd());
					ptmt.setString(3, article.getSubject());
					ptmt.setString(4, article.getEmail());
					ptmt.setString(5, article.getContent());
					ptmt.setInt(6, article.getNum());
					ptmt.executeUpdate();
					check=1;
				}else {
					check=0;
				}
			}
			
		} catch (Exception e) {
			System.out.println("글 수정 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs, ptmt, conn);
		}
		return check;
	}

}
