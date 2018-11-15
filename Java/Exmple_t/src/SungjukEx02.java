import java.util.Scanner;

public class SungjukEx02 
{
	
	final static int MAX = 10;
	
	public static void main(String[] args) 
	{
		String hakbun[] = new String[MAX];
		String irum[] = new String[MAX];
		int kor[] = new int[MAX];
		int eng[] = new int[MAX];
		int math[] = new int[MAX];
		int tot[] = new int[MAX];
		double avg[] = new double[MAX];
		String grade[] = new String[MAX];
		int i, cnt = 0;
		
		cnt = inputSungjuk(hakbun, irum, kor, eng, math, tot, avg, grade);
		outputSungjuk(hakbun, irum, kor, eng, math, tot, avg, grade, cnt);
		
	}
	
	static int inputSungjuk(String hakbun[], String irum[], int kor[], int eng[], int math[], 
			int tot[], double avg[], String grade[])
	{
		int i, cnt=0;
		
		Scanner in = new Scanner(System.in);
		
		for (i=0; i<MAX; i++)
		{
			System.out.print("학번입력 => ");
			hakbun[i] = in.next();
			if (hakbun[i].equals("exit"))
				break;
			
			System.out.print("이름입력 => ");
			irum[i] = in.next();
			System.out.print("국어점수입력 => ");
			kor[i] = in.nextInt();
			System.out.print("영어점수입력 => ");
			eng[i] = in.nextInt();
			System.out.print("수학점수입력 => ");
			math[i] = in.nextInt();
			
			tot[i] = kor[i] + eng[i] + math[i];
			avg[i] = tot[i] / 3.;
			
			switch((int) avg[i] / 10)
			{
				case 10:
				case 9:
					grade[i] = "수";
					break;
				case 8:
					grade[i] = "우";
					break;
				case 7:
					grade[i] = "미";
					break;
				case 6:
					grade[i] = "양";
					break;
				default:
					grade[i] = "가";
					break;
			}
			cnt++;
			System.out.println();
		}
		return cnt;
	}
	
	static void outputSungjuk(String hakbun[], String irum[], int kor[], int eng[], int math[], 
			int tot[], double avg[], String grade[], int cnt)
	{
		int i; 
		double total_avg=0;
			
		System.out.println("\n\t\t *** 성적표 ***");
		System.out.println("====================================");
		System.out.println("학번       이름      국어      영어      수학      총점      평균      등급");
		System.out.println("====================================");
		for (i=0; i<cnt; i++)
		{total_avg += avg[i];
			System.out.printf("%4s  %3s     %3d     %3d    %3d   %3d   %6.2f  %2s\n",
				hakbun[i], irum[i], kor[i], eng[i], math[i], tot[i], avg[i], grade[i]);
		}
		System.out.println("====================================");
		System.out.printf("\t\t학생수  : %d, 전체평균 : %5.2f\n", cnt, total_avg / cnt);
	}
}
