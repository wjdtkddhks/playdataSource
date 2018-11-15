import java.util.Scanner;

public class PersonInfo extends Person implements Personable {
	
	String phone, addr;
	
	public boolean input() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("학번입력 : ");
		hakbun = in.next();
			if(hakbun.toLowerCase().equals("exit"))
				return true;
		System.out.print("이름입력 : ");
		irum = in.next();
		System.out.print("전화번호입력 : ");
		phone = in.next();
		System.out.print("주소입력 : ");
		addr = in.next();
		System.out.println();
		
		return false;
	}
	
	public void output() {
		
		System.out.printf(" %4s    %3s    %12s   %3s\n", hakbun, irum, phone, addr);
		
	}
	
		
}