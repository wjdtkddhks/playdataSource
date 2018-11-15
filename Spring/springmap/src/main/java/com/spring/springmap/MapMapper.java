package com.spring.springmap;

import java.util.ArrayList;
import java.util.HashMap;

public interface MapMapper {
	ArrayList<MapVO> getMapList();
	HashMap<String, Double> getAvg();
}
