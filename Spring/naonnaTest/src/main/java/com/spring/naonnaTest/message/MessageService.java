package com.spring.naonnaTest.message;

import java.util.ArrayList;
import java.util.HashMap;

public interface MessageService {

	public void playerToMatch(MessageVO vo);
	public int countMessage(String nickname);
	ArrayList<MessageVO> printMessage(String nickname);
	public void joinTeamMSG(MessageVO vo);
	public void deleteMsg(String[] message);
	
	public void reMessage(HashMap<String, String> map2 , MessageVO vo );
	
}
