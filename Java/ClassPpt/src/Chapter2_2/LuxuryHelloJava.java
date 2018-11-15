package Chapter2_2;


public class LuxuryHelloJava {

	public static void main(String[] args) {
		
		printCharacter('*', 30); //prinCharacter라는 메서드를 호출 두개의 실인수를 대입한 메서드 호출
		System.out.println("Hello, Java");
		printCharacter('-', 30);

	}
	static void printCharacter(char chr, int num) {
		
		for(int c=0; c<num; c++)
			System.out.print(chr);
		
		System.out.println();
		
		return;
	}

	

}
