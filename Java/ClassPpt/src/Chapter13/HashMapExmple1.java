package Chapter13;
import java.util.*;
public class HashMapExmple1 {

	public static void main(String[] args) {
			HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
			
			hashmap.put("헤르미온느", Integer.valueOf("12"));
			hashmap.put("론", Integer.valueOf("12"));
			hashmap.put("해리", Integer.valueOf("12"));
			hashmap.put("해리", Integer.valueOf("24"));
			
			Integer num = hashmap.get("해리");
			System.out.println(num);
			
			

	}

}
