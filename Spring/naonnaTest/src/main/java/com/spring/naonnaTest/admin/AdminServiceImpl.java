package com.spring.naonnaTest.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertAdmin(AdminVO vo) {
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		System.out.println(vo.getGround_name());
		int check = adminMapper.insertAdmin(vo);
		return check;
	}
	
	@Override
	public int userCheck(AdminVO vo) {
		int check = -1;
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		String ground_ad_pw = adminMapper.userCheck(vo);
		if(ground_ad_pw == null) {
			check = -1;
		}else if (ground_ad_pw.equals(vo.getGround_ad_pw())) {
			check =1;
		}else {
			check =0;
		}
		return check;
	}
	
	/*@Override
	public String isAdmin(AdminVO vo) {
		//boolean result = false;
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		String check = adminMapper.isAdmin(vo);
		System.out.println("isAdmin :" + check);
		if(check == "abc") {
			
			result = true;
		}
		
		
		System.out.println("isAdmin :" + result);
		
		return check;
		//return result;
		
	}*/
	
	@Override
	public AdminVO getAdminInfo(AdminVO vo) {
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		AdminVO adminvo = adminMapper.getAdminInfo(vo);
		
		return adminvo;
	}
	

	@Override
	public int idcheck (String admin) {
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		int check = adminMapper.getAdminId(admin);
		
		return check;
		
	}
}
