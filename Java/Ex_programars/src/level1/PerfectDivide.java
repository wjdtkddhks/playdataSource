package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요. 
•arr은 자연수를 담은 배열입니다.
•정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
•divisor는 자연수입니다.
•array는 길이 1 이상인 배열입니다.*/

public class PerfectDivide {
	
	public static void main(String[] args) {
		int[] b = {2, 36, 1, 3};
		int[] a = {-1};
		System.out.println(Arrays.toString(solution(b, 1)));
		
	}
	
	public static int[] solution(int[] arr, int divisor) {
	      int[] answer = {-1};
	      List<Integer> list = new ArrayList<Integer>();
	      
	      for(int a : arr) {
	    	  if(a%divisor == 0)
	    		  list.add(a);
	      }
	      
	      if(list.size() == 0) {
	    	 return answer;
	      }
	      answer = new int[list.size()];
	      
	      for(int i=0; i<answer.length; i++) {
	    	  answer[i] = list.get(i);
	      }
	      Arrays.sort(answer);
	      return answer;
	  }
	
	public static int[] solution2(int[] arr, int divisor) {
		return Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
	  }

}
