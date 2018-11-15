package level1;

public class CenterPick {
	
	public static void main(String[] args) {
		System.out.println(solution2("qwer"));
	}
	
	public static String solution(String s) {
	      String answer = "";
	      int lns = s.length();
	      
	      if(lns%2 == 0) {
	    	  answer = s.substring(lns/2-1, lns/2+1);
	      }else {
	    	  answer = s.substring(lns/2, lns/2+1);
	      }
	      
	      return answer;
	}
	
	public static String solution2(String s) {
	      String answer = "";
	      int lns = s.length();
	      
	      answer = s.substring((lns-1)/2, (lns/2)+1);
	      
	      return answer;
	}

}
