package com.spring.naonnaTest.ground;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class GroundController {

	@Autowired
	private GroundService groundService; //DI 하는 것.
		
	@RequestMapping(value = "/getGroundJSON.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody			//자바 객체를 http 객체에 담아 저장하고 싶을때
	public String GroundJSONGET() {
		ArrayList<GroundVO> list = groundService.getGroundJson();
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
	
	@RequestMapping(value = "/filter_ground_dao.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody			//자바 객체를 http 객체에 담아 저장하고 싶을때
	public String Ground_DAO_JSON(GroundVO vo) {
		ArrayList<GroundVO> list = groundService.Ground_DAO_Json(vo);
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
	
	@RequestMapping(value = "/time_ground_dao.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody			//자바 객체를 http 객체에 담아 저장하고 싶을때
	public String Ground_Time_JSON(GroundVO groundvo, BookingVO bookingvo) {
		System.out.println("bookingvo.getGameDate() = " + bookingvo.getStartTime());
		System.out.println("bookingvo.getGameTime() = " + bookingvo.getAssign());
		System.out.println("bookingvo.getEndTime()" + bookingvo.getEndTime());
//		bookingvo.setEndTime(endTime);
		
		ArrayList<GroundVO> list = groundService.Ground_Time_Json(groundvo, bookingvo);

		String str = "";
		ObjectMapper mapper = new ObjectMapper(); // KV 사용하여 JSon 양식과 맞게함.
		
		try {
			str = mapper.writeValueAsString(list);
			System.out.println("str=" + str);
		}
		catch (Exception e){
			System.out.println("first() mapper : " + e.getMessage());
		}
		
		return str;
	}
	
	
	
	
	
	@RequestMapping(value = "/ground_detail.do", method = RequestMethod.GET)
	public ModelAndView That_Ground_Info(GroundVO vo) {
		String Ground_Name = vo.getGround_Name();
		System.out.println("Ground_Name = " + Ground_Name);
		vo = groundService.That_Ground_Info(Ground_Name);
		System.out.println("ground_detail complete");

		ModelAndView result = new ModelAndView();
		result.addObject("vo", vo);
		result.setViewName("ground_detail");
		System.out.println("불러오기  complete??");
		return result;
		
	}
	
	@RequestMapping(value = "/insertGround.do", method = RequestMethod.POST)
	public ModelAndView Insert_Ground_Info(GroundVO vo ,MultipartHttpServletRequest multiRequest)  throws Exception {
		  MultipartFile mf1 = multiRequest.getFile("imgfile1");
		  MultipartFile mf2 = multiRequest.getFile("imgfile2");
		  MultipartFile mf3 = multiRequest.getFile("imgfile3");

	      String uploadPath = "C:\\BigDeep\\upload\\";
	      
	      String originalFileExtension = mf1.getOriginalFilename().substring(mf1.getOriginalFilename().lastIndexOf("."));
	      String storedFileName1 = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
	      String storedFileName2 = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
	      String storedFileName3= UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
	      System.out.println("storedFileName1 : " + storedFileName1);
	      System.out.println("storedFileName2 : " + storedFileName2);
	      System.out.println("storedFileName3 : " + storedFileName3);
	      System.out.println("uploadPath : " + uploadPath);
	      
	      if(mf1.getSize() != 0) {	        
	         mf1.transferTo(new File(uploadPath + storedFileName1));
	      }
	      if(mf2.getSize() != 0) {		        
		         mf2.transferTo(new File(uploadPath + storedFileName2));
		  }
	      if(mf3.getSize() != 0) {		        
		         mf3.transferTo(new File(uploadPath + storedFileName3));
		  }
	      
	      
	      //vo.setPhoto(storedFileName);
	      vo.setPhoto1(storedFileName1);
	      vo.setPhoto2(storedFileName2);
	      vo.setPhoto3(storedFileName3);
	      

		System.out.println("Groundphoto in b2 변경사항 ");
		

		
		groundService.insertGround(vo);
		
		ModelAndView result = new ModelAndView();
		result.addObject("vo", vo);
		//result.setViewName("ground_search");
		result.setViewName("manager_index");
		System.out.println("추가 complete??");
		return result;		
		
	}
	
	@RequestMapping(value = "/getAdminGroundJSON.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody			//자바 객체를 http 객체에 담아 저장하고 싶을때
	public String AdminGroundJSONGET(String ground_admin) {
		System.out.println("ground_admin : " + ground_admin);
		GroundVO vo = groundService.getAdminGroundJson(ground_admin);
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
	
	
	@RequestMapping(value = "/ground_updating.do", method = RequestMethod.GET)
	public ModelAndView That_Ground_Updating(String ground_Name ) {
		System.out.println("ground_Name : " + ground_Name);			
		GroundVO vo = groundService.That_UpdateGround_Info(ground_Name);
		System.out.println("ground_update complete");

		ModelAndView result = new ModelAndView();
		result.addObject("vo", vo);
		result.setViewName("ground_update");
		System.out.println("updateForm불러오기  complete??");
		return result;
		
	}
	
	@RequestMapping(value = "/updateGround.do", method = RequestMethod.POST)
	public String UpdateGround(GroundVO vo ,MultipartHttpServletRequest multiRequest, HttpServletResponse response)  throws Exception {
		  MultipartFile mf1 = multiRequest.getFile("imgfile1");
		  MultipartFile mf2 = multiRequest.getFile("imgfile2");
		  MultipartFile mf3 = multiRequest.getFile("imgfile3");

	      String uploadPath = "C:\\BigDeep\\upload\\";
	      
	      String originalFileExtension = mf1.getOriginalFilename().substring(mf1.getOriginalFilename().lastIndexOf("."));
	      String storedFileName1 = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
	      String storedFileName2 = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
	      String storedFileName3= UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
	      System.out.println("storedFileName1 : " + storedFileName1);
	      System.out.println("storedFileName2 : " + storedFileName2);
	      System.out.println("storedFileName3 : " + storedFileName3);
	      System.out.println("uploadPath : " + uploadPath);
	      
	      if(mf1.getSize() != 0) {	        
	         mf1.transferTo(new File(uploadPath + storedFileName1));
	      } 
	      if(mf2.getSize() != 0) {		        
		         mf2.transferTo(new File(uploadPath + storedFileName2));
		  }
	      if(mf3.getSize() != 0) {		        
		         mf3.transferTo(new File(uploadPath + storedFileName3));
		  }

	      vo.setPhoto1(storedFileName1);
	      vo.setPhoto2(storedFileName2);
	      vo.setPhoto3(storedFileName3);
	     System.out.println("ground_admin : " + vo.getGround_admin());
		System.out.println("GroundUpdate 사진 in 성공 ");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int res = groundService.updateThatGround(vo);
		if(res == 1) {
			out.println("<script>");
			out.println("alert('그라운드수정 완료')");
			out.println("location.href= 'manager.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('그라운드수정 실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return null;
		
	}

	@RequestMapping(value = "/bookingGround.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody			//자바 객체를 http 객체에 담아 저장하고 싶을때
	public String Ground_Book_JSON(BookingVO bookingvo, HttpServletResponse response)  throws Exception {
		System.out.println("booknumber : " + bookingvo.getBookNumber());
		System.out.println("groundname : " + bookingvo.getGroundName());	
		System.out.println("machingId : " + bookingvo.getMatchingID());	
		System.out.println("nickname : " + bookingvo.getNickname());	
		System.out.println("startTime : " + bookingvo.getStartTime());	
		System.out.println("assign : " + bookingvo.getAssign());	
		System.out.println("endTime : " + bookingvo.getEndTime());	
		
		//BookingVO list = 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		groundService.Ground_Book_JSON(bookingvo);	

		
		return null;
	}
	
	
	@RequestMapping(value = "/getAdminBookingJSON.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody			//자바 객체를 http 객체에 담아 저장하고 싶을때
	public String Ground_Bookedlist_JSON(BookingVO bookingvo) {
		
		ArrayList<BookingVO> Bookinglist = groundService.Ground_Bookedlist_JSON(bookingvo);

		String str = "";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			str = mapper.writeValueAsString(Bookinglist);
			System.out.println("getAdmin str=" + str);
		}
		catch (Exception e){
			System.out.println("first() mapper : " + e.getMessage());
		}
		
		return str;
		
	}
	
	@RequestMapping(value = "/confirmMatching.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody			//자바 객체를 http 객체에 담아 저장하고 싶을때
	public int matchingConfirm(BookingVO vo) {
		System.out.println(vo.getNickname());
		System.out.println(vo.getGroundName());
		System.out.println(vo.getBookNumber());
		groundService.matchingCon(vo);
		System.out.println(vo.getNickname());
		return 1;	
	}
	
	@RequestMapping(value = "/kakaoPay.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
	public ModelAndView kakaoPay(String groundName) {
		ModelAndView mnv = new ModelAndView();
		GroundVO groundVO = null;
		try {
			System.out.println("groundName 카카오페이 = " + groundName);
			groundVO = groundService.groundPrice(groundName);
			mnv.addObject("groundPrice", groundVO.getWeek_morning());
			mnv.addObject("groundName", groundVO.getGround_Name());
			mnv.setViewName("kakaoPay");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return mnv;
	}
	
	
}