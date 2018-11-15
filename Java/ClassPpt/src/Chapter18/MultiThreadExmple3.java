package Chapter18;

public class MultiThreadExmple3 {

	public static void main(String[] args) {
			Thread thread = new Thread(new SmallLetters());
			thread.start();
			
			for(int cnt=0; cnt<10; cnt++) 
				System.out.print(cnt);
	}

}
