import java.util.Scanner;

public class Sosu {

	public static void main(String[] args) {
		int a, b, max, min;
		int num, con=0;
		
		
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

	
		ab:
		for(; min<=max; min++)
		{num=2;
			while(num<min)
			{
				if(min%num==0)
					continue ab;
				num ++;
			}
			System.out.printf("%5d", min);
		  con++;	
			
		  if(con%10 != 0)
		  continue;	
		  System.out.println();
		}
		System.out.println("\n");
		System.out.printf("총소수의 갯수 : %d", con);
	}

}
