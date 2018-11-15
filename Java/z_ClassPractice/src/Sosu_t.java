import java.util.Scanner;

public class Sosu_t {

	public static void main(String[] args) {
		int a, b, max, min;
		int num, na=0, con=0;
		
		
		Scanner t = new Scanner(System.in);
		System.out.print("첫번째 수 입력 : ");
		a = t.nextInt();
		System.out.print("두번째 수 입력 : ");
		b = t.nextInt();
		
		
		if(a>b)
		{
			max = a;
			min = b;
		}
		else
		{
			max = b;
			min = a;
		}
		System.out.print("\n");
	
	
		
		for(; min<=max; min++)
		{
		   for(num=2; num<min; num++)
			{
				if(min%num == 0)
					break;
					
			}
			if(min == num) 
			{
				System.out.printf("%5d", min);
				con++;	
				if(con%10 ==0)
				System.out.println();
			}
			
		}
		if(con%10 != 0)
		  System.out.println();
		  System.out.println();

		System.out.printf("총소수의 갯수 : %d", con);
	
	  }
		
	}


