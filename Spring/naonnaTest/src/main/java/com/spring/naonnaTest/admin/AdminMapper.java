package com.spring.naonnaTest.admin;

public interface AdminMapper {

	int insertAdmin(AdminVO vo);
	String userCheck(AdminVO vo);
	String isAdmin(AdminVO vo);
	AdminVO getAdminInfo(AdminVO vo);
	int getAdminId(String admin);
}
