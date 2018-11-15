package com.spring.springvisitor;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("visitorDAOService")
public class VisitorDAOService implements VisitorDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	public int insertVisitor(String agent) {
		VisitorMapper visitorMapper = sqlSession.getMapper(VisitorMapper.class);
		System.out.println("VisitorDAOService");
		int res = visitorMapper.insertVisitor(agent);
		System.out.println(res);
		return res;
	}
}
