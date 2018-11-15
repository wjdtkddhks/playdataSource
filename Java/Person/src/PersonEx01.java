
public class PersonEx01 {
	
	final static int MAX = 100;

	static String str1 = "Sungjuk";
	static String str2 = "PersonInfo";

	public static void main(String[] args) {
		
		Sungjuk sun [] = new Sungjuk[MAX];
		PersonInfo pho [] = new PersonInfo[MAX];
		int j=0, k=0;
		
		System.out.println("성적을 입력하세요.");
		for(int i = 0; i<MAX; i++)
		{
			sun[i] = new Sungjuk();
			
			if(sun[i].input())
				break;
			
			j++;
			sun[i].process();
			System.out.println();		
		}
		System.out.println();
		System.out.println("개인정보를 입력하세요.");
		for(int i = 0; i<MAX; i++)
		{
			pho[i] = new PersonInfo();
			
			if(pho[i].input())
				break;
			k++;
			System.out.println();
		}
		System.out.println();
		
		outputAll(sun, j, str1);
		System.out.println();
		outputAll(pho, k, str2);
	
	}
	
	static void outputAll(Personable per[], int cnt, String str) {
		
		if(str == str1)
		{
			System.out.println("\t\t\t*** 성적표 ***");
			System.out.println("=================================");
			System.out.println("   학번       이름     국어   영어    수학    총점       평균       등급");
			System.out.println("=================================");
			for(int i=0; i<cnt; i++)
				per[i].output();
			System.out.println("=================================");
		}
		else
		{
			System.out.println("\n\t\t  *** 개인정보 ***");
			System.out.println("=========================");
			System.out.println("   학번       이름             전화번호             주소     ");
			System.out.println("=========================");
			for(int i=0; i<cnt; i++)
				per[i].output();
			System.out.println("=========================");
		}
		
	}

}
