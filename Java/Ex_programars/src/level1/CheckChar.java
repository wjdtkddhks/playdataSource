package level1;

/*문자열 s의 길이가 4혹은 6이고, 숫자로만 구성되있는지 확인해주는 함수, solution을 완성하세요.
예를들어 s가 “a234”이면 False를 리턴하고 “1234”라면 True를 리턴하면 됩니다.

제한 사항
•s는 길이 1 이상, 길이 8 이하인 문자열입니다.*/


public class CheckChar {

	public static void main(String[] args) {
		String s = "a234";
		System.out.println(solution(s));

	}
	
	 public static boolean solution(String s) {
	      boolean answer = true;
	      if(!(s.length() == 4 || s.length() == 6)) {
	    	  return false;
	      }
	      try {
	    	  Integer.parseInt(s);
	      }catch(Exception e){
	    	  return false;
	      }
	      
	      return answer;
	 }
	 
	 public boolean solution2(String s) {
	        if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
	        return false;
	  }

}
