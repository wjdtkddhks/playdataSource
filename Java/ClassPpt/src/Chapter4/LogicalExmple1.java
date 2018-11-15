package Chapter4;

public class LogicalExmple1 {

	public static void main(String[] args) {

			int a=3, b=4, c=3, d=5;
			
			if((a==2 | a==c) & !(c>d) & (1== b ^ c!=d))
			 	System.out.println("참입니다");
			else
				System.out.println("거짓입니다");

	}

}
