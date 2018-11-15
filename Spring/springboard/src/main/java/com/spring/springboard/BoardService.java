package com.spring.springboard;

import java.util.ArrayList;

public interface BoardService {
	public void addBoard(BoardVO boardVO) throws Exception;
	public void updateBoard(BoardVO boardVO) throws Exception;
	public void deleteBoard(BoardVO boardVO) throws Exception;
	public BoardVO getBoard(BoardVO boardVO) throws Exception;
	public ArrayList<BoardVO> getBoardList() throws Exception;

}
