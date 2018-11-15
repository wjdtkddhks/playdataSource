package method;
import java.util.Scanner;

public class SungjukEx03 
{
	final static int MAX = 100;
	
public static void main(String[] args) 
{
		Sungjuk sun[] = new Sungjuk[MAX];
		int menu=0, cnt=0;		
		Scanner as = new Scanner(System.in);
		
		
		for(int i=0; i<MAX; i++)
		{
			menu_sungjuk();
			
			System.out.print("메뉴입력(1~6) : ");
			try 
			{
				menu = Integer.parseInt(as.next());
				System.out.println();
			}
			catch(Exception e)
			{
				System.out.println("1~6사이의 수를 입력해주세요.");
				System.out.println();
				i--;
				continue;
			}
		
				if(menu == 6)
				{
					System.out.println("프로그램이 종료됩니다.");
					break;
				}
			
				switch(menu) 
				{
					case 1 :
						cnt = input_sungjuk(sun, cnt);
						break;
					case 2 :
						output_sungjuk(sun, cnt);
						break;
					case 3 :
						search_sungjuk(sun, cnt);
						break;
					case 4 :
						change_sungjuk(sun, cnt);
						break;
					case 5 :
						cnt=delete_sungjuk(sun, cnt);
						break;
					default :
						System.out.println("1~6사이의 수를 입력해주세요.");
						System.out.println();
				}
		}		
}
	
	static void menu_sungjuk()
	{
		System.out.println("  *** 메 뉴***");
		System.out.println("1. 성적 입력");
		System.out.println("2. 성적 출력");
		System.out.println("3. 성적 조회");
		System.out.println("4. 성적 수정");
		System.out.println("5. 성적 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}
	
	static int input_sungjuk(Sungjuk sun[], int cnt)
	{
		sun[cnt] = new Sungjuk();
		
		if(sun[cnt].input(sun, cnt))
			return cnt;
		
		sun[cnt].process();
		cnt++;
		System.out.println();
		
		return cnt;
	}
	
	static void output_sungjuk(Sungjuk sun[], int cnt)
	{
		double total_avg=0;
			
		System.out.println("\n\t\t *** 성적표 ***");
		System.out.println("====================================");
		System.out.println("  학번     이름      국어      영어      수학      총점        평균      등급");
		System.out.println("====================================");
		for (int i=0; i<cnt; i++)
		{	total_avg += sun[i].avg;
			sun[i].output();
		}
		System.out.println("====================================");
		System.out.printf("\t\t\t학생수  : %d, 전체평균 : %5.2f\n", cnt, total_avg / cnt);
	}
	
	static void search_sungjuk(Sungjuk sun[], int cnt)
	{
		Scanner as = new Scanner(System.in);
		System.out.print("학번입력 => ");
		String hakbun = as.next();
		
		for(int j=0; j<cnt; j++)
		{
			if(hakbun.equals(sun[j].hakbun))
			{
			System.out.println("\n\t\t *** 해당 학생 성적표 ***");
			System.out.println("====================================");
			System.out.println("  학번     이름      국어      영어      수학      총점        평균      등급");
			System.out.println("====================================");
			sun[j].output();
			System.out.println("====================================");
			System.out.println();
			return;
			}
		}
		System.out.println("해당 학번은 없습니다.");
		System.out.println();
	}
	
	static void change_sungjuk(Sungjuk sun[], int cnt)
	{
		Scanner as = new Scanner(System.in);
		System.out.print("학번입력 => ");
		String hakbun = as.next();
		
		for(int j=0; j<cnt; j++)
		{
			if(hakbun.equals(sun[j].hakbun))
			{
				System.out.print("국어점수입력 => ");
				sun[j].kor = as.nextInt();
				System.out.print("영어점수입력 => ");
				sun[j].eng = as.nextInt();
				System.out.print("수학점수입력 => ");
				sun[j].math = as.nextInt();
				System.out.println();
				
				sun[j].process();
				System.out.println("수정되었습니다.");
				System.out.println();
				return;
			}
		}
		System.out.println("해당 학번은 없습니다.");
		System.out.println();
	}
	
	static int delete_sungjuk(Sungjuk sun[], int cnt)
	{
		Scanner as = new Scanner(System.in);
		System.out.print("학번입력 => ");
		String hakbun = as.next();
		
		for(int j=0; j<cnt; j++)
		{
			if(hakbun.equals(sun[j].hakbun))
			{
				for(int i=j; i<cnt-1; i++)
					sun[i] = sun[i+1];
				
				cnt--;
				System.out.println("삭제되었습니다.");
				System.out.println();
				return cnt;
			}
		}
		System.out.println("해당 학번은 없습니다.");
		System.out.println();
		return cnt;
	}

}
