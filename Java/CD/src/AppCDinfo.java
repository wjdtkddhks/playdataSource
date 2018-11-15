
class AppCDinfo extends CDinfo implements Lendable {
	
	String checkOutDate;
	String borrower;
	byte state;
	
	AppCDinfo(String registerNo, String title){
		
		super(registerNo, title);
	}
	
	public void checkOut(String borrower, String date) {
		if(state != 0)
			return;
		
		this.borrower = borrower;
		this.checkOutDate = date;
		state = 1;
		System.out.println("*" + title + "이(가) 대출되었습니다.");
		System.out.println("대출인 : " + borrower);
		System.out.println("반납일 : " + date + "\n");
	}
	
	public void checkIn() {
	
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0;
		System.out.println("*" + title + "이 반납되었습니다.\n");

	}
	

}
