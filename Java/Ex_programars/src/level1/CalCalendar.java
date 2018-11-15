package level1;

public class CalCalendar {

	public static void main(String[] args) {
		System.out.println(solution(2, 1));
		System.out.println(14%7);
	}
	
	public static String solution(int a, int b) {
	      String answer = "";
	      int day = 0;
	      int[] months = {31,29,31,30,31,30,31,31,30,31,30};
	      String[] weeks = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
	      
	      for(int i=0; i<a-1; i++) {
	    	  day += months[i];
	      }
	      day += b-1;
	      
	      answer = weeks[day%7];
	      
	      return answer;
	}
}
