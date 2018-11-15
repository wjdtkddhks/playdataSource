package com.spring.springmybatis;

/*
 	create table tab_mybatis(
    id varchar2(30) primary key,
    name varchar2(30),
    email varchar2(50),
    phone varchar2(20)
	);

	insert into tab_mybatis values('A001', '이기자', 'A001@daum.net', '010-1111-1111');
	insert into tab_mybatis values('A002', '김기자', 'A002@daum.net', '010-2222-2222');
	insert into tab_mybatis values('A003', '박기자', 'A003@daum.net', '010-3333-3333');
	insert into tab_mybatis values('A004', '길기자', 'A004@daum.net', '010-4444-4444');
	insert into tab_mybatis values('A005', '홍기자', 'A005@daum.net', '010-5555-5555');
 */

import org.springframework.stereotype.Component;

@Component
public class MemberVO {
	private String id;
	private String name;
	private String email;
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
