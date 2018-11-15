package com.spring.springajax;

import java.util.List;

public interface PeopleMapper {
	
	List<PeopleVO> getPeopleList();
	int insertPeople(PeopleVO vo);
	//PeopleVO getPeople(String id);
	//void updatePeople(PeopleVO vo);
	//void deletePeople(String id);
	//int getCount();

}
