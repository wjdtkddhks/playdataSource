import java.util.Scanner;

public class Panmae {
	
	String code, irum;
	int su, danga, price;
	static int tot;
	
	Panmae(){}
	
	boolean input(Panmae obj[], int cnt)
	{
		Scanner in = new Scanner(System.in);
	
		System.out.print("제품코드 입력 : ");
		this.code= in.next();
			for(int i=0; i<cnt; i++)
			{
			if(this.code.equals(obj[i].code))
					return true;
			}
		System.out.print("제품명 입력 : ");
		this.irum = in.next();
		System.out.print("수량 입력 : ");
		this.su = in.nextInt();
		System.out.print("단가 입력 : ");
		this.danga = in.nextInt();
		return false;
	}
	
	void process()
	{
		this.price = su*danga;
	}
	
	void output()
	{	
		System.out.printf("%4s     %3s      %2d      %4d   %6d\n", code, irum, su, danga, price);	
	}
	
}
