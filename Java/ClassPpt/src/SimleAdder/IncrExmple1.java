package SimleAdder;

public class IncrExmple1 {

	public static void main(String[] args) {
		int num =0;
		int res;
		
		res = num ++;
		System.out.println("num=" + num + " , ");
		System.out.println("res=" + res);
		System.out.println(res + num);
		res = ++num;
		System.out.println("num=" + num + " , ");
		System.out.println("res=" + res);
		res = num --;
		System.out.println("num=" + num + " , ");
		System.out.println("res=" + res);
		res =--num;
		System.out.println("num=" + num + " , ");
		System.out.println("res=" + res);
		System.out.println(res + num);
	}

}
