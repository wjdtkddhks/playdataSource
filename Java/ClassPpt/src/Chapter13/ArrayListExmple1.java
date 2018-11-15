package Chapter13;
import java.util.*;
public class ArrayListExmple1 {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");

		int num = list.size();
		
		for(int i=0; i<num; i++)
		{
			String str = list.get(i);
			System.out.print(str.toString());
		}
		System.out.println();
		
		for(String str : list)
			System.out.print(str);
		System.out.println();
		
		list.add(2, "키위");
		for(String str: list)
			System.out.print(str);
		
		list.set(0, "오렌지");
		System.out.println();
		for(String str : list)
			System.out.print(str);
		
		list.remove(1);
		System.out.println();
		for(String str : list)
			System.out.print(str);
		
		list.remove("딸기");
		System.out.println();
		for(String str : list)
			System.out.print(str);
		
		list.add("키위");
		System.out.println();
		for(String str : list)
			System.out.print(str);
		
		list.remove("키위");
		System.out.println();
		for(String str : list)
			System.out.print(str);
		System.out.println();
		String abc = list.get(0);
		System.out.println(abc);
		
	}

}
