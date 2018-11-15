import java.util.Scanner;

public class PanmaeEx02 {
	
	final static int MAX = 100;
	
	public static void main(String[] args) 
	{
		String code[] = new String[MAX];
		String irum[] = new String[MAX];
		int su[] = new int[MAX];
		int danga[] = new int[MAX];
		int price[] = new int[MAX];
		int cnt = 0;
		
		cnt = inputcode(code, irum, su, danga, price);
		outputcode(code, irum, su, danga, price, cnt);
		
	}	
	
	static int inputcode(String code[], String irum[], int su[], int danga[], int price[])
	{	
		int i, cnt=0;			
		Scanner in = new Scanner(System.in);
						
		for (i=0; i<MAX; i++)
		{		
			System.out.print("제품코드 입력 => ");
			code[i] = in.next();
			if (code[i].equals("exit"))
				break;
			
			System.out.print("제품명 입력 => ");
			irum[i] = in.next();
			System.out.print("수량 입력 => ");
			su[i] = in.nextInt();
			System.out.print("단가 입력 => ");
			danga[i] = in.nextInt();
			price[i] = su[i] * danga[i];
			System.out.println();
			
			cnt++;
		}
		return cnt;
	}
						
	static void outputcode(String code[], String irum[], int su[], int danga[], int price[], int cnt)
	{
		int i, total=0;
			
		System.out.println("\n\t       *** 판매 현황 ***");
		System.out.println("============================================");
		System.out.println("제품코드        제품명          수량               단가                금액");
		System.out.println("============================================");
		for (i=0; i<cnt; i++)
		{ total += price[i];
			System.out.printf("%4s      %3s        %4d    %6d   %9d\n",
				code[i], irum[i], su[i], danga[i], price[i]);
		}
		System.out.println("============================================");
		System.out.printf("\t\t\t  총액  : %d\n", total);
		
	}
}