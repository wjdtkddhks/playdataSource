import java.util.ArrayList;
import java.util.Collections;

public class test {
	public static void main(String[] args) {
		String[] str = {"21", "113", "12340", "123440", "12345", "98346"};
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(String ss : str) {
			list.add(Integer.parseInt(ss));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			str[i] = String.valueOf(list.get(i));
		}
		
		for(String ss: str) {
			System.out.println(ss);
		}
		
	}
	
}
