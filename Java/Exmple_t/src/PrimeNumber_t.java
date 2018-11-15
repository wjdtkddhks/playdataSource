import java.util.Scanner;

public class PrimeNumber_t {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num1, num2, min, max, cnt=0;
		int i, j;
		
		System.out.print("첫번째 숫자 입력 => ");
		num1 = in.nextInt();
		System.out.print("두번째 숫자 입력 => ");
		num2 = in.nextInt();
		System.out.println();
		
		if (num1 < num2) 
		{
			min = num1;
			max = num2;
		}
		else
		{
			min = num2;
			max = num1;
		}
		
		for (i=min; i<=max; i++)
		{
			for (j=2; j<i; j++) 
			{
				if (i%j == 0)
					break;  
			}
			if (i == j) 
			{
				System.out.printf("%5d", i); 
				cnt++; 
				if (cnt % 10 == 0)  
					System.out.println();
			}
		}
		if (cnt % 10 != 0)
			System.out.println(); 
		System.out.println("총소수의 갯수 = " + cnt);
	}
}