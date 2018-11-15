package com.spring.springmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapDAOService implements MapDAO {
		
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<MapVO> getMapList(){
		MapMapper mapMapper = sqlSession.getMapper(MapMapper.class);
		ArrayList<MapVO> mapList = mapMapper.getMapList();
		System.out.println("DAO : " + mapList.size());
		return mapList;
	}
	
	@Override
	public HashMap<String, Double> getAvg(){
		MapMapper mapMapper = sqlSession.getMapper(MapMapper.class);
		HashMap<String, Double> map = mapMapper.getAvg();
		System.out.println("DAO : " + map.size());
		System.out.println("map pboard_taste: " + map.containsKey("pboard_taste"));
		Iterator iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry entry = (Entry)iterator.next();
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		System.out.println("map AVG(PBOARD_TASTE) : " + map.containsKey("AVG(PBOARD_TASTE)"));
		return map;
	}
}
