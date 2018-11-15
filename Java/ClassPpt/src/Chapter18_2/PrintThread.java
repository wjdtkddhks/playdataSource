package Chapter18_2;

public class PrintThread extends Thread {
		SharedArea sharedArea;
		PrintThread(SharedArea area){
			sharedArea = area;
		}
		public void run() {
			for(int cnt =0; cnt<3; cnt++) {
				synchronized(sharedArea) {
					int sum = sharedArea.account1.balance + sharedArea.account2.balance;
					System.out.println("돈 합계 : " + sum);}
			}
			try {
				Thread.sleep(1);
			}
			catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
}
