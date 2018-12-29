package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {
	
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
//	@Transactional(rollbackFor = {SQLException.class, IOException.class}) // 두개의 Exception이 일어나면 rollback 
	@Transactional
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null)
			throw new MemberNotFoundException();
		
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}

}
