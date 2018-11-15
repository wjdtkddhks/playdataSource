package Chapter2_2;


public class forExmple1 {

	public static void main(String[] args) {
		/*int sum=0, a=1;

		//for(; a<=10; a++)도 가능
		//for(; ; ) 조건식 없으면 무한루프식이 됨.
		/*for(; ; )
		{
			if(a > 10)
				break;
			sum += a;
			a++;
		}
		System.out.println(sum);*/
		
		int[] marks = {90, 25, 67, 45, 80};
		for(int i=0; i<marks.length; i++) {
		    if (marks[i] < 60) {
		        continue;
		    }
		    System.out.println((i+1)+"번 학생 축하합니다. 합격입니다.");
		}
	}
}
