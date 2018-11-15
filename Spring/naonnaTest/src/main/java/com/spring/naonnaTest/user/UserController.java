package com.spring.naonnaTest.user;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/distUserInfo.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ModelAndView go_UserDB(HttpServletRequest request, HttpSession session) {
		String forPerson = request.getParameter("kakao_Id");
		ModelAndView mnv = new ModelAndView();
		UserVO info = null;
		try {
			info = userService.distMember(forPerson);
			if (info == null) {
				mnv.setViewName("add_info");
				mnv.addObject("forPerson", forPerson);
				
			} else {
				mnv.setViewName("main");
				session.setAttribute("forPerson", forPerson);			
				 session.setAttribute("nickname", info.getNickname());
				
				if(info.getCap() == 1) {
					session.setAttribute("cap", info.getCap());
				}
				if(info.getTeamName() != null) {
					session.setAttribute("teamName", info.getTeamName());
				}
				
 				System.out.println(info.getNickname());
			}
		}

		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		return mnv;
	}

	@RequestMapping(value = "/myPage.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ModelAndView go_myPage(String nickname) {
		ModelAndView mnv = new ModelAndView();
		UserVO info = null;
		try {
			info = userService.goMyPage(nickname);
			mnv.setViewName("mypage");
			mnv.addObject("info", info);
		}

		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		return mnv;
	}

	@RequestMapping(value = "/update_userinfo.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ModelAndView update_userInfo(UserVO vo) throws Exception {
		ModelAndView mnv = new ModelAndView();
		UserVO info = null;
		System.out.println("vo.getNickname() = " + vo.getNickname());
		
		try {			
			userService.updateInfo(vo);
			mnv.setViewName("main");
		}

		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		return mnv;
	}
	
	@RequestMapping(value = "/update_profile.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ModelAndView update_profile(UserVO vo, MultipartHttpServletRequest multiRequest) throws Exception {
		ModelAndView mnv = new ModelAndView();

		MultipartFile mf = multiRequest.getFile("imgfile");
		String uploadPath = "C:\\BigDeep\\upload\\";
		String originalFileExtension = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
		String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		System.out.println("storedFileName : " + storedFileName);
		System.out.println("vo.getNickname() = " + vo.getNickname());
		try {
			if (mf.getSize() != 0) {
				mf.transferTo(new File(uploadPath + storedFileName));
				vo.setUserPhoto(storedFileName);
			}
			
			userService.updateProfile(vo);
			mnv.setViewName("main");
		}

		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		return mnv;
	}

	@RequestMapping(value = "/insertUserForm.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ModelAndView insert_Form(String forPerson, HttpSession session) {
		System.out.println(forPerson);
		ModelAndView mNv = new ModelAndView();
		mNv.setViewName("add_info");
		mNv.addObject("forPerson", forPerson);
		System.out.println(forPerson);
		return mNv;
	}

	@RequestMapping(value = "/insertUserInfo.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ModelAndView insert_User(UserVO vo, HttpSession session) {

		userService.insertUser(vo);
		ModelAndView mNv = new ModelAndView();
		mNv.setViewName("main");
		mNv.addObject("nickname", vo.getNickname());
		mNv.addObject("city", vo.getCity());
		mNv.addObject("email", vo.getEmail());
		mNv.addObject("forPerson", vo.getForPerson());
		mNv.addObject("age", vo.getAge());
		mNv.addObject("gender", vo.getGender());
		
		session.setAttribute("forPerson", vo.getForPerson());
		session.setAttribute("nickname", vo.getNickname());

		return mNv;
	}

	@RequestMapping(value = "/printUserInfo.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String PrintUserCont(String forPerson) {
		UserVO vo = userService.printUser(forPerson);
		String str = "";
		ObjectMapper mapper = new ObjectMapper();

		try {
			str = mapper.writeValueAsString(vo);
			System.out.println("str=" + str);
		} catch (Exception e) {
			System.out.println("first() mapper : " + e.getMessage());
		}

		return str;
	}

	
	@RequestMapping("nickcheck.do")
    @ResponseBody
    public Map<Object, Object> idcheck(@RequestBody String nickname) {
        System.out.println("String nickname :" + nickname);
        int count = 0;
        Map<Object, Object> map = new HashMap<Object, Object>();
 
        count = userService.nickcheck(nickname);
        map.put("cnt", count);
 
        return map;
    }
	
	
	@RequestMapping(value = "/teamUserInfo.do", method = RequestMethod.GET)
	   public ModelAndView TeamUserInfo (String nickname){
	      System.out.println("nickname : " + nickname);
	      ModelAndView mnv = new ModelAndView();
	      UserVO teamuserinfo = null;
	      try {
	         teamuserinfo = userService.getTeamUser(nickname);
	         
	         mnv.addObject("teamuserinfo", teamuserinfo);
	         mnv.setViewName("team_memberInfo");
	      }

	      catch (Exception e) {
	         e.getMessage();
	         e.printStackTrace();
	      }

	      return mnv;
	   }
	
	@RequestMapping(value = "/teamWithdraw.do" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int teamWithdraw (String nickname ,HttpSession session) {
		System.out.println("nickname :" + nickname);
		int i=0;
		try {
			System.out.println("팀 세션 : " + session.getAttribute("teamName"));
			
			HashMap<String, Object> map = new HashMap<String, Object>();			
			map.put("team_name", session.getAttribute("teamName"));
			userService.minusTeam(map);
			
			i = userService.goWithdrawTeam(nickname);	
			session.removeAttribute("teamName");
			System.out.println("i : " + i);
			System.out.println("지워짐 :" + session.getAttribute("teamName"));
	
			return i;
		}
		catch(Exception e) {
			e.getMessage();
			e.getStackTrace();
		}
		
		return i;
	}
	
}
