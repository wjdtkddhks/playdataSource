import java.util.*;

public class BloodEx01 {

	public static void main(String[] args) {
		int menu;
		Scanner in = new Scanner(System.in);
		ArrayList<Blood> man = new ArrayList<Blood>();
		ArrayList<Blood> woman = new ArrayList<Blood>();
		
		System.out.println(" *** 혈액형으로 궁합 맞춰보기 ***");
		while(true) {
			try {
			menu();
			System.out.print("메뉴(1~6) 입력 : ");
			menu = Integer.parseInt(in.next());
			System.out.println();
			}
			catch(Exception e) {
				System.out.println("1~6사이의 수를 입력하세요.");
				continue;
			}
			if(menu == 6) {
				System.out.println("프로그램이 종료 됩니다.");
				break;		
			}
			switch(menu) {
				case 1 :
					input_blood(man, woman);
					break;
				case 2 :
					output_blood(man, woman);
					break;
				case 3 :
					change_blood(man, woman, in);
					break;
				case 4 :
					delete_blood(man, woman, in);
					break;
				case 5 :
					match_blood(man, woman, in);
					break;
				default :
					System.out.println("1~6사이의 수를 입력하세요.");
					continue;
			}
		}
	}
	
	static void menu() {
		System.out.println("   *** 메 뉴 ***");
		System.out.println("1. 정보 입력");
		System.out.println("2. 명단 출력");
		System.out.println("3. 정보 수정");;
		System.out.println("4. 정보 삭제");
		System.out.println("5. 궁합 보기");
		System.out.println("6. 프로그램 종료");
	}
	
	static void input_blood(ArrayList<Blood> man, ArrayList<Blood> woman) {
		
		Blood obj = new Blood();
		if(obj.input(man, woman)) 
			return;
	
		if(obj.gender.equals("남자"))
			man.add(obj);
		else if(obj.gender.equals("여자"))
			woman.add(obj);
		
		System.out.println();
	}
	
	static void output_blood(ArrayList<Blood> man, ArrayList<Blood> woman) {
		if(man.size() == 0)
			{System.out.println("입력된 남자 정보는 없습니다.");}
		if(man.size() > 0) {
		System.out.println("\t *** 남자 명단 ***");
		System.out.println("======================");
		System.out.println("  이름     나이    성별   혈액형");
		System.out.println("======================");
		for(Blood obj : man)
			obj.output();
		System.out.println("======================");
		System.out.printf("\t\t  남자 총 인원 : %d명\n", man.size());
		}
		System.out.println();
		
		if(woman.size() == 0)
			{System.out.println("입력된 여자정보는 없습니다.");}
		if(woman.size() > 0) {
		System.out.println("\t *** 여자 명단 ***");
		System.out.println("======================");
		System.out.println("  이름     나이    성별   혈액형");
		System.out.println("======================");
		for(Blood obj : woman)
			obj.output();
		System.out.println("======================");
		System.out.printf("\t\t  여자 총 인원 : %d명\n", woman.size());
		}
		System.out.println();
	}
	
	static void change_blood(ArrayList<Blood> man, ArrayList<Blood> woman, Scanner in) {
		Blood obj = new Blood();
		System.out.print("이름 입력 : ");
		obj.name = in.next();
		System.out.print("성별 입력 : ");
		obj.gender = in.next();
		if(obj.gender_check()) 
			return;
		
		for(int i=0; i<man.size(); i++) {
			if(man.get(i).name.equals(obj.name) && man.get(i).gender.equals(obj.gender))
			{	String type = man.get(i).type;
				System.out.print("나이 입력 : ");
				man.get(i).age = in.nextInt();
				System.out.print("혈액형 입력 : ");
				man.get(i).type = in.next().toUpperCase();
				if(man.get(i).type_check()) {
					man.get(i).type = type;
					i--;
					continue;}
				
				System.out.println("수정되었습니다.");
				System.out.println();
				return;
			}
		}
		for(int i=0; i<woman.size(); i++) {
			if(woman.get(i).name.equals(obj.name) && woman.get(i).gender.equals(obj.gender))
			{	String type = woman.get(i).type;
				System.out.print("나이 입력 : ");
				woman.get(i).age = in.nextInt();
				System.out.print("혈액형 입력 : ");
				woman.get(i).type = in.next().toUpperCase();
				if(woman.get(i).type_check()){
					woman.get(i).type= type;
					i--;
					continue;}
				
				System.out.println("수정되었습니다.");
				System.out.println();
				return;
			}
		}
		System.out.println("해당되는 사람이 없습니다.");	
		System.out.println();
	}

