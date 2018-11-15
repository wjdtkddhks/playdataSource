package level1;

import java.util.Arrays;

public class CommonTest {
	
	public static void main(String[] args) {
		int[] x= {1,3,2,5,4};
		int sum = 0, count=0;
		int budget = 9;
		Arrays.sort(x);
		for(int i=0; i<x.length; i++) {
			sum += x[i];
			if(budget < sum) {
				break;
			}
			count++;
		}
		System.out.println(count);
	      
	}
}
