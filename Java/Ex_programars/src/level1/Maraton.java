package level1;
import java.util.Arrays;

public class Maraton {
	public static void maint(String[] args) {
		
	}
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<participant.length; i++) {
        	if(i == participant.length-1) {
        		answer = participant[i];
        		break;
        	}
        	if(participant[i].equals(completion[i])) {
        		continue;
        	}else {
        		answer = participant[i];
        		break;
        	}
        }
	    
	    return answer;
    }

}
