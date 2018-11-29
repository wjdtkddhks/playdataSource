package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrint;

@Configuration
public class ConfigPartSub {
	
	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public MemberPrint print() {
		return new MemberPrint();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setPrinter(print());

		return infoPrinter;
	}
}
