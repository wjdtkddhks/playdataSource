package Chapter9;
import java.util.*;
public class Calculate {

	public static void main(String[] args) {
			
			int sum=0, num;
			String abc, str;
			StringTokenizer stok;
		
			Scanner in = new Scanner(System.in);
			
			while(true)
			{
				System.out.print("수식 입력 : ");
				abc = in.next();
				stok = new StringTokenizer(abc, "+-*/", true);
				
				if(!input_check(stok))
				{
					System.out.println("수식 오류");
					continue;
				}
				else
					break;
			}
			
			stok = new StringTokenizer(abc, "+-*/", true);
			
			sum = Integer.parseInt(stok.nextToken());
			
			while(stok.hasMoreTokens())
			{	
				str = stok.nextToken();
				num= Integer.parseInt(stok.nextToken());
				
				switch(str) 
				{
					case "+":
						sum+=num;
						break;
					case "-":
						sum-=num;
						break;
					case "*":
						sum*=num;
						break;
					case "/":
						sum/=num;
						break;
				}
			}
			System.out.print(abc + "=" + sum);
	}
	
	static boolean input_check(StringTokenizer stok) {
		
			char chr;
			String str;
			int cnt=1;
			
			while(stok.hasMoreTokens())
			{	
				str = stok.nextToken();
				
				for(int i=0; i<str.length(); i++)
					{	chr = str.charAt(i);
							if(chr< '0' || chr> '9')
								return false;}
				
					
				str = stok.nextToken();
				
				if(!stok.hasMoreTokens())
					return false;	
			}
			
			return true;
	}

}
