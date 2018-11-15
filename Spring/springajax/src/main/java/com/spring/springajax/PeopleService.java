package com.spring.springajax;

import java.util.List;

public interface PeopleService {
	
	List<PeopleVO> getPeoplejson();
	int insertPeople(PeopleVO vo);

}
