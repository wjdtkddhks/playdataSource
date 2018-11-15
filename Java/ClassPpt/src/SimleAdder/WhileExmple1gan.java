package SimleAdder;

public class WhileExmple1gan {

	public static void main(String[] args) {
		int cnt = 1, odd=0, even=0;
		
			while(cnt <=100) {
				if(cnt%2 ==0)
					even += cnt;
				else
					odd +=cnt;
				cnt++;
			}
		System.out.println("홀수의 합 : " + odd);
		System.out.println("짝수의 합 : " + even);
	}
	
}
