package com.spring.springboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired(required=false)
	private BoardDAO boardDAO= null;
	
	public void addBoard(BoardVO boardVO) throws Exception{
			try {
				boardDAO.addBoard(boardVO);
			} catch (Exception e) {
				throw new Exception("�Խ��� ��� ����", e);
			}
	}
	
	public void updateBoard(BoardVO boardVO) throws Exception{
		try {
			boardDAO.updateBoard(boardVO);
		} catch (Exception e) {
			throw new Exception("�Խ��� ���� ����", e);
		}
	}
	
	public void deleteBoard(BoardVO boardVO) throws Exception{
		try {
			boardDAO.deleteBoard(boardVO);
		} catch (Exception e) {
			throw new Exception("�Խ��� ���� ����", e);
		}
	}
	
	public BoardVO getBoard(BoardVO boardVO) throws Exception{
		try {
			return boardDAO.getBoard(boardVO);
		} catch (Exception e) {
			throw new Exception("�Խñ� ��ȸ ����", e);
		}
	}
	
	public ArrayList<BoardVO> getBoardList() throws Exception{
		try {
			return boardDAO.getBoardList();
		} catch (Exception e) {
			throw new Exception("�Խ��� ����Ʈ ��ȸ ����", e);
		}
	}
}
