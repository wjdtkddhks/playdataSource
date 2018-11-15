package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
•시험은 최대 10,000 문제로 구성되어있습니다.
•문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
•가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요*/

public class ForgiveMath {

	public static void main(String[] args) {
		int[] c = {1,2,3,4,5};
		solution(c);

	}
	
	public static int[] solution(int[] answers) {
        int[] answer = {};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int count = 0;
       	
        for(int i=0; i<answers.length; i++) {
        	if(answers[i] == a[i%a.length]) {
            		count++;
           }
        }
     
        map.put(1, count);
        count=0;
        
        for(int i=0; i<answers.length; i++) {
        	if(answers[i] == b[i%b.length]) {
        		count++;
        	}
        }
        map.put(2, count);
        count=0;
        
        for(int i=0; i<answers.length; i++) {
        	if(answers[i] == c[i%c.length]) {
        		count++;
        	}
        }
        map.put(3, count);
        int max = Collections.max(map.values());
        
        for(int i=1; i<=3; i++) {
			if(map.get(i) != max) {
				map.remove(i);
			}
		}
		answer = new int[map.size()];
		count = 0;
		for(int idx : map.keySet()) {
			answer[count++] = idx;
		}
		
		return answer;
    }
	
	public static int[] solution2(int[] answers) {
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int[] sum = new int[3];
       	
       for(int i=0; i<answers.length; i++) {
    	   if(answers[i] == a[i%a.length]) sum[0]++;
    	   if(answers[i] == b[i%b.length]) sum[1]++;
    	   if(answers[i] == c[i%c.length]) sum[2]++;
       }
        
       int max = Math.max(sum[0], Math.max(sum[1], sum[2]));
		
       List<Integer> list = new ArrayList<Integer>();
       
       if(sum[0] == max) list.add(1);
       if(sum[1] == max) list.add(2);
       if(sum[2] == max) list.add(3);
		
       return list.stream().mapToInt(i -> i.intValue()).toArray();
    }
}
