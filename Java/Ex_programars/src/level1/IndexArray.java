package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
예를 들어 strings가 [“sun”, “bed”, “car”]이고 n이 1이면 각 단어의 인덱스 1의 문자 “u”, “e”, “a”로 strings를 정렬합니다.
•strings는 길이 1 이상, 50이하인 배열입니다.
•strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
•strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
•모든 strings의 원소의 길이는 n보다 큽니다.
•인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.*/


public class IndexArray {

		public static void main(String[] args) {
			String[] b= {"sun", "bed", "car"};
			String[] c= {"abce", "abcd", "cdx"};
			System.out.println(Arrays.toString(solution3(b,1)));
		}
		
		public static String[] solution(String[] strings, int n) {
		      String[] answer = new String[strings.length];
		      String[] temp = new String[strings.length];
		      int count =0;
		      
		      for(String str : strings) {
		    	  temp[count++] = str.substring(n, n+1);
		      }
		      
		      Arrays.sort(temp);
		      Arrays.sort(strings);

		      count =0;
		      for(String str : temp) {
		    	  for(int i=0; i<strings.length; i++) {
		    		  if(strings[i].equals("0")) {
		    			  continue;
		    		  }
		    		  if(strings[i].substring(n, n+1).equals(str)) {
		    			  answer[count++] = strings[i];
		    			  strings[i] = "0";
		    			  continue;
		    		  }
		    	  } 
		      }
		      
		      return answer;
		}
		public static String[] solution2(String[] strings, int n) {
		      String[] answer = new String[strings.length];
		     
		      List<String> list  = new ArrayList<String>();
		      
		      for(String str : strings) {
		    	  list.add("" + str.charAt(n) + str);
		      }
		      
		      Collections.sort(list);
		      
		      for(int i=0; i<list.size(); i++) {
		    	  answer[i] = list.get(i).substring(1);
		      }
		      
		      return answer;
		}
		
		public static String[] solution3(String[] strings, int n) {
		     
		      List<String> list  = Arrays.asList(strings);
		      
		      list.sort((a, b) ->{
		    	  int result = a.split("")[n].compareTo(b.split("")[n]);
		    	  if(result == 0) {
		    		  return a.compareTo(b);
		    	  }
		    	  return result;
		      });
		      
		      return list.toArray(new String[0]);
		}
}
