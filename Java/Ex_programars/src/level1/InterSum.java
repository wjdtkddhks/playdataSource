package level1;
/*두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요. 
예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.

제한 조건
•a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
•a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
•a와 b의 대소관계는 정해져있지 않습니다.*/

public class InterSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static long solution(int a, int b) {
	      long answer = 0;
	      int max, min =0;
	      
	      if(a > b) {
	    	  max = a;
	    	  min = b;
	      }else if(a < b) {
	    	  max = b;
	    	  min = a;
	      }else {
	    	  return a;
	      }
	      
	      //max = (a > b) ? a : b;
	      //min = (a > b) ? b : a;
	      
	      for(; min<=max; min++) {
	    	  answer += min;
	      }
	      
	      return answer;
	  }
	
	 	public long solution2(int a, int b) {
	        return sumAtoB(Math.min(a, b), Math.max(b, a));
	    }

	    private long sumAtoB(long a, long b) {
	        return (b - a + 1) * (a + b) / 2;
	    }

}
