package com.spring.naonnaTest.admin;

public interface AdminService {
	
	int insertAdmin(AdminVO vo);
	int userCheck(AdminVO vo);
	//String isAdmin(AdminVO vo);
	AdminVO getAdminInfo(AdminVO vo);
	int idcheck (String admin); 
		
}
