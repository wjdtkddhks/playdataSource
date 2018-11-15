package Chapter9;


public class StringExmple2 {

	public static void main(String[] args) {

		String str1 = "자바";
		String str2 = "자바";
		
		if(str1 == str2)
			System.out.println("같음");
		else
			System.out.println("다름");
		
		if(str1.equals(str2))
			System.out.println("같음");
		else
			System.out.println("다름");
		
		String str3 = new String("Hello");
		String str4 = new String("Hello");
		
		if(str3 == str4)
			System.out.println("같음");
		else
			System.out.println("다름");
		
		if(str3.equals(str4))
			System.out.println("같음");
		else
			System.out.println("다름");

	}

}
