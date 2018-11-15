package com.spring.naonnaTest.matching;

import java.util.ArrayList;

public interface MatchingMapper {

	ArrayList<MatchingVO> getMatchingList();
	ArrayList<MatchingVO> searchMatchingList(MatchingVO vo);
	ArrayList<PlayerVO> printPlayers(String matchingID);
	void insertMatching(MatchingVO vo);
	MatchingVO detailMatching(String matchingID);
	void matchFin(String matchingID);
	void addPlayer(PlayerVO vo);
	void confirmMatchMessage(PlayerVO vo);
	void delMatch(String matchingID);
}
