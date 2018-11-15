package com.spring.springwebsocket;

import java.util.Locale;

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
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Locale locale, Model model) { //파라미터값은 사실상 쓸모없음, 비어도 됨
		System.out.println("HomeController.java에서 시작.");
		return "client_chat";
	}
}
