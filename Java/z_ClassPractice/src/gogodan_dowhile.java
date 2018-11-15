import java.util.Scanner;

public class gogodan_dowhile {

	public static void main(String[] args) {


			int num1, num2, min, max, i, j;			
			Scanner ab = new Scanner(System.in);
			
			System.out.println("첫번째 수 : ");
			num1 = ab.nextInt();
			System.out.println("두번째 수 : ");
			num2 = ab.nextInt();
			
			
			if(num1 > num2) 
			{
				max = num1;
				min = num2;
			}
			else
			{
				max = num2;
				min = num1;
			}
			
			
			for(i=min; i<=max; i++)
			{
				System.out.printf("  *%d단*\t", i);
			}
			
			System.out.println();
			
			  
			  for(j=1; j<=9; j++)
			  {
			    for(i=min; i<=max; i++)
			    {
			     	  System.out.printf("%2d*%2d=%2d", i, j, i*j);
			    }
			      System.out.println(); 
			  }
			
	}

}