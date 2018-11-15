package level1;

public class PowNum {

	public static void main(String[] args) {
		System.out.println((int)Math.sqrt(121));

	}
	
	 public static long solution(long n) {
	      long answer = 0;
	      int idx = 1;
	      
	      while(true){
	    	if(n == Math.pow(idx, 2)) {
	    		answer = (long)Math.pow(idx+1, 2);
	    		break;
	    	}
	    
	    	if(n < Math.pow(idx, 2)) {
	    		answer = -1;
	    		break;
	    	}
	    	
	    	idx++;
	      }
	      	      
	      return answer;
	  }
	 
	 public static long solution2(long n) {
		 if(Math.pow((int)Math.sqrt(n), 2) == n) {
			 return (long)Math.pow((int)Math.sqrt(n)+1, 2);
		 }
		 
		 return -1;
	 }

}
