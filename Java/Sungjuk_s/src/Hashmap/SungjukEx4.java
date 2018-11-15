package Hashmap;
import java.util.*;

public class SungjukEx4 
{
	
public static void main(String[] args) 
{
		HashMap<String, Sungjuk> sun = new HashMap<String, Sungjuk>();
		int menu=0;		
		Scanner as = new Scanner(System.in);
		
		
		while(true)
		{
			menu_sungjuk();
			
			System.out.print("메뉴입력(1~6) : ");
			try 
			{
				menu = Integer.parseInt(as.next());
				System.out.println();
			}
			catch(Exception e)
			{
				System.out.println("1~6사이의 수를 입력해주세요.");
				System.out.println();
			
				continue;
			}
			if(menu == 6)
			{
				System.out.println("프로그램이 종료됩니다.");
				break;
			}
				switch(menu) 
				{
					case 1 :
						input_sungjuk(sun);
						break;
					case 2 :
						output_sungjuk(sun);
						break;
					case 3 :
						search_sungjuk(sun, as);
						break;
					case 4 :
						change_sungjuk(sun, as);
						break;
					case 5 :
						delete_sungjuk(sun, as);
						break;
					default :
						System.out.println("1~6사이의 수를 입력해주세요.");
						System.out.println();
				}
		}		
}
	
	static void menu_sungjuk()
	{
		System.out.println("  *** 메 뉴 ***");
		System.out.println("1. 성적 입력");
		System.out.println("2. 성적 출력");
		System.out.println("3. 성적 조회");
		System.out.println("4. 성적 수정");
		System.out.println("5. 성적 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}
	
	static void input_sungjuk(HashMap<String, Sungjuk> sun)
	{
		Sungjuk obj = new Sungjuk();
		
		if(obj.input(sun))
		{	System.out.println("해당학번은 존재합니다. 다시 입력해주세요.\n");
			return;
		}
		
		obj.process();
		sun.put(obj.hakbun, obj);
		System.out.println();
	}
	
	static void output_sungjuk(HashMap<String, Sungjuk> sun)
	{	double total_avg=0;
		/*Set<String> set = sun.keySet();
		int cnt=0;
		
		if(sun.isEmpty()) // if(set.size() == 0)
		{	System.out.println("출력할 데이터가 없습니다.\n");
			return;			
		}
		System.out.println("\n\t\t *** 성적표 ***");
		System.out.println("====================================");
		System.out.println("  학번       이름      국어      영어      수학      총점        평균      등급");
		System.out.println("====================================");
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			sun.get(str).output();
		}
		
		for(String str : set) // 순서대로 안나올 수도 있음, 가상자바머신이 정함.
		{	total_avg += sun.get(str).avg;
			sun.get(str).output();
			cnt++;
		}
		System.out.println("====================================");
		System.out.printf("\t\t\t학생수  : %d, 전체평균 : %5.2f\n", cnt, total_avg /cnt);*/
		Sungjuk obj = null;
		Set entryset = sun.entrySet();
		if(entryset.size() ==0)
		{	System.out.println("출력할 데이터가 없습니다.\n");
			return;			
		}
		
		Iterator it_entry = entryset.iterator();
		System.out.println("\n\t\t *** 성적표 ***");
		System.out.println("====================================");
		System.out.println("  학번       이름      국어      영어      수학      총점        평균      등급");
		System.out.println("====================================");
		while(it_entry.hasNext()) {
			Map.Entry e = (Map.Entry) it_entry.next();
			obj = (Sungjuk)e.getValue();
			obj.output();			 
		}
		System.out.println("====================================");
		System.out.printf("\t\t\t학생수  : %d, 전체평균 : %5.2f\n", entryset.size(), total_avg /entryset.size());
	}
	
	static void search_sungjuk(HashMap<String, Sungjuk> sun, Scanner as)
	{	Sungjuk obj =null;
		System.out.print("학번입력 => ");
		String hakbun = as.next();
		/*Set<String> set = sun.keySet();
		
		for(String str : set)
		{	obj= sun.get(str);
			if(hakbun.equals(obj.hakbun))*/
		obj = sun.get(hakbun);
		if(obj !=null)
			{
			System.out.println("\n\t\t *** 해당 학생 성적표 ***");
			System.out.println("====================================");
			System.out.println("  학번     이름      국어      영어      수학      총점        평균      등급");
			System.out.println("====================================");
			obj.output();
			System.out.println("====================================");
			System.out.println();
			return;
			}
		else {
		System.out.println("해당 학번은 없습니다.");
		System.out.println();}
	}
	
	static void change_sungjuk(HashMap<String, Sungjuk> sun, Scanner as)
	{	Sungjuk obj = null;
		System.out.print("학번입력 => ");
		String hakbun = as.next();
		/*Set<String> set = sun.keySet();
		
		for(String str : set)
		{	obj = sun.get(str);
			if(hakbun.equals(obj.hakbun))*/
		obj = sun.get(hakbun);
		if(obj != null)
			{
				System.out.print("국어점수입력 => ");
				obj.kor = as.nextInt();
				System.out.print("영어점수입력 => ");
				obj.eng = as.nextInt();
				System.out.print("수학점수입력 => ");
				obj.math = as.nextInt();
				System.out.println();
				
				obj.process();
				System.out.println("수정되었습니다.");
				System.out.println();
				return;
			}
		else {
		System.out.println("해당 학번은 없습니다.");
		System.out.println();}
	}
	
	static void delete_sungjuk(HashMap<String, Sungjuk> sun, Scanner as)
	{	Sungjuk obj = null;
		System.out.print("학번입력 => ");
		String hakbun = as.next();
		/*Set<String> set = sun.keySet();
		
		for(String str : set)
		{	obj = sun.get(str);
			if(hakbun.equals(obj.hakbun))
			{*/
		obj = sun.get(hakbun);
		if(obj != null) 
		{	sun.remove(hakbun);
			System.out.println("삭제되었습니다.");
			System.out.println();
			return;
		}
		else {
		System.out.println("해당 학번은 없습니다.");
		System.out.println();}
	}

}
