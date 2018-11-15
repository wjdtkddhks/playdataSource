package Chapter14;

public class SystemExmple7 {

	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("Usage : java SystemExampe7 <정수> <정수>");
			System.exit(1);
		}
		
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			System.out.println("sum : " + (num1+num2));
			System.exit(0);
		}
		catch(NumberFormatException e) {
			System.err.println("잘못된 입력입니다.");
			System.exit(-1);
		}
	}

}
