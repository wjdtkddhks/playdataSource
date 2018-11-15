import java.util.Scanner;

public class gogodan3 {

	public static void main(String[] args) {
		int a,b, coa, cob;
		int num;
		
		Scanner as = new Scanner(System.in);
		System.out.println("첫번째 수 입력 : ");
		a = as.nextInt();
		System.out.println("두번째 수 입력 : ");
		b = as.nextInt();
		
		System.out.println();
		
		coa = a;  //a 입력시 초기값
		cob = b;  //b 입력시 초기값
		
		if(a>b) 
		{
		  while(a>=b) 
		  {System.out.printf("  * %d단  *\t", b);
		    b++;}
		   System.out.println();
		   num=1;
		   
		  while(num<10) 
		  {b = cob;
		   	while(a>=b)
		   	 {
		   		System.out.printf("%2d*%2d=%2d\t", b, num, num*b);
		   		b++;
		     }
		   	System.out.println();
		    num++; 
		  }
		 }
		else
		{
		  while(b>=a) 
		  {System.out.printf("  * %d단  *\t", a);
		  a++;}
		   System.out.println();
		  
		  num=1;
		  while(num<10) 
		  {a = coa;
		   	while(b>=a)
		   	{
		   		System.out.printf("%2d*%2d=%2d\t", a, num, num*a);
		   		a++;}
		   		System.out.println();
		   num++; 
		  }
		 }
			
		
      }
	}

