package Chapter9;
import java.util.Scanner;

public class Jumin {

	public static void main(String[] args) {
			
			int arr[] = new int[13];
			int sum =0, na;
			
			Scanner in = new Scanner(System.in);
			
			System.out.print("주민번호 입력 : ");
			String str = in.next();
				
				
			for(int i=0; i<6; i++) {
				arr[i] = Integer.parseInt(str.substring(i, i+1));
			}
			for(int i=7; i<14; i++) {
				arr[i-1] = Integer.parseInt(str.substring(i, i+1));
			}
			
			for(int i=0; i<arr.length-1; i++)
			{
				if(i<8)
				sum+=arr[i]*(2+i);
				else
				sum+=arr[i]*(i-6);
			}
			
			na = sum%11;
						
			if(arr[12] == ((11-na)%10))
				System.out.printf("주민번호 : %s(O)", str);
			else	
				System.out.printf("주민번호 : %s(X)", str);
			
	}

}
