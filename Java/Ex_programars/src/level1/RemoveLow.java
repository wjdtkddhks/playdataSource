package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.*/

public class RemoveLow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] solution(int[] arr) {
	      int[] answer = {};
	      List<Integer> list = new ArrayList<Integer>();
	      int i=0;
	      
	      for(int a : arr) {
	    	 list.add(a);
	      }
	      
	     list.remove(Collections.min(list));
	     
	     if(list.size() == 0) {
	    	 return new int[] {-1};
	     }
	     answer = new int[list.size()];
	     for(int a : list) {
	    	 answer[i++] = a;
	     }
	      
	      
	      return answer;
	  }
	
	public int[] solution2(int[] arr) {
	      if(arr.length == 1){
	          int[] answer = {-1};
	          return answer;
	      }

	      int[] answer = new int[arr.length-1];
	      int minIndex=0;

	      for(int i=0;i<arr.length;i++){
	          if(arr[minIndex]>arr[i]){
	              minIndex = i;
	          }
	      }
	      for(int i=minIndex+1;i<arr.length;i++){
	          arr[i-1] = arr[i];
	      }
	      for(int i=0;i<answer.length;i++){
	          answer[i] = arr[i];
	      }
	      return answer;
	  }

}
