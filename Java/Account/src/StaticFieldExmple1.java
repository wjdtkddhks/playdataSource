
public class StaticFieldExmple1 {

	public static void main(String[] args) {
		System.out.println("grandtotal : " + Accumulator.grandtotal);
		Accumulator.grandtotal = 1000;
		System.out.println("grandtotal : " + Accumulator.grandtotal);
		
		int grand = Accumulator.getgradtotal();
		System.out.println(grand);
		
		Accumulator obj1 = new Accumulator();
		Accumulator obj2 = new Accumulator();
		
		obj1.accumulate(10);
		obj2.accumulate(20);
		
		System.out.println("1 total : " + obj1.total);
		System.out.println("1 grandtotal : " + obj1.grandtotal);
		System.out.println("2 total : " + obj2.total);
		System.out.println("2 grandtotal : " + Accumulator.grandtotal);
		
	}

}
