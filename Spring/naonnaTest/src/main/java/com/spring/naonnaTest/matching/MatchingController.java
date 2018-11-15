package com.spring.naonnaTest.matching;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MatchingController {

	@Autowired
	private MatchingService matchingService;
	
	@RequestMapping(value = "/print_matching.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody			//자바 객체를 http 객체에 담아 저장하고 싶을때
	public String MatchingGET() {

		ArrayList<MatchingVO> list = matchingService.getMatching();
		String str = "";
		ObjectMapper mapper = new ObjectMapper();
	
		try {
			str = mapper.writeValueAsString(list);
			System.out.println("str=" + str);
		}
		catch (Exception e){
			System.out.println("first() mapper : " + e.getMessage());
		}
		
		return str;
	}
	
	
	@RequestMapping(value = "/searchMatching.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody			//자바 객체를 http 객체에 담아 저장하고 싶을때
	public String MatchingSearchGET(MatchingVO vo) {
		System.out.println(vo.getMatchLocation());
		System.out.println(vo.getPlayDate());
		ArrayList<MatchingVO> list = matchingService.getMatchingSearch(vo);
		String str = "";
		ObjectMapper mapper = new ObjectMapper();

		try {
			str = mapper.writeValueAsString(list);
			System.out.println("str=" + str);
		}
		catch (Exception e){
			System.out.println("first() mapper : " + e.getMessage());
		}
		
		return str;
	}
	
	@RequestMapping(value = "/printPlayer.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody			//자바 객체를 http 객체에 담아 저장하고 싶을때
	public String printPlayer(String matchingID) {
		System.out.println(matchingID);
		
		ArrayList<PlayerVO> list = matchingService.playerPrint(matchingID);
		String str = "";
		ObjectMapper mapper = new ObjectMapper();

		try {
			str = mapper.writeValueAsString(list);
			System.out.println("str=" + str);
		}
		catch (Exception e){
			System.out.println("first() mapper : " + e.getMessage());
		}
		
		return str;
	}
	
	@RequestMapping(value = "/makeMatch.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ModelAndView makeMatch(MatchingVO vo) {
		matchingService.makeMatching(vo);
		ModelAndView mnv = new ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println(vo.getPeople());
		System.out.println(vo.getHomeTeam());
		System.out.println(vo.getPlayDate());
		System.out.println(vo.getMatchingID());
		System.out.println(vo.getMatchLocation());
		
		try {
			mnv.addObject("matchingVO", vo);
			mnv.setViewName("matching_search");

		}
		catch (Exception e){
			System.out.println("first() mapper : " + e.getMessage());
		}
	
		return mnv;
	}
	
	@RequestMapping(value = "/go_matchingDetail.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
	public ModelAndView go_MatchDetail(String matchingID) {
		ModelAndView mnv = new ModelAndView();
		MatchingVO vo = matchingService.matchDetail(matchingID);
		
		try {
			System.out.println("vo.getMatchLocation() = " + vo.getMatchLocation());
			System.out.println("vo.getHomeTeam() = " + vo.getHomeTeam());
			System.out.println("vo.getPlayDate() = " + vo.getPlayDate());
			System.out.println("vo.getMatchingID() = " + vo.getMatchingID());
			System.out.println(vo.getPlayDate());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			String playDate = sdf.format(vo.getPlayDate());
			mnv.addObject("homeTeam", vo.getHomeTeam());
			mnv.addObject("matchingID", vo.getMatchingID());
			mnv.addObject("people", vo.getPeople());
			mnv.addObject("playDate", playDate);
			mnv.addObject("matchLocation", vo.getMatchLocation());
			mnv.addObject("matFin", vo.getMatFin());
			mnv.setViewName("matching_detail");
		}
		catch (Exception e){
			System.out.println("first() mapper : " + e.getMessage());
		}
	
		return mnv;
	}
	
	@RequestMapping(value = "/matching_detail.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String PrintUserCont(String matchingID, HttpServletRequest request) {
		MatchingVO vo = matchingService.matchDetail(matchingID);
		String str = "";
		ObjectMapper mapper = new ObjectMapper();

		try {
			str = mapper.writeValueAsString(vo);
			System.out.println("vo.getHomeTeam() = " + vo.getHomeTeam());
			request.setAttribute("homeTeam", vo.getHomeTeam());
			System.out.println("str=" + str);
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
			System.out.println("first() mapper : " + e.getMessage());
			
		}

		return str;
	}
	
	@RequestMapping(value = "/matchFinish.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int PrintUserCont(String matchingID) {
		try {
			matchingService.finishMatch(matchingID);
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		return 1;
	}
	
	@RequestMapping(value = "/confirmPlayer.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int confirmPlayer(PlayerVO playerVO) {
		try {
			matchingService.addPlayer(playerVO);
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		return 1;
	}
	
	@RequestMapping(value = "/matchdelete.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void matchingcancel (String matchingID) {
		try {
			matchingService.delteMatch(matchingID);
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	
}
