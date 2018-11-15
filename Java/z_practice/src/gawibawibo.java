import java.util.Scanner;

public class gawibawibo {

	public static void main(String[] args) {

		System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요 : ");
		
		Scanner in = new Scanner(System.in);
		int use = in.nextInt();
		int com = (int)(Math.random() *3) +1;
		
		System.out.printf("당신은 %d입니다.", use);
		System.out.printf("당신은 %d입니다.", com);
		
		switch(use-com) {
		
		case 2: case -1:
			System.out.println("당신은 졌습니다.");
			break;
			
		case 1: case -2:
			System.out.println("당신은 이겼니다.");
				break;
				
		case 0:
				System.out.println("당신은 비겼습니다.");
				break;
			
			
		}
		
     	}

	}


