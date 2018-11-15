package hashAlgo;

import java.util.Arrays;
import java.util.HashMap;

public class Marathon {
	
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "mislav", "ana"};
		
		System.out.println(solution2(participant, completion));
	}
	
	public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        boolean check = true;
        
	    for(int i=0; i<completion.length; i++) {
	    	for(int j=0; j<participant.length; j++) {
	    		if(participant[j].equals(completion[i])) {
	    			participant[j] = "";
	    			check = false;
	    			break;
	    		}
	    		answer = participant[j];
	    	}
	    	
	    	if(check)
	    		return answer;	
	    }
        
	    for(String str : participant) {
	    	if(!str.equals(""))
	    		answer = str;
	    }
	    
	    return answer;
    }
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i=0; i<completion.length; i++) {
        	if(!participant[i].equals(completion[i]))
        		return participant[i];
        }
	    	    
	    return participant[i];
    }
	
}
