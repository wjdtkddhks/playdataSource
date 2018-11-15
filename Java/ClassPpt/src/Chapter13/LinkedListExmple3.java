package Chapter13;
import java.util.*;
public class LinkedListExmple3 {

	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("망고");
		list.add("포도");
		list.add("딸기");
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);	
		}
		
		for(String str : list) {
			System.out.println(str);
		}
		
		
	}

}
