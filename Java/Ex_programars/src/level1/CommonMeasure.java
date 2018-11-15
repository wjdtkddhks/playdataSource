package level1;

import java.util.Arrays;

public class CommonMeasure {

	public static void main(String[] args) {
		int[] answer = {};
		int n = 2;
		int m = 5;
		int max=0, min = 0, div=0;
		
		if(m>n) {
			max = m;
			min = n;
		}else if(m<n) {
			max = n;
			min = m;
		}else {
			answer = new int[] {m, n};
		}
		
		while(true) {
			if(max%min == 0) {
				div = min;
				break;
			}
			div = min;
			min = max%min;
			max = div;
		}
		
		answer = new int[] {div, (n/div)*m};
		
		System.out.println(Arrays.toString(answer));
		

	}
	 public int[] gcdlcm(int a, int b) {
	        int[] answer = new int[2];

	          answer[0] = gcd(a,b);
	        answer[1] = (a*b)/answer[0];
	        return answer;
	    }

	   public static int gcd(int p, int q)
	   {
	    if (q == 0) return p;
	    return gcd(q, p%q);
	   }


}
