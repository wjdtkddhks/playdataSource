package kakao_test;

import java.util.HashMap;

public class Foodtime {
	
	public static void main(String[] args) {
		int[] food_times = {3, 1, 2};
		int k = 5;
		
		System.out.println(solution(food_times, k));
	}
	 public static int solution(int[] food_times, long k) {
	        int answer = 0;
	        int check = 1;
	        HashMap<Integer, Integer> fvolume = new HashMap<Integer, Integer>();
	       
	        
	        for(int a : food_times) {
	        	fvolume.put(check, a);
	        	check++;
	        }
	        int size = fvolume.size();
	        check=0;
	        
	        	for(int j=1; j<=fvolume.size(); j++) {
	        		if(fvolume.containsKey(j)) {
	        			int value = fvolume.get(j).intValue();
		        		if(value > 0) {
		        			fvolume.replace(j, value-1);
		        			check++;
		        		}else {
		        			fvolume.remove(j);
		        		}
		        		if(check%fvolume.size() == 0) {	
		        			j=0;
		        		}
		        		
		        		if(check == k) {
		        			answer = j%size;
		        			break;
		        		}
		        		
	        		}
	        	}

	        return answer;
	 }
}
