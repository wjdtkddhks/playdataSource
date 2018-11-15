package level1;

import java.util.HashSet;
import java.util.Set;

public class Test2 {
	public static void main(String[] args) {
		String s = "ULURRDLLU";
		int x = 0;
		int y = 0;
		Set<String> set = new HashSet<String>();

		
		for(int i=0; i<s.length(); i++) {
			char a = s.charAt(i);
			switch(a) {
				case 'U' :{
					if(y!=5) {
						y++;
						set.add(""+x+""+y+"U");
						System.out.println(""+x+""+y+"U");
					}
				}
				break;
				case 'D' :{
					if(y!=-5) {
						y--;
						set.add(""+x+""+y+"D");
						System.out.println(""+x+""+y+"D");
					}
				}
				break;
				case 'R' :{
					if(x!=5) {
						x++;
						set.add(""+x+""+y+"R");
						System.out.println(""+x+""+y+"R");
					}
				}
				break;
				case 'L' :{
					if(x!=-5) {
						x--;
						set.add(""+x+""+y+"L");
						System.out.println(""+x+""+y+"L");
					}
				}
				break;
			}
		}
		
		System.out.println(set);
		System.out.println(set.size());
			
		
	}

}
