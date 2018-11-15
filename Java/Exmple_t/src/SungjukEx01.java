import java.util.Scanner;

public class SungjukEx01 {

	public static void main(String[] args) {
		String hakbun;
		String irum;
		int kor;
		int eng;
		int math;
		int tot;
		double avg;
		String grade;
		
		Scanner in  = new Scanner(System.in);
		
		System.out.print("학번 입력 => ");
		hakbun = in.next();
		System.out.print("이름 입력 => ");
		irum = in.next();
		System.out.print("국어점수 입력 => ");
		kor = in.nextInt();
		System.out.print("영어점수 입력 => ");
		eng = in.nextInt();
		System.out.print("수학점수 입력 => ");
		math = in.nextInt();
		
		tot = kor + eng + math;
		avg = tot/3;
		
		
		
		switch((int)avg / 10) {
		
		case 10 :
		case 9:
			grade = "수";
		break;
		
		case 8 :
			grade = "우";
		break;
	
		case 7 :
			grade = "미";
		break;
		
		case 6 :
			grade = "양";
		break;
		
		default : 
			grade = "가";
			
		}				
				
		
		System.out.println("\n\t\t\t\t  *** 성적표 ***");
		System.out.println("=======================================================");
		System.out.println("학번		이름		국어		영어		수학		총점		평균		등급");
		System.out.printf("%4s		%3s		%3d		%3d		%3d		%3d		%6.2f 	%2s\n", 
				hakbun, irum, kor, eng, math, tot, avg, grade);
		System.out.println("=======================================================");
		

	}

}
