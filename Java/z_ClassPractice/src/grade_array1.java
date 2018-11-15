import java.util.Scanner;

public class grade_array1 {
	
	final static int MAX = 100;

	public static void main(String[] args) {
			
		String [] hak = new String[MAX];
		String [] irum = new String[MAX];
		int [] kor = new int[MAX];
		int [] eng = new int[MAX];
		int [] mat = new int[MAX];
		int [] tot = new int[MAX];
		double [] avg = new double[MAX];
		char [] grade = new char[MAX];
		int i, cnt=0;
		double atot =0;
		
		Scanner in = new Scanner(System.in);
		
		for(i=0; i<MAX; i++)
		{
			System.out.print("학번 입력 : ");
			hak[i] = in.next();
			if(hak[i].equals("exit"))
				break;
			
			System.out.print("이름 입력 : ");
			irum[i] = in.next();
			System.out.print("국어점수 입력 : ");
			kor[i] = in.nextInt();
			System.out.print("영어점수 입력 : ");
			eng[i] = in.nextInt();
			System.out.print("수학점수 입력 : ");
			mat[i] = in.nextInt();
			
			tot[i] = kor[i] + eng[i] + mat[i];
			avg[i] = tot[i]/3.;
			
			/*{
			if(avg[i]>90)
				grade[i] = '수';
			else if(avg[i]>80)
				grade[i] = '우';
			else if(avg[i]>70)
				grade[i] = '미';
			else if(avg[i]>60)
				grade[i] = '양';
			else
				grade[i] = '가';
			}*/
				
			switch((int)avg[i] / 10) 
			{
			case 9 :
				grade[i] = '수';
				break;
			case 8 :
				grade[i] = '우';
				break;
			case 7 :
				grade[i] = '미';
				break;
			case 6 :
				grade[i] = '양';
				break;
			default :
				grade[i] = '가';
			}
			
			atot += avg[i];
			cnt++;
			System.out.println();
		}
		
		//atot /= cnt;
		
		System.out.println("\n\t\t     *** 성적표 ***");
		System.out.println("================================");
		System.out.println(" 학번        이름     국어    영어   수학      총점     평균      등급");
		System.out.println("================================");
		
		for(i=0; i<cnt; i++)
		{
			System.out.printf("%4s    %3s    %2d    %2d    %2d    %3d    %5.2f    %c\n", 
					hak[i], irum[i], kor[i], eng[i], mat[i], tot[i], avg[i], grade[i]);	
		}
		
		System.out.println("================================");
		System.out.printf("\t\t 학생수 : %d, 전체평균 : %.2f", cnt, atot/cnt);
	}

}
