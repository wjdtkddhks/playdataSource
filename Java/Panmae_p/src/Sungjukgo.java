
public class Sungjukgo {

	public static void main(String[] args) {
		Sungjuk go = new Sungjuk();
		
		go.input();
		go.process();
		
		System.out.println("\n\t\t\t\t  *** 성적표 ***");
		System.out.println("=======================================================");
		System.out.println("학번		이름		국어		영어		수학		총점		평균		등급");
		System.out.println("=======================================================");
		go.output();
		System.out.println("=======================================================");

	}

}
 