	static void delete_blood(ArrayList<Blood> man, ArrayList<Blood> woman, Scanner in) {
		Blood obj = new Blood();
		System.out.print("이름 입력 : ");
		obj.name = in.next();
		System.out.print("성별 입력 : ");
		obj.gender = in.next();
		if(obj.gender_check())
			return;
		
		for(int i=0; i<man.size(); i++) {
			if(man.get(i).name.equals(obj.name) && man.get(i).gender.equals(obj.gender))
			{
				man.remove(i);
				System.out.println("해당정보 삭제되었습니다.");
				System.out.println();
				return;
			}
		}
		for(int i=0; i<woman.size(); i++) {
			if(woman.get(i).name.equals(obj.name) && woman.get(i).gender.equals(obj.gender))
			{
				woman.remove(i);
				System.out.println("해당정보 삭제되었습니다.");
				System.out.println();
				return;
			}
		}
		System.out.println("해당되는 사람이 없습니다.");	
		System.out.println();
	}
	
	static void match_blood(ArrayList<Blood> man, ArrayList<Blood> woman, Scanner in) {
		System.out.print("남자이름 입력 : ");
		String name_m = in.next();
		System.out.print("여자이름 입력 : ");
		String name_w = in.next();
		
		for(Blood obj1 : man) {
		if(obj1.name.equals(name_m)) {
			for(Blood obj2 : woman) {
			if(obj2.name.equals(name_w)) {
				System.out.printf("%s(남자 %s형)와(과) %s(여자 %s형)의 궁합결과 : \n", 
										obj1.name, obj1.type, obj2.name, obj2.type);
				switch(obj2.type) {
					case "A" :
					a_woman(obj1);
					break;
					case "B" :
					b_woman(obj1);
					break;
					case "AB" :
					ab_woman(obj1);
					break;
					case "O" :
					o_woman(obj1);
					break;
				}
			System.out.println();
			return;
			}//woman for
		}//man if
		}//man for
		System.out.println("해당되는 사람이 없습니다.");	
		System.out.println();
	}
	}
	static void a_woman(Blood obj1) {
		switch(obj1.type) {
		case "A" :
			System.out.println("진심으로 다가서면 안정적인 관계가 형성될거에요~");
		break;
		case "B" :
			System.out.println("남자의 고집불통, 여자가 얼마나 잘 참느냐에 달렸어요~");
		break;
		case "AB" :
			System.out.println("남자는 적극적, 여자가 다 잘 받아줘요~");
		break;
		case "O" :
			System.out.println("남자의 감정기복 심함, 알아서 리드해줘요~");
		break;
		}
	}
	static void b_woman(Blood obj1) {
		switch(obj1.type) {
		case "A" :
			System.out.println("남자가 답답하게 느껴짐, 하지만 진심으로 사랑한다는 것~");
		break;
		case "B" :
			System.out.println("둘다 파이팅이 넘침, 한명이 져주어야 해요~");
		break;
		case "AB" :
			System.out.println("서로 마음이 잘 통하는 커플, 대신 쉽게 질릴 수 있어요~");
		break;
		case "O" :
			System.out.println("여자 특유의 상냥함과 싹싹함이 오랜관계 유지해요~");
		break;
		}
	}
	static void ab_woman(Blood obj1) {
		switch(obj1.type) {
		case "A" :
			System.out.println("서로 알아가는데 시간이 오래 걸림");
			break;
		case "B" :
			System.out.println("말하는 것마다 호흡이 척척, 거리감 생기면 깨질 위험이 큼");
			break;
		case "AB" :
			System.out.println("둘다 활발한 편이라 금방 사이가 깊어지고 의기투합이 가능");
			break;
		case "O" :
			System.out.println("서로 자기 위주로 생각해서 다툼이 잦음, 활기찬 커플이 될 수 있음");
			break;
		}
	}
	static void o_woman(Blood obj1) {
		switch(obj1.type) {
		case "A" :
			System.out.println("여자가 남자에게 잘 맞춰줘야 해요~");
			break;
		case "B" :
			System.out.println("남자에게 잘해주면 기세 등등해짐, 결국 남자가 매달림");
			break;
		case "AB" :
			System.out.println("여자의 추진력과 남자의 판단력이 필요한 커플");
			break;
		case "O" :
			System.out.println("서로 쉽게 뜨거워지고 쉽게 식는 스타일, 충돌이 잦음");
			break;
		}
	}
}
