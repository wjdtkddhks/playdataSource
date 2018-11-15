package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import static db.JdbcUtil.*;
import vo.BoardBean;

public class BoardDAO {
	
	DataSource ds;
	Connection conn;
	private static BoardDAO boardDAO;
	
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		try {
			ptmt = conn.prepareStatement("select count(*) from board");
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("selectListCount 에러 : " + e.getMessage());
		}finally {
			close(rs);
			close(ptmt);
		}
		return listCount;
	}
	
	public ArrayList<BoardBean> selectArticleList(int page, int limit){
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		String board_list_sql = "select * from (select rownum rnum, board_num, board_name, board_subject, " + 
				"board_content, board_file, board_re_ref, board_re_lev, board_re_seq, board_readcount," + 
				"board_date from (select * from board order by board_re_ref desc, board_re_seq asc)) where rnum>=? and rnum<=?";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startrow = (page-1)*limit+1;
		int endrow = startrow+limit-1;
		
		try {
			ptmt = conn.prepareStatement(board_list_sql);
			ptmt.setInt(1, startrow);
			ptmt.setInt(2, endrow);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardBean();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_date(rs.getDate("board_date"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				articleList.add(board);
			}
		} catch (Exception e) {
			System.out.println("selectArticleList 에러 : " + e.getMessage());
		}finally {
			close(rs);
			close(ptmt);
		}
		return articleList;
	}
	
	public BoardBean selectArticle(int board_num) {
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		BoardBean board = null;
		
		try {
			ptmt = conn.prepareStatement("select * from board where board_num = ?");
			ptmt.setInt(1, board_num);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardBean();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_date(rs.getDate("board_date"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
			}
		}  catch (Exception e) {
			System.out.println("selectArticle 에러 : " + e.getMessage());
		}finally {
			close(rs);
			close(ptmt);
		}
		return board;
	}
	
	public int insertArticle(BoardBean article) {
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;
		
		try {
			ptmt = conn.prepareStatement("select max(board_num) from board");
			rs = ptmt.executeQuery();
			
			if(rs.next())
				num = rs.getInt(1)+1;
			else
				num = 1;
			
			sql = "insert into board(board_num, board_name, board_pass, board_subject,"
					+ "board_content, board_file, board_re_ref, board_re_lev, board_re_seq, board_readcount,"
					+ "board_date) values(?,?,?,?,?,?,?,?,?,?,sysdate)";
			
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, num);
			ptmt.setString(2, article.getBoard_name());
			ptmt.setString(3, article.getBoard_pass());
			ptmt.setString(4, article.getBoard_subject());
			ptmt.setString(5, article.getBoard_content());
			ptmt.setString(6, article.getBoard_file());
			ptmt.setInt(7, num);
			ptmt.setInt(8, 0);
			ptmt.setInt(9, 0);
			ptmt.setInt(10, 0);
			insertCount = ptmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertArticle 에러 : " + e.getMessage());
		}finally {
			close(rs);
			close(ptmt);
		}
		return insertCount;
	}
	
	public int insertReplyArticle(BoardBean article) {
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String board_max_sql = "select max(board_num) from board";
		String sql = "";
		int num = 0;
		int insertCount = 0;
		int re_ref = article.getBoard_re_ref();
		int re_lev = article.getBoard_re_lev();
		int re_seq = article.getBoard_re_seq();
		
		try {
			ptmt = conn.prepareStatement(board_max_sql);
			rs = ptmt.executeQuery();
			
			if(rs.next()) 
				num = rs.getInt(1)+1;
			else
				num = 1;
			
			sql = "update board set board_re_seq=board_re_seq +1 where board_re_ref=? and board_re_seq >?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, re_ref);
			ptmt.setInt(2, re_seq);
			int updateCount = ptmt.executeUpdate();
			
			if(updateCount > 0) {
				commit(conn);
			}
			
			re_seq += 1;
			re_lev += 1;
			sql = "insert into board(board_num, board_name, board_pass, board_subject,"
					+ "board_content, board_file, board_re_ref, board_re_lev, board_re_seq, board_readcount,"
					+ "board_date) values(?,?,?,?,?,?,?,?,?,?,sysdate)";
			
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, num);
			ptmt.setString(2, article.getBoard_name());
			ptmt.setString(3, article.getBoard_pass());
			ptmt.setString(4, article.getBoard_subject());
			ptmt.setString(5, article.getBoard_content());
			ptmt.setString(6, "");
			ptmt.setInt(7, re_ref);
			ptmt.setInt(8, re_lev);
			ptmt.setInt(9, re_seq);
			ptmt.setInt(10, 0);
			insertCount = ptmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insertReplyArticle 에러 : " + e.getMessage());
		}finally {
			close(rs);
			close(ptmt);
		}
		return insertCount;
	}
	
	public int updateArticle(BoardBean article) {
		int updateCount = 0;
		PreparedStatement ptmt = null;
		String sql = "update board set board_subject=?, board_content=? where board_num =?";
		
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, article.getBoard_subject());
			ptmt.setString(2, article.getBoard_content());
			ptmt.setInt(3, article.getBoard_num());
			updateCount = ptmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("updateArticle 에러 : " + e.getMessage());
		}finally {
			close(ptmt);
		}
		return updateCount;
	}
	
	public int deleteArticle(int board_num) {
		PreparedStatement ptmt = null;
		String sql = "delete from board where board_num =?";
		int deleteCount = 0;
		
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, board_num);
			deleteCount = ptmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("deleteArticle 에러 : " + e.getMessage());
		}finally {
			close(ptmt);
		}
		return deleteCount;
	}
	
	public int updateReadCount(int board_num) {
		PreparedStatement ptmt = null;
		int updateCount = 0;
		String sql = "update board set board_readcount = board_readcount+1 where board_num =?";
		
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, board_num);
			updateCount = ptmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("updateReadCount 에러 : " + e.getMessage());
		}finally {
			close(ptmt);
		}
		return updateCount;
	}
	
	public boolean isArticleBoardWriter(int board_num, String pass) {
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String board_sql = "select * from board where board_num =?";
		boolean isWriter = false;
		
		try {
			ptmt = conn.prepareStatement(board_sql);
			ptmt.setInt(1, board_num);
			rs = ptmt.executeQuery();
			rs.next();
			
			if(pass.equals(rs.getString("board_pass"))) {
				isWriter = true;
			}
		} catch (Exception e) {
			System.out.println("isArticleBoardWriter 에러 : " + e.getMessage());
		}finally {
			close(ptmt);
		}
		return isWriter;
	}
	
}
