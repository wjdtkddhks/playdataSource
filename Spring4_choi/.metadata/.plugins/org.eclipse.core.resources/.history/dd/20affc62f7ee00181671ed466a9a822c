package spring;

import java.util.Collection;

public class MemberListPrinter {
	
	private MemberDao memberDao;
	private MemberPrint memberPrint;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrint memberPrint) {
		this.memberDao = memberDao;
		this.memberPrint = memberPrint;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members) {
			memberPrint.print(m);
		}
	}

}
