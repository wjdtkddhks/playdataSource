package com.spring.springboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board.do")
public class BoardController {
	
	@Autowired
	private BoardService boardService = null;
	
	@RequestMapping(params="method=addBoardForm")
	public String addBoardForm() throws Exception{
		return "addBoardForm";
	}
	
	@RequestMapping(params="method=addBoard")
	public String addBoard(BoardVO boardVO) throws Exception{
		boardService.addBoard(boardVO);
		return "redirect:/board.do?method=getBoardList";
	}
	
	@RequestMapping(params="method=updateBoard")
	public String updateBoard(BoardVO boardVO) throws Exception{
		boardService.updateBoard(boardVO);
		return "redirect:/board.do?method=getBoardList";
	}
	
	@RequestMapping(params="method=updateBoardForm")
	public String updateBoardForm(BoardVO boardVO, Model model) throws Exception{
		BoardVO vo = boardService.getBoard(boardVO);
		model.addAttribute("boardVO", vo);
		return "updateboardform";
	}
	
	@RequestMapping(params="method=deleteBoard")
	public String deleteBoard(BoardVO boardVO) throws Exception{
		boardService.deleteBoard(boardVO);
		return "redirect:/board.do?method=getBoardList";
	}

	@RequestMapping(params="method=getBoard")
	public String getBoard(BoardVO boardVO, Model model) throws Exception{
		BoardVO vo = boardService.getBoard(boardVO);
		model.addAttribute("boardVO", vo);
		return "getboard";
	}
	
	@RequestMapping(params="method=getBoardList")
	public String getBoardList(Model model) throws Exception{
		ArrayList<BoardVO> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "getboardlist";
	}

}
