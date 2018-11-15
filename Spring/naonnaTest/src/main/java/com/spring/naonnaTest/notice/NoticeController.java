package com.spring.naonnaTest.notice;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class NoticeController {
   
   @Autowired
   private NoticeService noticeService;
   
   @RequestMapping(value = "/noticeinsert.do", method = RequestMethod.POST)
   public String Noticewrite(NoticeVO noticevo, HttpServletResponse response ) throws Exception {
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
            
      int check = noticeService.insertwrite(noticevo);
      
      if(check == 1) {
         out.println("<script>");
         out.println("alert('공지사항 등록완료되었습니다.');");         
         out.println("location.href='notice.do';");
         out.println("</script>");         
         out.close();
         
      }else {
         out.println("<script>");
         out.println("alert('공지사항 등록실패');");
         out.println("location.href='notice_page.do';");
         out.println("</script>");         
         out.close();
      }
      
      return null;
   }
   
   



   @RequestMapping(value= "/getNoticeList.do", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
   @ResponseBody
   public String NoticeGET() {
      ArrayList<NoticeVO> list = noticeService.getNoticeJson();
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
   
   
   
   @RequestMapping(value = "/notice_datail.do", method = RequestMethod.GET)
   public ModelAndView That_notice_Info(NoticeVO noticevo) {
      String title = noticevo.getTitle();
      System.out.println("title = " + title);
      noticevo = noticeService.That_notice_Info(title);
      System.out.println("notice_detail complete");
   
      System.out.println(noticevo.getTitle());
      System.out.println(noticevo.getContents());
      System.out.println(noticevo.getWriter());
      System.out.println(noticevo.getWrite_date());
      
      ModelAndView mav = new ModelAndView();
      mav.addObject("noticevo", noticevo);
      mav.setViewName("notice_detail");
      System.out.println("notice_detail불러오기  complete??");
      return mav;
      
   }
   
   @RequestMapping(value = "/notice_delete.do", method = RequestMethod.GET)
   public String deleteNotice (String title, HttpServletResponse response ) throws Exception {
      System.out.println("title : " + title);
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      int check = noticeService.delete_notice(title);
      if(check == 1) {
         out.println("<script>");
         out.println("alert('공지사항 삭제완료되었습니다.');");         
         out.println("location.href='notice.do';");
         out.println("</script>");         
         out.close();
         
      }else {
         out.println("<script>");
         out.println("alert('공지사항 삭제실패');");
         out.println("location.href='history.go(0)';");
         out.println("</script>");         
         out.close();
      }
      
      return null;
   }
}