package com.spring.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
		
	@Autowired(required=false) //@Autowired�� �ʵ�, ������, �޼ҵ忡 ��밡��
	private UserDAO userDAO = null; //bean��ü���� ������ �ش� Ŭ���� ��ü�� �ڵ����� �����Ǿ ����(������ ����)
	
	public UserVO login(UserVO userVO) throws Exception{
		try {
			UserVO vo = userDAO.login(userVO);
			return vo;
		} catch (Exception e) {
			throw new Exception(userVO.getId() + "�� ȸ���� �α��� ����", e);
		}
	}

}
