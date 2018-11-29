package spring;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	
//	@Resource는 생성자에는 적용 불가, 필드나 메서드에만 적용 가능
	
	private MemberDao memberDao;	
	
	public MemberRegisterService(MemberDao memberDao) {
		System.out.println("MemberReg 주입 : " + memberDao);
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			 throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}
}
