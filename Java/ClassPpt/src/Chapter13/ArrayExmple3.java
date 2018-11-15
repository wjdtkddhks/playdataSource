package Chapter13;
import java.util.*;
public class ArrayExmple3 {

	public static void main(String[] args) {

			ArrayList<String> list = new ArrayList<String>();
			
			list.add("머루");
			list.add("사과");
			list.add("앵두");
			list.add("자두");
			list.add("사과");
			
			int index1 = list.indexOf("사과");
			int index2 = list.lastIndexOf("사과");
			int index3 = list.indexOf("마늘");
			
			System.out.println(index1);
			System.out.println(index2);
			System.out.println(index3);
	}

}
