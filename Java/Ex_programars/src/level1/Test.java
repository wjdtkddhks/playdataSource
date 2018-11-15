package level1;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
		String str = "CBD";
		String[] array = {"BACDE", "CBADF", "AECB", "BDA"};
		int count = 0;
		
		ab:
		for(String s : array) {
			String str2 = "";
			for(int i=0; i<s.length(); i++) {
				if(str.contains(s.substring(i, i+1))) {
					str2 += s.substring(i, i+1);
				}
			}
			System.out.println(str2);
			if(str2.equals("")) {
				count++;
				continue;
			}
			
			for(int i=0; i<str2.length(); i++) {
				if(!(str.charAt(i) == str2.charAt(i))) {
					continue ab;
				}
			}
			count++;
		}
		
		System.out.println("last :" +count);
		
		
	}

}
