package SimleAdder;

public class WhileExmple1 {

	public static void main(String[] args) {
		int cnt = 1, hol = 0, bnt=2, zak=0; 
		
		while(cnt <=100) {
			
			hol += cnt;
			cnt+=2;
			
			zak += bnt;
			bnt+=2;
			
		}
		
		System.out.println("hol hap : " + hol);
		System.out.println("zak hap : " + zak);
	}

}
