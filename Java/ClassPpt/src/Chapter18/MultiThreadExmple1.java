package Chapter18;

public class MultiThreadExmple1 {

	public static void main(String[] args) {
		Thread thread = new DigitThread();
		thread.start();
		
		for(char ch = 'A'; ch<='Z'; ch++) {
			System.out.print(ch);
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			System.err.println(e.getMessage());
		}
		}
	}

}
