import java.util.Scanner;

public class grade1 {

	public static void main(String[] args) {
		
		int score;
		char grade= ' ';
		char odd =' ';
		
		System.out.println("점수를 입력하세요 : ");
		
		Scanner in = new Scanner(System.in);
		score = in.nextInt();
		
		if(score > 90) {
			grade = 'A';
			if(score >95) {
				odd = '+';
			}
			else if(score<92) {
				odd ='-';
			}
		}
		else if(score > 70) {
			grade = 'B';
			if(score > 84) {
				odd = '+';}
			else if(score < 75) {
				odd = '-';}
			}
		else 
			grade = 'C';
		
		System.out.printf("당신의 등급은 %s%s입니다. \n", odd, grade);
		
		
	}

}
