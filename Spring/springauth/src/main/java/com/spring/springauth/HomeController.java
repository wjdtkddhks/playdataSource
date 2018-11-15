package com.spring.springauth;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;
	
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
	
	@RequestMapping(value = "/googleLogin.do")
	public String doGoogleSignInActionPage(HttpServletResponse response, Model model) throws Exception{
	  OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
	  String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
	  System.out.println("/member/googleSignIn, url : " + url);
	  model.addAttribute("url",url);
	  return "googleLogin";

	}
	@RequestMapping(value = "/googleSignInCallback")
	public String doSessionAssignActionPage(HttpServletRequest request)throws Exception{
	  System.out.println("/member/googleSignInCallback");
	  String code = request.getParameter("code");

	  OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
	  AccessGrant accessGrant = oauthOperations.exchangeForAccess(code , googleOAuth2Parameters.getRedirectUri(),
	      null);

	  String accessToken = accessGrant.getAccessToken();
	  Long expireTime = accessGrant.getExpireTime();
	  if (expireTime != null && expireTime < System.currentTimeMillis()) {
	    accessToken = accessGrant.getRefreshToken();
	    System.out.printf("accessToken is expired. refresh token = {}", accessToken);
	  }
	  Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
	  Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();

	  PlusOperations plusOperations = google.plusOperations();
	  Person profile = plusOperations.getGoogleProfile();
	  MemberVO vo = new MemberVO();
	  System.out.println(profile.getDisplayName());
	  vo.setEmail("구글 로그인 계정");
	  vo.setNickName(profile.getDisplayName());
	  vo.setId("g"+profile.getId());
	  HttpSession session = request.getSession();

	  session.setAttribute("login", vo );

	  return "redirect:/";
	}
	
}
