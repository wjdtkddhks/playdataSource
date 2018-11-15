package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;

public class BoardWriteProService {

	public boolean registArticle(BoardBean boardBean) throws Exception {
		
		boolean isWriteSucess = false;
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		int insertCount = boardDAO.insertArticle(boardBean);
		
		if(insertCount > 0) {
			commit(conn);
			isWriteSucess = true;
		}else {
			rollback(conn);
		}
		close(conn);
		return isWriteSucess;
	}
}
