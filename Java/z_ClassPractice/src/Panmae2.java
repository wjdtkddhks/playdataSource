import java.util.Scanner;

public class Panmae2 {
	
	final static int MAX = 3;

	public static void main(String[] args) {
		int [][] pan = new int [MAX][3];
		int i,k,t;
		int tot =0;
		String [][] pro = new String[MAX][2];
		
		Scanner bb = new Scanner(System.in);
		
		
		for(i=0; i<MAX; i++)
		{
			System.out.print("제품 코드 : ");
			 pro[i][0] = bb.next();
			System.out.print("제품명 : ");
		     pro[i][1] = bb.next();
			System.out.print("수량 : ");
			 pan[i][0] = bb.nextInt();
			System.out.print("단가 : ");
			 pan[i][1] = bb.nextInt();
					
			 pan[i][2] = (pan[i][0])*(pan[i][1]);		
			 tot += pan[i][2];
			 System.out.println();
	   	}
		
		System.out.println();
		System.out.println();
		
		System.out.println("\t\t   *** 판매현황 ***");
		System.out.println("=============================");
		System.out.println("제품코드\t  제품명\t   수량\t단가\t금액");
		System.out.println("=============================");
		
		
		for(i=0; i<MAX; i++)
		{
			for(k=0; k<2; k++)
				{System.out.printf("%4s\t ", pro[i][k]);}
		
			for(t=0; t<3; t++)
				{System.out.printf("%2d\t", pan[i][t]);}
			
			System.out.println();
		}
		
		System.out.println("=============================");
	
		
		System.out.printf("                                            총판매액 : %d", tot);
	}
		
}