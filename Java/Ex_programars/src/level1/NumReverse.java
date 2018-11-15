package level1;

import java.util.Arrays;
import java.util.Comparator;

public class NumReverse {
	String res = "";
	public static void main(String[] args) {
		long a = 118372;
		String str = "";
		
		String[] b = (a+"").split("");
		Arrays.sort(b, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return Integer.parseInt(b)- Integer.parseInt(a);
			}
		});
		
		for(String z : b) {
			str += z;
		}

		System.out.println(str);
		System.out.println(Long.parseLong(str));

	}
	public int solution(int n) {
		res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
        return Integer.parseInt(res);
	}


}
