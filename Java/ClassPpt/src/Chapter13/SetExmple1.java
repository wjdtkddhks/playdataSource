package Chapter13;
import java.util.*;
public class SetExmple1 {

	public static void main(String[] args) {
			
		HashSet<String> set = new HashSet<String>();
		
		set.add("자바");
		set.add("헬로우");
		set.add("바보");
		set.add("헬로우");
		System.out.println(set.size());
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) 
			System.out.println(iterator.next());

		for(String ab : set)
			System.out.println(ab);
	}

}
