package Chapter2_2;


public class MethodExmple2 {

	public static void main(String[] args) {
		int result;
		result = add(8,9);
		add(8,9);
		System.out.println(result);
		
	}
	static int add(int a, int b) {
		
		int sum;
		sum = a+b;
		System.out.println(sum);
		
		return sum;
		
	
	}

	}


