package Chapter12;

public class WrapperExmple5 {

	public static void main(String[] args) {

		Integer obj = Integer.valueOf(50);
		int sum = obj + 12;
		System.out.println(sum);
		
		printDouble(Double.valueOf("123.12"));
		printDouble(123.12);
		

	}
	static void printDouble(Double obj) {
			
			System.out.println(obj);
	}

}
