import java.util.Scanner;

public class PrimeNumber 
{

	public static void main(String[] args) 
	{
		int num[];
		int cnt;
		
		num = inputPrimeNumber();
				
		cnt=outputPrimeNumber(num[0], num[1]);
		
		if (cnt % 10 != 0)
			System.out.println(); 
		
		System.out.println("총소수의 갯수 = " + cnt);
	}	
	
	static int[] inputPrimeNumber()
	{
		int [] num = new int[2];
		int num1, num2;
		
		Scanner in = new Scanner(System.in);
		System.out.print("첫번째 숫자 입력 => ");
		num1 = in.nextInt();
		System.out.print("두번째 숫자 입력 => ");
		num2 = in.nextInt();
		System.out.println();
		
		if (num1 < num2) 
		{
			num[0] = num1;
			num[1] = num2;
		}
		else
		{
			num[0] = num2;
			num[1] = num1;
		}
		
		return num;
	}	
		
	static int outputPrimeNumber(int min, int max) 
	{	
		int i,j, cnt=0;
	
	
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
		
		return cnt;
	}
	
}
