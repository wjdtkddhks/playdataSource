import java.util.Scanner;

public class gogodan2 {

	public static void main(String[] args) {
		int a,b;
		int num;
		
		Scanner as = new Scanner(System.in);
		System.out.println("첫번째 수 입력 : ");
		a = as.nextInt();
		System.out.println("두번째 수 입력 : ");
		b = as.nextInt();
		
		if(a>b) 
		{
		  while(a>=b) 
		  {num=1; 
			 System.out.printf(" *   %d단   *\n", b);
			 while(num<10)
			 {
			  System.out.printf(" %d * %d = %d\n", b, num, num*b);
			  num++;
			 }
						
			b++;
		  }
			
		}
		
		else
		{
			  while(a<=b) 
			  {num=1; 
				 System.out.printf(" *   %d단   *\n", a);
				 while(num<10)
				 {
				  System.out.printf(" %d * %d = %d\n", a, num, num*a);
				  num++;
				 }
				a++;
			   }
			
		 }
		
		
	}

}
