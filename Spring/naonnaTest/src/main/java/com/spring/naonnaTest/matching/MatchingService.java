package com.spring.naonnaTest.matching;

import java.util.ArrayList;

public interface MatchingService {

	ArrayList<MatchingVO> getMatching();
	ArrayList<MatchingVO> getMatchingSearch(MatchingVO vo);
	public void makeMatching(MatchingVO vo);
	MatchingVO matchDetail(String matchingID);
	public void finishMatch(String matchingID);
	public void addPlayer(PlayerVO vo);
	ArrayList<PlayerVO> playerPrint(String matchingID);
	public void delteMatch(String matchingID);
	
}
