package com.spring.springmap;

import java.util.ArrayList;
import java.util.HashMap;

public interface MapDAO {
	ArrayList<MapVO> getMapList();
	HashMap<String, Double> getAvg();
}
