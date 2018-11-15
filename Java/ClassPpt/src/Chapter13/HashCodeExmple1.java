package Chapter13;
import java.util.HashMap;

public class HashCodeExmple1 {

	public static void main(String[] args) {
				HashMap<Name, Integer> hashmap = new HashMap<Name, Integer>();
					
				Name obj = new Name("헤르미온느", "그레인저");
				Name obj2 = new Name("헤르미온느", "그레인저");
				
				hashmap.put(obj, Integer.valueOf("12"));
				hashmap.put(obj2, Integer.valueOf("45"));
				hashmap.put(new Name("론", "위즐리"), Integer.valueOf("40"));
				
				hashmap.put(new Name("론", "위즐리"), Integer.valueOf("40"));
				hashmap.put(new Name("해리", "포터"), Integer.valueOf("56"));
				hashmap.put(new Name("안녕", "자바"), Integer.valueOf("24"));
					
				Integer num = hashmap.get(obj);
				System.out.println(num);
				System.out.println(hashmap.get(obj2));
				
				Integer num2 = hashmap.get(new Name("헤르미온느", "그레인저"));
				System.out.println(num2);
					
					



	}

}
