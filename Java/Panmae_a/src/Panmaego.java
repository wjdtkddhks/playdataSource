import java.util.Scanner;

public class Panmaego {

	final static int MAX =100;
	
	public static void main(String[] args) {
		Panmae obj[] = new Panmae[MAX];
		int i, cnt=0, menu;
		Scanner in = new Scanner(System.in);
		
		for(i=0; i<MAX; i++)
		{
			menu_print();
			
			System.out.print("메뉴 입력(1~6) : ");
			try {
			menu = Integer.parseInt(in.next());
			System.out.println();
			}
			catch (Exception e) {
				System.out.println("1~6사이의 숫자를 입력해주세요");
				System.out.println();
				i--;
				continue;
			}
			
			if(menu == 6)
			{
				System.out.println("\n프로그램 종료!!!");
				break;
			}
			
			switch(menu) 
			{
				case 1 :
					cnt = input_panmae(obj, cnt);
					break;
				case 2 :
					output_panmae(obj, cnt);
					break;
				case 3 :
					check_panmae(obj, cnt);
					break;
				case 4 :
					change_panmae(obj, cnt);
					break;
				case 5 :
					cnt = delete_panmae(obj, cnt);
					break;
				default :
					System.out.println("1~6사이의 숫자를 입력해주세요");
					System.out.println();
			}
		}	
	}
	
	static void menu_print()
	{
		System.out.println(" *** 메뉴 ***");
		System.out.println("1. 제품정보 입력");
		System.out.println("2. 제품정보 출력");
		System.out.println("3. 제품정보 조회");
		System.out.println("4. 제품정보 수정");
		System.out.println("5. 제품정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}
	
	static int input_panmae(Panmae obj[], int cnt)
	{	
		obj[cnt]=new Panmae();
		try 
		{
		obj[cnt].input(obj, cnt);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println();
			return cnt;
		}
		obj[cnt].process();
		cnt++;
		System.out.println();
		
		return cnt;
	}
	
	static void output_panmae(Panmae obj[], int cnt)
	{
		Panmae.tot = 0;
		System.out.println("\n\t\t*** 판매 현황 ***");
		System.out.println("==========================");
		System.out.println("제품코드    제품명     수량       단가          금액");
		System.out.println("==========================");
		for(int i=0; i<cnt; i++)
		{
			obj[i].output();
			Panmae.tot += obj[cnt].price;
		}
		System.out.println("==========================");	
		System.out.printf("\t\t\t\t     총 판매액 : %d\n", Panmae.tot);
		System.out.println();
	}
	
	static void check_panmae(Panmae obj[], int cnt) 
	{
		Scanner in = new Scanner(System.in);
		System.out.print("제품코드 입력 : ");
		String code = in.next();
		
		for(int i=0; i<cnt; i++)
		{
			if(code.equals(obj[i].code))
			{
				System.out.println();
				System.out.println("==========================");
				System.out.println("제품코드    제품명     수량       단가          금액");
				System.out.println("==========================");
				obj[i].output();
				System.out.println("==========================");	
				System.out.println();
				return;
			}
		}
		System.out.println("입력하신 코드는 없습니다.");
		System.out.println();
	}
	
	static void change_panmae(Panmae obj[], int cnt)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("제품코드 입력 : ");
		String code = in.next();
		
		for(int i=0; i<cnt; i++)
		{
			if(code.equals(obj[i].code))
			{				
				System.out.print("수량 입력 : ");
				obj[i].su = in.nextInt();
				System.out.print("단가 입력 : ");
				obj[i].danga = in.nextInt();
				
				obj[i].process();
				
				System.out.println("수정되었습니다.");
				System.out.println();
				
				return;
			}
		}
		System.out.println("입력하신 코드는 없습니다.");
		System.out.println();
	}
	
	static int delete_panmae(Panmae obj[], int cnt)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("제품코드 입력 : ");
		String code = in.next();
		
		for(int i=0; i<cnt; i++)
		{
			if(code.equals(obj[i].code))
			{			
				for(int j=i; j<cnt-1; j++)
				 obj[j] = obj[j+1];
				 
				cnt--;
				System.out.println("삭제되었습니다.");
				System.out.println();
				return cnt;
			}
		}	
		System.out.println("입력하신 코드는 없습니다.");
		System.out.println();
		return cnt;
	}
}
