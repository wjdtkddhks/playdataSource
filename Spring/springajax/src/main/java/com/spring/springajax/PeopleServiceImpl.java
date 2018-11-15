package com.spring.springajax;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PeopleVO> getPeoplejson() {
		List<PeopleVO> peopleList = null;
		PeopleMapper memberMapper = sqlSession.getMapper(PeopleMapper.class);
		peopleList = memberMapper.getPeopleList();
		return peopleList;
	}

	@Override
	public int insertPeople(PeopleVO vo) {
		PeopleMapper memberMapper = sqlSession.getMapper(PeopleMapper.class);
		int res = memberMapper.insertPeople(vo);
		return res;
	}

}
