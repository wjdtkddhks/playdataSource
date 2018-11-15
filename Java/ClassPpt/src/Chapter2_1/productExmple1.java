package Chapter2_1;
import java.util.Scanner;

public class productExmple1 {

	public static void main(String[] args) {
			
		String code;
		String pro;
		int num;
		int dan, gum;
		
		Scanner in  = new Scanner(System.in);
		
		System.out.println("제품코드를 입력하세요 : ");
		code = in.next();
		System.out.println("제품명을 입력하세요 : ");
		pro = in.next();
		System.out.println("수량을 입력하세요 : ");
		num = in.nextInt();
		System.out.println("단가를 입력하세요 : ");
		dan = in.nextInt();
		
		gum = num * dan;
		
		System.out.println("\n\t\t\t*** 판매현황 ***");
		System.out.println("===========================");
		System.out.println("제품코드     제품명    수량    단가    금액");
		System.out.printf("%4s %3s %3d %8d %10d\n", code, pro, num, dan, gum);
		System.out.println("===========================");
		
	}

}
