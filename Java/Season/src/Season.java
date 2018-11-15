
enum Season {
		SPRING("봄", 1), SUMMER("여름", 2), FALL("가을", 3), WINTER("겨울", 4);
	
		final private String name;
		final private int num;
		
		Season(String name, int num){
			
			this.name = name;
			this.num = num;
		}
		
		String value() {
			
			return name;
			
		}
		
		int getnum() {
			
			return num;
		}
		
		
		
}
