package level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BridgeTruck {

	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[]{7,4,5,6}));

	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        Queue<Integer> que = new LinkedList<Integer>();
	        int sum = 0;
	        
	       for(int a : truck_weights) que.add(a);
	               
	        while(true) {
	        	answer++;
	        	
	        	if(map.containsKey(answer)) {
	        		map.remove(answer);
	        	}
	        	
	        	sum = map.values().stream().mapToInt(i -> i.intValue()).sum();
	        	
	        	if(!que.isEmpty()) {
	        		if(sum + que.peek() <= weight) {
	        			map.put(answer+bridge_length, que.poll());
	        		}
	        	}
	        	
	        	if(que.isEmpty() && map.isEmpty()) {
	        		break;
	        	}
	        	
	        }
	          
	        return answer;
	}

}
