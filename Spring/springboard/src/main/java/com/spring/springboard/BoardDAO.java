package com.spring.springboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	private Connection con = null;
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT = 
			"insert into sboard(seq, title, writer, content, regdate, cnt) values((select"
			+ " nvl(max(seq), 0)+1 from sboard), ?, ?, ?, sysdate, 0)";
	
	private final String BOARD_UPDATE = "update sboard set title=?, content=? where seq=?";
	private final String BOARD_UPDATE2 = "update sboard set cnt=cnt+1 where seq=?";
	private final String BOARD_DELETE = "delete from sboard where seq=?";
	private final String BOARD_SELECT = "select * from sboard order by seq desc";
	private final String BOARD_SEARCH = "select * from sboard where seq=?";
	
	public void addBoard(BoardVO boardVO) {
		try {
			con = JDBCUtil.getConnection();
			ptmt = con.prepareStatement(BOARD_INSERT);
			ptmt.setString(1, boardVO.getTitle());
			ptmt.setString(2, boardVO.getWriter());
			ptmt.setString(3, boardVO.getContent());
			ptmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("addBoard() 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(ptmt, con);
		}
	}
	
	public void updateBoard(BoardVO boardVO) {
		try {
			con = JDBCUtil.getConnection();
			ptmt = con.prepareStatement(BOARD_UPDATE);
			ptmt.setString(1, boardVO.getTitle());
			ptmt.setString(2, boardVO.getContent());
			ptmt.setInt(3, boardVO.getSeq());
			ptmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateBoard() 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(ptmt, con);
		}
	}
	
	public void deleteBoard(BoardVO boardVO) {
		try {
			con = JDBCUtil.getConnection();
			ptmt = con.prepareStatement(BOARD_DELETE);
			ptmt.setInt(1, boardVO.getSeq());
			ptmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteBoard() 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(ptmt, con);
		}
	}
	
	public BoardVO getBoard(BoardVO boardVO) {
		BoardVO vo = null;
		try {
			con = JDBCUtil.getConnection();
			ptmt = con.prepareStatement(BOARD_UPDATE2);
			ptmt.setInt(1, boardVO.getSeq());
			ptmt.executeUpdate();
			
			ptmt = con.prepareStatement(BOARD_SEARCH);
			ptmt.setInt(1, boardVO.getSeq());
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
			}
		} catch (Exception e) {
			System.out.println("getBoard() 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(rs, ptmt, con);
		}
		return vo;
	}
	
	public ArrayList<BoardVO> getBoardList() {
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		BoardVO vo = null;
		try {
			con = JDBCUtil.getConnection();
			ptmt = con.prepareStatement(BOARD_SELECT);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				boardList.add(vo);
			}
		} catch (Exception e) {
			System.out.println("getBoardList() 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(rs, ptmt, con);
		}
		return boardList;
	}
	
}
