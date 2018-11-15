package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintOrder {

	public static void main(String[] args) {
		System.out.println(solution2(new int[] {1,1,9,1,1,1}, 0));
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 1;
        int idx = 0;
        Queue<String> que = new LinkedList<String>();
        
        for(int a : priorities) {
        	que.add(""+ a + idx);
        	idx++;
        }
        System.out.println(que);
       
       while(true) {
   	   
    	  char max = Collections.max(que).charAt(0);
    	   
    	  String a = que.poll();
    	  if(a.charAt(0) < max) {
    		  que.add(a);
    		  continue;
    	  }
    	   
    	  if(a.charAt(1)-48 == location) {
    		  break;
    	  }
    	  
    	  answer++;
       }
       
        return answer;
    }
	
	public static int solution2(int[] priorities, int location) {
	    List<Integer> list = new ArrayList<>();
	    for (int priority : priorities) {
	      list.add(priority);
	    }

	    int turn = 1;
	    while (!list.isEmpty()) {
	      final Integer j = list.get(0);
	      if (list.stream().anyMatch(v -> j < v)) {
	        list.add(list.remove(0));
	      } else {
	        if (location == 0) {
	          return turn;
	        }
	        list.remove(0);
	        turn++;
	      }

	      if (location > 0) {
	        location--;
	      } else {
	        location = list.size() - 1;
	      }
	    }

	    throw new IllegalArgumentException();
	  }


}
