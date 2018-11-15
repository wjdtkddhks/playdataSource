import java.util.Scanner;

class Sungjuk extends Person implements Personable {

		int kor, eng, math;
		int tot;
		double avg;
		String grade;
		
	public boolean input() {
				
		Scanner in = new Scanner(System.in);
		
		System.out.print("학번입력 : ");
		hakbun = in.next();
			if(hakbun.toLowerCase().equals("exit"))
				return true;
		System.out.print("이름입력 : ");
		irum = in.next();
		System.out.print("국어점수입력 : ");
		kor = in.nextInt();
		System.out.print("영어점수입력 : ");
		eng = in.nextInt();
		System.out.print("수학점수입력 : ");
		math = in.nextInt();
		System.out.println();
		
		return false;
		}
		
	public void output() {
			
			System.out.printf(" %4s    %3s    %2d    %2d    %2d    %3d    %5.2f    %2s\n",
					hakbun, irum, kor, eng, math, tot, avg, grade);
		}
		
	void process() {
			
			tot = kor+eng+math;
			avg = tot/3.;
			
			switch((int)(avg/10)) 
			{			
				case 10:
				case 9:
					grade = "수";
					break;
				case 8:
					grade = "우";
					break;
				case 7:
					grade = "미";
					break;
				case 6:
					grade = "양";
					break;
				default :
					grade = "가";
			}					
			
		}
			
}
