package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BoardDAO;

public class BoardDeleteProService {
	
	public boolean isArticleWriter(int board_num, String pass) throws Exception{
		
		boolean isArticleWriter = false;
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
		close(conn);
		
		return isArticleWriter;
	}
	
	public boolean removeArticle(int board_num) throws Exception{
		
		boolean isRemoveSuccess = false;
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		int deleteCount = boardDAO.deleteArticle(board_num);
		
		if(deleteCount > 0) {
			commit(conn);
			isRemoveSuccess = true;
		}else {
			rollback(conn);
		}
		close(conn);
		
		return isRemoveSuccess;
	}
}
