import java.util.ArrayList;
import java.util.Scanner;

public class Sungjuk {

	String hakbun, irum, grade;
	int kor, eng, math, tot;
	double avg;
	static double total_avg;
	
	boolean input(ArrayList<Sungjuk> sun)
	{
			Scanner in = new Scanner(System.in);
			System.out.print("학번입력 => ");
			String abc = in.next();
			for(Sungjuk ab : sun)
			{	if(abc.equals(ab.hakbun))
					return true;
			}
			this.hakbun = abc;
			System.out.print("이름입력 => ");
			this.irum = in.next();
			System.out.print("국어점수입력 => ");
			this.kor = in.nextInt();
			System.out.print("영어점수입력 => ");
			this.eng = in.nextInt();
			System.out.print("수학점수입력 => ");
			this.math = in.nextInt();
			
			return false;
	}
	
	void process()
	{
			this.tot = kor + eng + math;
			this.avg = tot / 3.;
			
			switch((int) avg / 10)
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
				default:
					grade = "가";
					break;
			}
	
	}
	
	void output()
	{
		System.out.printf("%4s     %3s    %3d     %3d      %3d     %3d    %6.2f    %2s\n",
				hakbun, irum, kor, eng, math, tot, avg, grade);
	}
	
}
	
	
	
