import java.util.Scanner;

public class GugudanEx04 {
	public static void main(String[] args) 
	{
		int num[];
        
        num = inputGugudan();
        
		System.out.println("");
        printGugudan(num[0], num[1]);
	}
	
	static int[] inputGugudan() 
	{
		int num[] = new int[2];
		int num1, num2;
		
		Scanner scan = new Scanner(System.in);
        
        System.out.print("첫번째 수 입력 => ");
        num1 = scan.nextInt();
        System.out.print("두번째 수 입력 => ");
        num2 = scan.nextInt();
        
        if (num1 > num2)
        {
        	num[0] = num2;
        	num[1] = num1;
        }
        else
        {
        	num[0] = num1;
        	num[1] = num2;
        }
        
		return num;
		
	}
	
	static void printGugudan(int min, int max) 
	{
		
		int i,j;
		
		for (i=min; i <= max; i++) 
        {      
	        System.out.printf("* %d단 *  ", i);
        }
        System.out.println();

        for(j = 1; j <= 9; j++)
        {
        	for(i = min; i <= max; i++)
        	{
	        	System.out.printf("%d*%d=%2d  ", i, j, i*j);            
	        } 
	        System.out.println();
        }
		
		
	}
	
}
