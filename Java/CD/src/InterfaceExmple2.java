
public class InterfaceExmple2 {

	public static void main(String[] args) {
		Lendable [] arr = new Lendable[3];
		
		arr[0] = new SeperateVolume("883ㅇ", "푸코의 진자", "에코");
		arr[1] = new SeperateVolume("609.2", "서양미술사", "곰브리치");
		arr[2] = new AppCDinfo("02-17", "XML을 위한 자바 프로그래밍");
		
		checkOutAll(arr, "윤지혜", "20060315");
		
	
	}
	
	static void checkOutAll(Lendable arr[], String borrower, String date) {
		
		for(int i = 0; i<arr.length; i++)
			arr[i].checkOut(borrower, date);
		
	}

}
