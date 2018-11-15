package level2;

public class Country124 {

	public static void main(String[] args) {
		System.out.println(solution(3));
	}
	
	public static String solution(int n) {
	     String answer = ""; 
		 int k = 0;
	      
	      while(n>0) {
	    	  k = n%3;
	    	  n = n/3;
	    	  
	    	  if(k == 0) {
	    		  n = n-1;
	    		  k = 4;
	    	  }
	    	  answer += k;
	      }
	      
	      return answer;
	  }

}
