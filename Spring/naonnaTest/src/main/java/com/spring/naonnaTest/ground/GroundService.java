package com.spring.naonnaTest.ground;

import java.util.ArrayList;
import java.util.HashMap;

public interface GroundService {
	
	ArrayList<GroundVO> getGroundJson();
	ArrayList<GroundVO> Ground_DAO_Json(GroundVO vo);
	ArrayList<GroundVO> Ground_Time_Json(GroundVO groundvo, BookingVO bookingvo);	
	GroundVO That_Ground_Info(String Ground_Name);	
	void insertGround(GroundVO vo);
	GroundVO getAdminGroundJson(String ground_admin);
	
	GroundVO That_UpdateGround_Info(String ground_Name);
	int updateThatGround(GroundVO vo);
	
	void Ground_Book_JSON(BookingVO bookingvo);
	ArrayList<BookingVO> Ground_Bookedlist_JSON(BookingVO bookingvo);
	void matchingCon(BookingVO bookingvo);
	GroundVO groundPrice(String groundName);
	
	//ArrayList<GroundVO> That_Ground_Info_JSON(GroundVO vo);
	//public void insertGround2(HashMap<String, String> map);
	
	/* public void saveImage(Map<String, Object> hmap) throws SQLException;
	 public Map<String, Object> getByteImage();*/
}
