import java.util.ArrayList;
import java.util.Scanner;

public class Blood {
	
	String name, gender, type;
	int age;
	final String MAN = "남자";
	final String WOMAN = "여자";
	
	boolean input(ArrayList<Blood> man, ArrayList<Blood> woman) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		this.name = in.next();
		System.out.print("나이 입력 : ");
		this.age = in.nextInt();
		System.out.print("성별 입력 : ");
		this.gender = in.next();
		if(gender_check())
			return true;
		
		for(Blood obj : man)
			if(obj.name.equals(name) && obj.gender.equals(gender) && obj.age == age) {
				System.out.println("동일인물이 있습니다. 다시 입력해주세요.\n");
				return true;}
		for(Blood obj : woman)
			if(obj.name.equals(name) && obj.gender.equals(gender) && obj.age == age){
				System.out.println("동일인물이 있습니다. 다시 입력해주세요.\n");
				return true;}
		
		System.out.print("혈액형 입력(영어만) : ");
		this.type =in.next().toUpperCase();
		if(type_check())
			return true;
			
		return false;
	}
	
	boolean gender_check() {
		if(gender.equals("남자") || gender.equals("man") || gender.equals("남") || gender.equals("boy"))
			gender = MAN;
		else if(gender.equals("여자") || gender.equals("woman") || gender.equals("여") || gender.equals("girl"))
			gender = WOMAN;
		else
		{	System.out.println("성별은 남자, 여자로 입력해주세요.\n");
			return true;}
		
		return false;
	}
	
	boolean type_check() {
		if(type.equals("A") || type.equals("B") || type.equals("AB") || type.equals("O"))
			return false;
		System.out.println("혈액형은 A,B,AB,O로 입력해주세요.\n");
		return true;
	}

	void output() {
		System.out.printf("%4s   %2d세    %2s   %3s형\n", name, age, gender, type);
	}
}
