import java.util.Scanner;

public class Panmae_t {
	
	final static int MAX =100;

	public static void main(String[] args) {
		String code[] = new String[MAX];
		String irum[] = new String[MAX];
		int su[] = new int[MAX];
		int danga[] = new int[MAX];
		int price[] = new int[MAX];
		int i, total =0, cnt = 0;
		
		Scanner bb = new Scanner(System.in);
		
		
		for(i=0; i<MAX; i++)
		{
			System.out.print("제품 코드 : ");
			 code[i] = bb.next();
			 if(code[i].equals("exit"))
				 break;
			System.out.print("제품명 : ");
		     irum[i] = bb.next();
			System.out.print("수량 : ");
			 su[i] = bb.nextInt();
			System.out.print("단가 : ");
			 danga[i] = bb.nextInt(); 
					
			price[i] = su[i] * danga[i];		
			 total += price[i];
			 cnt++;
			 System.out.println();
	   	}
		
		System.out.println();
		System.out.println();
		
		System.out.println("\t\t   *** 판매현황 ***");
		System.out.println("=============================");
		System.out.println("제품코드    제품명    수량        단가         금액");
		System.out.println("=============================");
		
		
		for(i=0; i<cnt; i++)
		{
			System.out.printf("%6s    %3s    %3d    %6d    %8d \n", code[i], irum[i], su[i], danga[i], price[i]);
		}
		
		System.out.println("=============================");
	
		
		System.out.printf("                                            총판매액 : %d", total);
	}
		
}