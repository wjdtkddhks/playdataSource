package Chapter18;

public class AlphabetThread extends Thread{
	public void run() {	
		for(char ch = 'A'; ch<='Z'; ch++) {
			System.out.print(ch);
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
		System.out.println();
	}
}
