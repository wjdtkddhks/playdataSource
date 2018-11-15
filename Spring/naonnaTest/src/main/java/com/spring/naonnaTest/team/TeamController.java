package com.spring.naonnaTest.team;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.naonnaTest.message.MessageService;
import com.spring.naonnaTest.user.UserService;

@Controller
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(value = "/getTeamlistJSON.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody			
	public String TeamlistJSONGET(TeamVO teamvo ) {
		ArrayList<TeamVO> list = teamService.getTeamlistJson(teamvo);
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
	
	@RequestMapping(value = "/getTeamfindJSON.do",  method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody		 	
	public String TeamfindJSONGET(TeamVO teamvo) {
		ArrayList<TeamVO> list = teamService.getTeamfindson(teamvo);
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

	@RequestMapping(value = "/insertTeam.do",  method = RequestMethod.POST)
	public ModelAndView Insert_Team_Info(TeamVO teamvo , MultipartHttpServletRequest multiRequest) throws Exception {
		
		 MultipartFile mf = multiRequest.getFile("emblem2");
		 
		 String uploadPath = "C:\\BigDeep\\upload\\";
	      
	      String originalFileExtension = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
	      String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
	      System.out.println("storedFileName : " + storedFileName);
	    
	      if(mf.getSize() != 0) {	         
	    	  mf.transferTo(new File(uploadPath + storedFileName));
	      }
	      
	      
	      teamvo.setEmblem(storedFileName);

		System.out.println("emblem in ?");
		
		teamService.insertTeam(teamvo);
				
		ModelAndView result = new ModelAndView();
		result.addObject("teamvo", teamvo);
		result.setViewName("team_search");
		System.out.println("추가 complete??");
		return result; 
	}
	
	@RequestMapping(value = "/team_detail.do", method =RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ModelAndView That_Team_Info(TeamVO vo, String team_name) {
		String Team_Name = vo.getTeam_name();
		System.out.println("Team_Name = " + Team_Name);
		vo = teamService.That_Team_Info(Team_Name);
		System.out.println("team_detail complete");

		ModelAndView result = new ModelAndView();
		result.addObject("vo", vo);
		result.setViewName("team_detail");
		System.out.println("불러오기  complete??");
		return result;
	}
	
	@RequestMapping(value = "/teamOnMatch.do",  method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody		 	
	public String teamOnMatch(String team_name) {
		TeamVO vo = teamService.atMatchDetail(team_name);
		String str = "";
		ObjectMapper mapper = new ObjectMapper();

		try {
			str = mapper.writeValueAsString(vo);
			System.out.println("str=" + str);
		}
		catch (Exception e){
			System.out.println("first() mapper : " + e.getMessage());
		}
		
		return str;
	}
	
	@RequestMapping(value = "/printTeamMember.do",  method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody		 	
	public String memberPrint(String team_name) {
		System.out.println("team_name = " + team_name);
		ArrayList<TeamMemberVO> list = teamService.memberPrint(team_name);
		String str = "";
		ObjectMapper mapper = new ObjectMapper();

		try {
			str = mapper.writeValueAsString(list);
			System.out.println("print team member str=" + str);
		}
		catch (Exception e){
			System.out.println("first() mapper : " + e.getMessage());
		}
		
		return str;
	}
	
	@RequestMapping(value = "/joinTeamMema.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody		 	
	public int memberInsert(TeamVO vo , HttpSession session) {
		System.out.println("nickname");
		System.out.println("nickname :" + vo.getNickname());
		System.out.println("team_name :" + vo.getTeam_name());
		int i =0;
		try {
			
			teamService.insertMember(vo);
		
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("nickname", vo.getNickname());
			map.put("team_name", vo.getTeam_name());
			teamService.updateTeam(map);
			session.setAttribute("teamName", vo.getTeam_name());
			System.out.println("session teamName :" + session.getAttribute("teamName"));
			i =1;
			
			HashMap<String, Object> map2 = new HashMap<String, Object>();
			map2.put("getpeople", vo.getNickname());
			map2.put("team_name", vo.getTeam_name());
			//messageService.reMessage(map2);
			
		}
		catch (Exception e){
			System.out.println("first() mapper : " + e.getMessage());
		}
		
		return i;
	}
	
	@RequestMapping(value = "/teambroke.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int teamout(String nickname , String hometeam) {
		System.out.println("nickname: " + nickname );
		
		int i = 0;
		try {
			   userService.goWithdrawTeam(nickname);
			i =teamService.teamCut(nickname , hometeam);
			return i;	
			
		}
		catch(Exception e) {
			System.out.println("first() mapper : " + e.getMessage());
		}
		
		return i;
	}
	
	
	
}
