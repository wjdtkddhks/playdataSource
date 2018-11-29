package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	
	private MemberDao memberDao;

	private MemberPrint printer;
	
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("MemberInfo 주입 : " + memberDao);
		this.memberDao = memberDao;
	}
	
	public void setPrinter(MemberPrint memberPrint) {
		this.printer = memberPrint;
	}
	
	public void printManager(String email) {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}
}
