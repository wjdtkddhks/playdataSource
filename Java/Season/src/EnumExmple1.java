
public class EnumExmple1 {

	public static void main(String[] args) {

			Day days[] = Day.values();
			
			for(Day day : days)
				System.out.println(day);
				
			printDay("MONDAY");
			printDay("SUNDAY");
		
	}
	
	static void printDay(String name) {
		
		Day day = Day.valueOf(name);
		System.out.println(day);
	}

}
