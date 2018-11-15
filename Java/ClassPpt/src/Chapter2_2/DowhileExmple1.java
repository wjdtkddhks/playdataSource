package Chapter2_2;


public class DowhileExmple1 {

	public static void main(String[] args) {
		int cnt = 1;
		int sum = 0;
		
		do 
		{
			System.out.println(cnt);
			//sum += cnt;
			//cnt++;
			sum += cnt++;
		}
		while(cnt<=10);
		System.out.println(sum);
		System.out.println("Done");

	}

}
