package com.spring.springform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "inputform.bo" )
	public String home(Model model) {
		
		return "forminput";
	}

	@RequestMapping(value="inputprocess.bo")
	/*public String processForm(ServletRequest request, Model model) {
		Connection con =  null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "123456");
			ptmt = con.prepareStatement("select first_name from EMPLOYEES order by first_name");
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				String ename = rs.getString("first_name");
				list.add(ename);
			}
			
			model.addAttribute("list", list);
			model.addAttribute("id", request.getParameter("id"));
			model.addAttribute("pw", request.getParameter("pw"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return "resultform";
	}*/
	
	public ModelAndView processForm(ServletRequest request, ModelAndView result) {
		Connection con =  null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "hr", "123456");
			ptmt = con.prepareStatement("select first_name from EMPLOYEES order by first_name");
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				String ename = rs.getString("first_name");
				list.add(ename);
			}
			
			result.addObject("list", list);
			result.addObject("id", request.getParameter("id"));
			result.addObject("pw", request.getParameter("pw"));
			result.setViewName("resultform");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
}
