package com.spring.naonnaTest.message;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MessageDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public void matchMessage(MessageVO vo) {
		String message =  vo.getMatchingID() +"매칭에 "+ vo.getSendPeople()+"님 외 " + vo.getPeople() +"명 신청하셨습니다.";
		vo.setMessage(message);
		try {
			MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
			messageMapper.playerMSG(vo);
//			message = vo.getMatchingID() + "매칭 신청이 완료되었습니다.";
//			vo.setMessage(message);
//			messageMapper.finishMatching(vo);
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

	}
}
