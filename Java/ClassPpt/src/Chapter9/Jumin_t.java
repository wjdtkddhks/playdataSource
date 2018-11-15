package Chapter9;
import java.util.Scanner;

public class Jumin_t {

	public static void main(String[] args) {
			
			int sum =0, w=2, na;
			String str;
			
			Scanner in = new Scanner(System.in);
			
			
			while(true) {
				
				System.out.print("주민번호 입력 : ");
				str = in.next();
				
				if(!input_check(str))
				{
					System.out.println("주민번호 오류");
					continue;
				}
				else
					break;				
			}
				
			for(int i=0; i<str.length()-1; i++) {
				if(i==6)
					continue;
				
				sum += Integer.parseInt(str.substring(i, i+1))*w;
				w++;
				if(w==10)
					w=2;
			}
			
			na =11-sum%11;
			
			/*if(na == 10)
				na=0;
			else if(na ==11)
				na=1;*/
						
			if(Integer.parseInt(str.substring(13, 14)) == (na%10))
				System.out.printf("주민번호 : %s(O)", str);
			else	
				System.out.printf("주민번호 : %s(X)", str);
			
	}
	
	static boolean input_check(String str) {
		
			char chr;
			
			if(str.length() != 14)
				return false;
			
			for(int i=0; i<str.length(); i++)
			{
				chr = str.charAt(i);
				
					if(i==6)
					{
						if(chr != '-')
							return false;
					}
					else if(i==7)
					{
						if(!(chr == '1' || chr == '2' || chr == '3' || chr== '4'))
							return false;
					}
					else if(chr< '0' || chr>'9')
						return false;
			}
		return true;
	}

}
