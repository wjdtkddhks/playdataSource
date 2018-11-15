package com.spring.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
		
	@Autowired(required=false) //@Autowired는 필드, 생성자, 메소드에 사용가능
	private UserDAO userDAO = null; //bean객체들을 뒤져서 해당 클래스 객체가 자동으로 생성되어서 대입(의존성 주입)
	
	public UserVO login(UserVO userVO) throws Exception{
		try {
			UserVO vo = userDAO.login(userVO);
			return vo;
		} catch (Exception e) {
			throw new Exception(userVO.getId() + "인 회원의 로그인 실패", e);
		}
	}

}
