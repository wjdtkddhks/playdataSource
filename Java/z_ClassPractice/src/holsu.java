import java.util.Scanner;

public class holsu {

	public static void main(String[] args) {
		int num =0, sum=0;
		
		Scanner in = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
		num = in.nextInt();
		
		while(num!=0) {
			
			sum += num%10;
			num/= 10;
			
		}
		
		System.out.println(sum);

	}

}
