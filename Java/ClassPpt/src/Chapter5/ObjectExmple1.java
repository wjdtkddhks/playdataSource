package Chapter5;

public class ObjectExmple1 {

	public static void main(String[] args) {
		StringBuffer obj = new StringBuffer("Hey, java");
		//obj 
		
		obj.deleteCharAt(1);
		obj.deleteCharAt(1);
		obj.insert(1, 'i');
		System.out.println(obj);
		
		obj.insert(4, "Good ");
		System.out.println(obj);

	}

}
