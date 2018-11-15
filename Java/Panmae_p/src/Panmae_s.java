import java.util.Scanner;

public class Panmae_s {
	
	String code[] = new String[MAX];
	String irum[] = new String[MAX];
	int su[] = new int[MAX];
	int danga[] = new int[MAX];
	int price[] = new int[MAX];
	int cnt, tot;
	final static int MAX = 100;
	
	Panmae_s(){}
	
	void input()
	{
		Scanner in = new Scanner(System.in);
		int cnt=0;	
		
		for(int i=0; i<MAX; i++)
		{
		System.out.print("제품코드 입력 : ");
		this.code[i] = in.next();
		if(code[i].equals("exit"))
				break;
		System.out.print("제품명 입력 : ");
		this.irum[i] = in.next();
		System.out.print("수량 입력 : ");
		this.su[i] = in.nextInt();
		System.out.print("단가 입력 : ");
		this.danga[i] = in.nextInt();
		System.out.println();
		cnt++;
		}
		this.cnt = cnt;
	}
	
	void process()
	{
		for(int i=0; i<cnt; i++)
		 this.price[i] = su[i]*danga[i];				
	}
	
	void output()
	{	tot=0;
		for(int i=0; i<cnt; i++)
		{
			tot += price[i];
		System.out.printf("%4s     %3s      %2d      %4d   %6d\n", code[i], irum[i], su[i], danga[i], price[i]);	
		}
		System.out.println("=========================");		
		System.out.printf("\t\t\t    총 금액 : %d\n", tot);	
	}
	
}
