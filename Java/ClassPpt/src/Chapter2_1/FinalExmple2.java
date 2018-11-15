package Chapter2_1;

public class FinalExmple2 {

	public static void main(String[] args) {
		final double pi;
		double radius  = 2.0;
		pi = 3.14;
		double circum = 2 * pi * radius;
		System.out.println(circum);
		//pi = 3.14159;
		double area = pi * radius *radius;
		System.out.println(area);
				

	}

}
