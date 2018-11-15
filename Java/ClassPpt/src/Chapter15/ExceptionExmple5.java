package Chapter15;

public class ExceptionExmple5 {
	
	public static void main(String[] args) {

		int num1=2;
		int num2=0;
		
		try {
			int result = num1/ num2;
			System.out.println(result);
		}
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
}
