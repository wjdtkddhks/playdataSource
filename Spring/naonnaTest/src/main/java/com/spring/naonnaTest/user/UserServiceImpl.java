package com.spring.naonnaTest.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private SqlSession sqlSession;

//	@Autowired(required=false) 		//@Autowired는 필드 생성자 메소드에 사용 가능
//	private GroundDAO groundDAO = null;		//new UserDAO()객체가 자동으로 생성되어서 대입된다.

	@Override
	public UserVO distMember(String forPerson) {
		UserVO user = null;
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		try {
			user = userMapper.getUserInfo(forPerson);
		}
		catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return user;		
	}
	
	@Override
	public UserVO goMyPage(String nickname) {
		UserVO vo = null;
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		vo = userMapper.myUserInfo(nickname);	
		
		return vo;
	}
	
	
	@Override
	public void insertUser(UserVO vo) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.insertUserInfo(vo);
	}
	
	@Override
	public UserVO printUser(String forPerson) {
		UserVO vo = null;
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		vo = userMapper.getUserInfo(forPerson);
		
		return vo;
	}
	
	@Override
	public void updateInfo(UserVO vo) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.updateInfo(vo);
	}
	
	@Override
	public void updateProfile(UserVO vo) {
		System.out.println("vo.getUserPhoto(service) = " + vo.getUserPhoto());
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.updateProfile(vo);
	}
	
	@Override
	public int nickcheck(String nickname) {
	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	int check = userMapper.getUserNick(nickname);
	
	return check;
	}
	
	@Override
	   public UserVO getTeamUser (String nickname) {
	      UserVO vo =null;
	      UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	      vo = userMapper.myUserInfo(nickname);
	      
	      return vo;
	   }
	
	@Override
	public int goWithdrawTeam(String nickname) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		
		userMapper.teamMemdelete(nickname);
		int i = userMapper.teamDraw(nickname);
		System.out.println("i :" + i);
		
		
		
		return i;
	}
	
	public void  minusTeam(HashMap<String,Object> map) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.minTeamMem(map);
	}
}
