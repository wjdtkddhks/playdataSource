
public class Panmaego {

	final static int MAX =100;
	
	public static void main(String[] args) {
		Panmae obj[] = new Panmae[MAX];
		int cnt;
		
		cnt = input_panmae(obj);
		output_panmae(obj, cnt);
			
	}
	
	static int input_panmae(Panmae obj[])
	{	
		int i, cnt=0;
		
		for(i=0; i<MAX; i++)
		{
			obj[i]=new Panmae();
			if(obj[i].input())
				break;
			obj[i].process();
			//Panmae.tot = obj[i].price;
			cnt++;
			System.out.println();
		}
		return cnt;
	}
	
	static void output_panmae(Panmae obj[], int cnt)
	{
		int i;
		
		System.out.println("\n\t\t*** 판매 현황 ***");
		System.out.println("==========================");
		System.out.println("제품코드    제품명     수량       단가          금액");
		System.out.println("==========================");
		for(i=0; i<cnt; i++)
		obj[i].output();
		System.out.println("==========================");	
		System.out.printf("\t\t\t     총 판매액 : %d\n", Panmae.tot);
	}

}
