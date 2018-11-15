package com.spring.naonnaTest.message;

import java.util.ArrayList;

public interface MessageMapper {

	public void playerMSG(MessageVO vo);
	public int countMsg(String nickname);
	public ArrayList<MessageVO> printMsg(String nickname);
	public void insertMessageTeam(MessageVO vo);
	public void deleteMessage(String msg);
	public void finishMatching(MessageVO vo);
	public void finishJoinTeam(MessageVO vo);
}
