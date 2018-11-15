package Chapter4;

public class BitExmple1 {

	public static void main(String[] args) {
		Byte a = 3, b= 5;
		int c;
		
		c=(byte)(a & b);
		System.out.println(c);
		c=(byte)(a | b);
		System.out.println(c);
		c=(byte)(a ^ b);
		System.out.println(c);
		c=(byte)(~a);
		System.out.println(c);

		System.out.println(a&b);
		System.out.println(a|b);
		System.out.println(a^b);
		System.out.println(~a);
	}

}
