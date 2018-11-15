
public class InterfaceExmple1 {

	public static void main(String[] args) {
		SeperateVolume obj1 = new SeperateVolume("863ㅂ744개", "개미", "베르베르");
		AppCDinfo obj2 = new AppCDinfo("2005-7001", "Redhat Fedora");

		
		/*obj1.checkOut("김영숙", "20060315");
		obj2.checkOut("박희경", "20060317");
		obj1.checkIn();
		obj2.checkIn();*/
		
		checkOutData(obj1, "김영숙", "20060315");
		checkOutData(obj2, "박희경", "20060317");
		checkInData(obj1);
		checkInData(obj2);
		
	}
	
	static void checkOutData(Lendable obj, String borrower, String date) {
		
		obj.checkOut(borrower, date);
		
	}
	
	static void checkInData(Lendable obj) {
		
		obj.checkIn();
		
	}

}
