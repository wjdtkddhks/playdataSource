package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ArticleDB {
	private static ArticleDB instance = new ArticleDB();
	
	public static ArticleDB getInstance() {
		return instance;
	}
	
	private ArticleDB() {}
	
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		return ds.getConnection();
	}
	
	private void close(ResultSet rs, PreparedStatement ptmt, Connection conn) {
		if(rs != null)try{rs.close();}catch(SQLException e){e.printStackTrace();}
		if(ptmt != null)try{ptmt.close();}catch(SQLException e){e.printStackTrace();}
		if(conn != null)try{conn.close();}catch(SQLException e){e.printStackTrace();}
	}
	
	private void close(PreparedStatement ptmt, Connection conn) {
		if(ptmt != null)try{ptmt.close();}catch(SQLException e){e.printStackTrace();}
		if(conn != null)try{conn.close();}catch(SQLException e){e.printStackTrace();}
	}
	
	public int countArticle() throws Exception{
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement("select count(*) from forestbd");
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("글 갯수 출력 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs, ptmt, conn);
		}
		return count;
	}
	
	public ArrayList<ArticleData> getArticles(int start, int end){
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		ArrayList<ArticleData> articlelist = null;
		ArticleData article = null;
		
		try {
			String sql ="select * from (select rownum rnum, num, subject, writer, email, passwd,"
					+ "grade, content, readcount, ref_date, ref, ref_step, ref_level from (select * from forestbd order by ref desc, ref_step asc))"
					+ "where rnum >=? and rnum <= ?";
			
			conn = getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, start);
			ptmt.setInt(2, end);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				articlelist = new ArrayList<ArticleData>();
				do {
					article = new ArticleData();
					article.setNum(rs.getInt("num"));
					article.setSubject(rs.getString("subject"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setPasswd(rs.getString("passwd"));
					article.setGrade(rs.getString("grade"));
					article.setContent(rs.getString("content"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef_date(rs.getTimestamp("ref_date"));
					article.setRef(rs.getInt("ref"));
					article.setRef_level(rs.getInt("ref_level"));
					article.setRef_step(rs.getInt("ref_step"));
					
					articlelist.add(article);
				}while(rs.next());
			}
			
		} catch (Exception e) {
			System.out.println("게시글 불러오기 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs, ptmt, conn);
		}
		return articlelist;
	}
	
	public int insertArticle(ArticleData article) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int check = 0;
		
		int num = article.getNum();
		int ref = article.getRef();
		int ref_step = article.getRef_step();
		int ref_level = article.getRef_level();
		
		try {
			conn = getConnection();
			
			ptmt = conn.prepareStatement("select max(num) from forestbd");
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				num= rs.getInt(1)+1;
			}else {
				num=1;
			}
			
			if(ref !=0) {
				ptmt= conn.prepareStatement("update forestbd set ref_step = ref_step+1 where ref=? and ref_step>?");
				ptmt.setInt(1, ref);
				ptmt.setInt(2, ref_step);
				ptmt.executeUpdate();
				
				ref_step += 1;
				ref_level += 1;
			}else {
				ref=num;
			}
			
			ptmt = conn.prepareStatement("insert into forestbd values(?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?)");
			ptmt.setInt(1, num);
			ptmt.setString(2, article.getWriter());
			ptmt.setString(3, article.getPasswd());
			ptmt.setString(4, article.getSubject());
			ptmt.setString(5, article.getEmail());
			ptmt.setString(6, article.getGrade());
			ptmt.setString(7, article.getContent());
			ptmt.setInt(8, article.getReadcount());
			ptmt.setInt(9, ref);
			ptmt.setInt(10, ref_step);
			ptmt.setInt(11, ref_level);
			check = ptmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("게시글 삽입 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs, ptmt, conn);
		}
		return check;
	}
	
	public ArticleData getArticle(int num, int check) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		ArticleData article = null;
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement("select * from forestbd where num =?");
			ptmt.setInt(1, num);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				article = new ArticleData();
				article.setNum(rs.getInt("num"));
				article.setSubject(rs.getString("subject"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setPasswd(rs.getString("passwd"));
				article.setGrade(rs.getString("grade"));
				article.setContent(rs.getString("content"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef_date(rs.getTimestamp("ref_date"));
				article.setRef(rs.getInt("ref"));
				article.setRef_level(rs.getInt("ref_level"));
				article.setRef_step(rs.getInt("ref_step"));
				
				if(check == 0) {
				ptmt = conn.prepareStatement("update forestbd set readcount = readcount+1 where num=?");
				ptmt.setInt(1, num);
				ptmt.executeUpdate();
				article.setReadcount(rs.getInt("readcount")+1);
				}
			}
			
		} catch (Exception e) {
			System.out.println("해당글 출력 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs, ptmt, conn);
		}
		return article;
	}
	
	public int deleteArticle(int num, String passwd) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int check = 0;
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement("select passwd from forestbd where num = ?");
			ptmt.setInt(1, num);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				String dbpass = rs.getString("passwd");
				if(dbpass.equals(passwd)) {
					ptmt = conn.prepareStatement("delete from forestbd where num = ?");
					ptmt.setInt(1, num);
					check = ptmt.executeUpdate();
				}
			}
			
		} catch (Exception e) {
			System.out.println("해당글 삭제 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs, ptmt, conn);
		}
		return check;
	}
	
	public int updateArticle(ArticleData article) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		int check = 0;
		
		try {
			conn = getConnection();
			ptmt = conn.prepareStatement("update forestbd set content=?, email=?, grade=?, subject=? where num=?");
			ptmt.setString(1, article.getContent());
			ptmt.setString(2, article.getEmail());
			ptmt.setString(3, article.getGrade());
			ptmt.setString(4, article.getSubject());
			ptmt.setInt(5, article.getNum());
			check = ptmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("해당글 수정 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(ptmt, conn);
		}
		return check;
	}
}
