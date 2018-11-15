package com.spring.springajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PeopleController {
		
	@Autowired
	private PeopleService peopleService;
	
	@RequestMapping(value="/home.do", method= RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/getPeopleJSON.do", method= RequestMethod.POST,
			produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getPeopleJSONGET() {
		List<PeopleVO> list = peopleService.getPeoplejson();
		String str = "";
		ObjectMapper mapper = new ObjectMapper(); //JSON형식으로 데이터를 반환하기 위해 사용(pom.xml 편집)
		try {
			str = mapper.writeValueAsString(list);
		} catch (Exception e) {
			System.out.println("first() mapper : " + e.getMessage());
		}
		return str;
	}
	
	@RequestMapping(value="/insertPerson.do", method=RequestMethod.POST,
			produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object insertPerson(PeopleVO vo) {
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		try {
			System.out.println("vol1.getName() = " + vo.getName());
			int res = peopleService.insertPeople(vo);
			
			retVal.put("res", "OK");
			
		} catch (Exception e) {
			retVal.put("res", "FAIL");
			retVal.put("message", "Failure");
		}
		
		return retVal;
	}
}
