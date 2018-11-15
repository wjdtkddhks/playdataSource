import java.util.Scanner;

public class gogodan {

	public static void main(String[] args) {
		int gogo, num;
		//int sum;
			
		
		Scanner as = new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("몇단을 알고 싶으신가요?  = ");
			gogo = as.nextInt();
			
			if(gogo == 0) 
			{
			System.out.println("The end,,,");
			break;
			}
			
			System.out.println("**" + gogo + "단 **");
			
			num=1;
			while(num<10){
					
					//System.out.printf("%d * %d = %d\n",gogo, num, gogo*num);
					
					//sum = gogo * num;
					//System.out.println(gogo + " * "  + num + " = " + sum);
					
				System.out.println(gogo + " * "  + num + " = " + (gogo*num));
					num++;}

		 
		}
		}
	
}

