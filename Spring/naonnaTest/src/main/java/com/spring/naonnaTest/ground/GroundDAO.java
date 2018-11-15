package com.spring.naonnaTest.ground;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //DB에 접속해서 작업하는 것을 이야기함. 서비스와 유사.
public class GroundDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<GroundVO> DAOtoMapper(GroundVO vo) {
		System.out.println("DAO ground_addr : " + vo.getGround_addr());
		System.out.println("DAO ground_city : " + vo.getGround_city());
		System.out.println("DAO ground_grass : " + vo.getGrass());
		System.out.println("DAO ground_parking : " + vo.getParking());
		System.out.println("DAO ground_shower : " + vo.getShower());
		System.out.println("DAO ground_light : " + vo.getLight());
		ArrayList<GroundVO> groundList = null;
		try {			
			GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);
			groundList = groundMapper.MapperFromDAO(vo);	
			System.out.println("groundList=" + groundList);			
		}
		catch(Exception e) {
			System.out.println("e.getMessage() = " + e.getMessage());
		}
		return groundList;
	}
	
	public ArrayList<GroundVO> TimetoMapper(GroundVO groundvo, BookingVO bookingvo) {
		System.out.println("DAO ground_addr : " + groundvo.getGround_addr());
		System.out.println("DAO ground_city : " + groundvo.getGround_city());
		System.out.println("DAO ground_grass : " + groundvo.getGrass());
		System.out.println("DAO ground_parking : " + groundvo.getParking());
		System.out.println("DAO ground_shower : " + groundvo.getShower());
		System.out.println("DAO ground_light : " + groundvo.getLight());
		System.out.println("DAO game start : " + bookingvo.getStartTime());
		System.out.println("DAO game end : " + bookingvo.getEndTime());
		System.out.println("DAO game assign : " + bookingvo.getAssign());
		
		HashMap map = new HashMap<String, Object>();
		map.put("ground_addr", groundvo.getGround_addr());
		map.put("ground_city", groundvo.getGround_city());
		map.put("grass", groundvo.getGrass());
		map.put("parking", groundvo.getParking());
		map.put("shower", groundvo.getShower());
		map.put("light", groundvo.getLight());
		map.put("startTime", bookingvo.getStartTime());
		map.put("endTime", bookingvo.getEndTime());
		
		ArrayList<GroundVO> groundList = null;
		
		try {			
			GroundMapper groundMapper = sqlSession.getMapper(GroundMapper.class);
			groundList = groundMapper.MapperFromTime(map);
			System.out.println("groundList=" + groundList);			
		}
		catch(Exception e) {
			System.out.println("e.getMessage() = " + e.getMessage());
		}
		return groundList;
	}
	
}
