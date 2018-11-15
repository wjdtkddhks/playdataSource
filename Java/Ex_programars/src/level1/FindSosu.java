package level1;

/*1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요. 

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 (1은 소수가 아닙니다.)

제한 조건
•n은 2이상 1000000이하의 자연수입니다.*/

public class FindSosu {

	public static void main(String[] args) {
		solution2(5);

	}
	
	public static int solution(int n) {
	      int answer = 0;
	      
	      ab:
	      for(int i=2; i<=n; i++){
	          for(int j=2; j<i; j++){
	              if(i%j == 0)
	                  continue ab;
	          }
	          answer++;
	      }
	      return answer;
	  }
	
	public static int solution2(int n) {
	      int answer = 0;
	      
	      ab:
	      for(int i=2; i<=n; i++){
	          for(int j=2; j<=i/2; j++){
	              if(i%j == 0)
	                  continue ab;
	          }
	          System.out.println(i);
	      }
	      return answer;
	  }

}
