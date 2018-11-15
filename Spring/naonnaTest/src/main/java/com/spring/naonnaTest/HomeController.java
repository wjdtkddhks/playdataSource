package com.spring.naonnaTest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   /**
    * Simply selects the home view to render by returning its name.
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      logger.info("Welcome home! The client locale is {}.", locale);
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      
      String formattedDate = dateFormat.format(date);
      
      model.addAttribute("serverTime", formattedDate );
      
      return "home";
   }
   
   @RequestMapping(value = "/ground_info.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_ground_info() {
      return "ground_search";
   }
   
   @RequestMapping(value = "/ground_regi.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_ground_regi() {
      return "ground_register";
   }
   
   @RequestMapping(value = "/matching_search.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_matching_search() {
      return "matching_search";
   }
   
   @RequestMapping(value = "/home.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_index() {
      return "main";
   }
   
   @RequestMapping(value = "/team_search.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_team_search() {
      return "team_search";
   }
   
   @RequestMapping(value = "/player_search.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_player_search() {
      return "player";
   }
      
   @RequestMapping(value = "/notice.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_notice() {
      return "notice";
   }
   
   @RequestMapping(value = "/faq.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_faq() {
      return "faq";
   }
   
   @RequestMapping(value = "/qna.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_qna() {
      return "client_chat";
   }
   
   @RequestMapping(value = "/messageHome.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_message() {
      return "message";
   }
   
   @RequestMapping(value = "/KakaoLogout.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String Kakaologout(HttpSession session) {
      session.invalidate();
      return "main";
   }
   
   
   @RequestMapping(value = "/manager.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_manager_Page() {
      return "manager_index";
   }
   
   @RequestMapping(value = "/notice_page.do", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
   public String go_notice_Page() {
      return "writing_notice";
   }
   
}