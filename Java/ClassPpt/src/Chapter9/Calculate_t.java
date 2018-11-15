package Chapter9;
import java.util.*;
public class Calculate_t {

	public static void main(String[] args) {
			
			int result;
			String str, token_str;
		
			Scanner in = new Scanner(System.in);
			
		input_loop:	
			while(true)
			{
				System.out.print("수식 입력 : ");
				str = in.next().trim();
				StringTokenizer token = new StringTokenizer(str, "+-*/", true);
				
				token_str= token.nextToken();
				
				if(input_check(token_str))
				{
					System.out.println("수식 오류");
					continue input_loop;
				}
				result = Integer.parseInt(token_str);
				
				while(token.hasMoreTokens())
				{
					token_str= token.nextToken();
					char ch = token_str.charAt(0);
					
					if(token.hasMoreTokens())
						token_str=token.nextToken();
					else
					{
						System.out.println("수식 오류");
						continue input_loop;
					}
					
					switch(ch)
					{
						case '+':
							result+= Integer.parseInt(token_str);
							break;
						case '-':
							result-= Integer.parseInt(token_str);
							break;
						case '*':
							result*= Integer.parseInt(token_str);
							break;
						case '/':
							result/= Integer.parseInt(token_str);
							break;
					}
				}
				break;
			}
			System.out.print(str + "=" + result);
	}
	
	static boolean input_check(String str) {
		
			char ch;
			
			for(int i=0; i<str.length(); i++)
			{
				ch = str.charAt(i);
				
				if(ch<'0' || ch>'9')
					return true;
			}
			return false;
	}

}
