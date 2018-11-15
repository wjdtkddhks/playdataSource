package com.spring.croling;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String home(Locale locale, Model model){
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
		
	@RequestMapping(value="/croling.do", method= RequestMethod.POST,
			produces="application/json;charset=UTF-8")
	@ResponseBody
	public String croling() throws IOException {
		Croling cr;
		ArrayList<Croling> crList = new ArrayList<Croling>();
		String bbs = "";
		String real = "";
		
		String BASE_URL_F = "https://store.naver.com/restaurants/detail?id=11680222&tab=fsasReview&tabPage=";
		int BASE_URL_PAGE = 0;
		String COMPLETE_URL = BASE_URL_F + BASE_URL_PAGE;
		
		 int page = 0;
		 int num = 0;
		 while (page <= 2) {
		   Document naver_reviews = Jsoup.connect(COMPLETE_URL)
		   .header("Accept", "text/html, application/xhtml+xml, image/jxr, */*")
		   .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko")
		   .header("Accept-Encoding", "gzip, deflate").header("Accept-Language", "ko-KR")
		   .header("Connection", "Keep-Alive").get();
		   
		   Elements div_blog_num  = naver_reviews.select("div.info_inner");
		   for(Element blog_nums : div_blog_num) {
			   Elements blog_number = blog_nums.select("a.link");
			   for(Element bb : blog_number) {
				   bbs = bb.text();
				   
			   }
		   }
		   real = bbs.substring(7);
		   System.out.println("real : " + real);
		   
		   
		   
		  Elements div_reviews =naver_reviews.select("div.tit");
		  for(Element div_review : div_reviews) {
			   Elements url_title = div_review.select("a.name");
			   for (Element x : url_title) {
				   
				      String url = x.attr("href");
				      String title = x.text();
				
				      System.out.println("url  >> " + url);
				      System.out.println("title  >> " + title);
					  	     
				    	  cr = new Croling();
				    	  cr.setUrl(url);
				    	  cr.setTitle(title);
				    	  crList.add(cr);
			   }
		  }
			   
			  Elements div_content =naver_reviews.select("div.txt.ellp2");
			  
				   for (Element x : div_content) {
					   String content = x.text();
					   System.out.println("content  >> " + content);
					   cr = crList.get(num);
					   cr.setContent(content);
					   crList.set(num, cr);
					   
					   num++;
				}
			   
  
		   System.out.println("페이지 : " + page + "=====================");
		   page += 1;
		   BASE_URL_PAGE = page;
		   COMPLETE_URL = BASE_URL_F + BASE_URL_PAGE;
		   
		   }
		   String str = "";
		   ObjectMapper mapper = new ObjectMapper();
		   str = mapper.writeValueAsString(crList);
		   
		   return str;
		   
		 //Document doc = Jsoup.connect(url).get();
	         
	         //Elements body = doc.select("div#newsEndContents.news_end font1 size3");
	         //Elements title = doc.select("h3#articleTitle");
	         //Elements date = doc.select("div.info");
	         //String str_title = title.text();
	         //String str_body = body.text();
	         //String str_date = date.text();
	         //if (str_title.equals("")||str_body.equals("")) {
	            
	         //}
	         //else {
	         //System.out.println("기사제목: " + str_title);
	         //System.out.println("기사날짜 : " + str_date);
	         //System.out.println("본문 : " + str_body);
	         //}
	      //}
	}
	
}
