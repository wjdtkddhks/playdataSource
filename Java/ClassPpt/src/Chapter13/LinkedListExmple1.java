package Chapter13;
import java.util.*;
public class LinkedListExmple1 {

	public static void main(String[] args) {
			
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		
	}

}
