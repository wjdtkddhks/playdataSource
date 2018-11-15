package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.BoardDAO;
import vo.BoardBean;

public class BoardDetailService {

	public BoardBean getArticle(int board_num) throws Exception{
		
		BoardBean article = null;
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		int updateCount = boardDAO.updateReadCount(board_num);
		
		if(updateCount > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		article = boardDAO.selectArticle(board_num);
		close(conn);
		
		return article;
	}
}
