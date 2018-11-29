package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberPrint;
import spring.MemberRegisterService;

@Configuration
public class JavaSubconf {

	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public MemberPrint membePrinter() {
		return new MemberPrint();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}
}
