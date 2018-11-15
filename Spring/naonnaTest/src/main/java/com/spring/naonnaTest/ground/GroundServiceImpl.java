package com.spring.naonnaTest.ground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("groundService")
public class GroundServiceImpl implements GroundService{

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired(required=false) 		//@Autowired는 필드 생성자 메소드에 사용 가능
	private GroundDAO groundDAO = null;		//new UserDAO()객체가 자동으로 생성되어서 대입된다.
	
	@Override
	public ArrayList<GroundVO> getGroundJson() {
		ArrayList<GroundVO> groundList = null;
		GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);
		groundList = groundMapper.getGroundList();
		
		return groundList;
	}
	
	@Override
	public ArrayList<GroundVO> Ground_DAO_Json(GroundVO vo) {
		ArrayList<GroundVO> groundList = groundDAO.DAOtoMapper(vo);
		return groundList;
	}
	
	@Override
	public ArrayList<GroundVO> Ground_Time_Json(GroundVO groundvo, BookingVO bookingvo) {
		ArrayList<GroundVO> groundList = groundDAO.TimetoMapper(groundvo, bookingvo);
		return groundList;
	}
	
	@Override
	public GroundVO That_Ground_Info(String Ground_Name){
		GroundVO ThatGroundInfo = new GroundVO();
		GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);
		ThatGroundInfo = groundMapper.getThatGroundList(Ground_Name);
		
		return ThatGroundInfo;
	}
	
	@Override
	public void insertGround(GroundVO vo) {
		GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);
		try {
			int res = groundMapper.insertGround(vo);		//삽입 후 삽인한 결과 상태 반환하기 위해 반환값을 int로 줌
			groundMapper.insertBookingGround(vo);
			System.out.println("res = " + res);
		}
		catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
			
		}		
	}
	
	@Override
	public GroundVO getAdminGroundJson(String ground_admin){
		GroundVO admingroundList = new GroundVO();
		GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);
		try {
			admingroundList = groundMapper.getAdminGroundList(ground_admin);
			
		}
		catch(Exception e) {
			e.getStackTrace();
			e.getMessage();
		}
		
		return admingroundList;
		
	}
	
	@Override
	public GroundVO That_UpdateGround_Info(String ground_name) {
		GroundVO ThatUpdateGroundInfo = new GroundVO();
		GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);
		ThatUpdateGroundInfo = groundMapper.getThatUpdateGroundList(ground_name);
		
		return ThatUpdateGroundInfo;
		
	}
	
	@Override
	public int updateThatGround(GroundVO vo) {
		
		GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);		
	    int res = groundMapper.modifyGround(vo);
		 
		return res;
	}
	
	@Override
	public void Ground_Book_JSON(BookingVO bookingvo) {
		try {
			GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);
			groundMapper.addBooking(bookingvo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<BookingVO> Ground_Bookedlist_JSON(BookingVO bookingvo) {
		ArrayList<BookingVO> Bookinglist = null;
		
		try {
			GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);
			Bookinglist = groundMapper.selectBooking(bookingvo);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return Bookinglist;
		
	}
	
	@Override
	public void matchingCon(BookingVO bookingvo) {
		GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);
		
		try {
			groundMapper.confirmMessage(bookingvo);
			groundMapper.confirmMat(bookingvo);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public GroundVO groundPrice(String groundName) {
		GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);
		GroundVO groundVO = null;
		try {
			groundVO = groundMapper.groundPriceInfo(groundName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return groundVO;
	}
	
}
