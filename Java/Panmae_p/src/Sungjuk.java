import java.util.Scanner;

public class Sungjuk {
	
	String hakbun, irum, grade;
	int kor, eng, math, tot;
	double avg;
	
	void input()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("학번 입력 : ");
		this.hakbun = in.next();
		System.out.print("이름 입력 : ");
		this.irum = in.next();
		System.out.print("국어점수 입력 : ");
		this.kor = in.nextInt();
		System.out.print("영어점수 입력 : ");
		this.eng= in.nextInt();
		System.out.print("수학점수 입력 : ");
		this.math= in.nextInt();
	}
	
	void process()
	{
		this.tot = kor + eng + math;
		this.avg = tot/3.;
		
		if(avg>90)
			grade = "수";
		else if(avg>80)
			grade = "우";
		else if(avg>70)
			grade = "미";
		else if(avg>60)
			grade = "양";
		else
			grade = "가";	
	}
	
	void output() 
	{
		System.out.printf("%4s		%3s		%3d		%3d		%3d		%3d  %6.2f 	%2s\n", 
				hakbun, irum, kor, eng, math, tot, avg, grade);
	}
	
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Sungjuk))
			return false;
		
		Sungjuk sungjuk = (Sungjuk)obj;
		
		if(hakbun.equals(sungjuk.hakbun) 
				&& irum.equals(sungjuk.irum) 
				&& kor == sungjuk.kor
				&& eng == sungjuk.eng 
				&& math == sungjuk.math)
			return true;
		else
		return false;
			}
}
