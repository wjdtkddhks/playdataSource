package kakao_test;

import java.util.ArrayList;
import java.util.HashMap;

public class Chatadmin {
	
	public static void main(String[] args) {
		String[] str = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		String[] answer = solution(str);
		for(String ans : answer) {
			System.out.print(ans);
		}
	
	}
	
	public static String[] solution(String[] record) {
        String[] answer = {};
	    ArrayList<String> atten = new ArrayList<String>();
	    HashMap<String, String> nicknames = new HashMap<String, String>();
	    
	    for(String str : record) {
	    	String[] records = str.split(" ");
		    if(records[0].equals("Enter")){
		        atten.add("Enter "+ records[1]);
		        if(!nicknames.containsKey(records[1])){
		            nicknames.put(records[1], records[2]);
		        }else {
		        	nicknames.replace(records[1], records[2]);
		        }
		    }else if(records[0].equals("Leave")){
		        atten.add("Leave " + records[1]);
		    }else if(records[0].equals("Change")){
		        nicknames.replace(records[1], records[2]);
		    }
	    }
	    for(String str : atten) {
	    	System.out.println(str);
	    }
	    for ( String key : nicknames.keySet() ) {
	        System.out.println("방법1) key : " + key +" / value : " + nicknames.get(key));
	    }
	    int index = 0;
	    answer = new String[atten.size()];
	    for(String str : atten) {
	    	String [] strs = str.split(" ");
	    	if(strs[0].equals("Enter")) {
	    		answer[index] = nicknames.get(strs[1]) + "님이 들어왔습니다.";
	    	}else if(strs[0].equals("Leave")) {
	    		answer[index] = nicknames.get(strs[1]) + "님이 나갔습니다.";
	    	}
	    	index++;
	    }
	    
	    return answer;
	}
	
}
