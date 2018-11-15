package Chapter13;
import java.util.*;
public class LinkedListExmple2 {

	public static void main(String[] args) {

			LinkedList<String> list = new LinkedList<String>();
			
			list.add("포도");
			list.add("딸기");
			list.add("복숭아");
			list.add(2, "사과");
			list.set(1, "가지");
			list.remove(0);
			list.remove("사과");
			
			/*for(String ab : list)
			{
				System.out.println(ab);
			}*/
			
			for(int i=0; i<list.size(); i++)
			{
				String str = list.get(i);
				System.out.println(str);
				
			}
			
			
	}

}
