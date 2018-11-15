package kakao_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class stageNum {
	
	public static void main(String[] args) {
		int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] stages2 = {4,4,4,4,4};
		
		solution(5, stages1);
		solution(4, stages2);
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = {};
        ArrayList<Integer> stageNum = new ArrayList<Integer>();
        ArrayList<Double> values = new ArrayList<Double>();
        HashMap<Integer, Double> probs = new HashMap<Integer, Double>();
        
        for(Integer a : stages) {
        	stageNum.add(a);
        }
        Collections.sort(stageNum);
       
        for(int i=1; i<=N; i++) {
        	int check = 0;
        	double size = stageNum.size();
        	if(size == 0) {
        		probs.put(N, 0.0);
        	}else {
        		for(int j=0; j<stageNum.size(); j++) {
            		if(i == stageNum.get(j).intValue()) {
            			stageNum.remove(j);
            			if(j>=0) {j--;}
            			check++;
            		}
            	}
        		if(check == 0) {
            		probs.put(i, 0.0);
            	}else {
            		probs.put(i, (check/size));
            	}
        	}
        }
        
        values.addAll(probs.values());
        Collections.sort(values);
        Collections.reverse(values);
        answer = new int[N];
        int index = 0;
        for(int j=0; j<values.size(); j++) {
        	for(int i=1; i<=N; i++) {
        		if(probs.containsKey(i)) {
	        		if(values.get(j) == probs.get(i).doubleValue()) {
	        			answer[index] = i;
	        			probs.remove(i);
	        			break;
	        		}
        		}
        	}
        	index++;
        }
        
        for(int a: answer) {
        	System.out.print(a + " ");
        }
        System.out.println();
        return answer;
    }

}
