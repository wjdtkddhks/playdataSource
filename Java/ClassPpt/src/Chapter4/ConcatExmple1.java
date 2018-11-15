package Chapter4;

public class ConcatExmple1 {

	public static void main(String[] args) {
		String str1 = "num" + 3 + 4;
		String str2 = 3 + 4 + "num";
		
		System.out.println(str1);
		System.out.println(str2);
		
		short num1 = 10;
		short num2 = (short)-num1;
		
		System.out.println(num2);
	}

}
