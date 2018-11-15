package level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {
	
	public String solution(String s) {
		String answer = "";
		
		List<String> list = Arrays.asList(s.split(""));
		Collections.sort(list, Collections.reverseOrder());
		
		for(String str : list)
			answer += str;
		
		return answer;
	}
	
	public String solution2(String s) {
		
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		
		return new StringBuffer(new String(arr)).reverse().toString();
	}

}
