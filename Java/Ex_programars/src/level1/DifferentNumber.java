package level1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferentNumber {

	public static void main(String[] args) {
		int[] b = {1, 1, 3, 3, 0, 1, 1};
		
		System.out.println(Arrays.toString(solution(b)));

	}

	public static int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<Integer>();
        int b= -1;
        for(int a : arr) {
        	if(a != b) {
        		list.add(a);
        	}
        	b=a;
        }
        b=0;
        answer = new int[list.size()];
        for(int a : list) {
        	answer[b] = a;
        	b++;
        }

        return answer;
	}
}
