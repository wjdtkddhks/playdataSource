package Chapter13;
import java.util.*;
public class StackExmple1 {

	public static void main(String[] args) {
		
			LinkedList<Integer> stack = new LinkedList<Integer>();
			
			stack.addLast(new Integer(12));
			stack.addLast(new Integer(24));
			stack.addLast(new Integer(59));
			
			while(!stack.isEmpty()) {
				int num = stack.removeLast();
				System.out.println(num);
					
			}
	}

}
