package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrint;
import spring.MemberRegisterService;

@Configuration
public class JavaConfig {

//	자바 설정파일로 해도 싱글톤으로 운영 >> Spring runtime시에 config class 상속받은 클래스를 따로 생성(싱글톤으로 유지 가능한)
// CGLIB라는 기술 사용(조건 1. final 클래스 X  2. 파라미터 없는 기본 생성자를 제공)
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public MemberPrint print() {
		return new MemberPrint();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
//		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setPrinter(print());

		return new MemberInfoPrinter();
	}

}
