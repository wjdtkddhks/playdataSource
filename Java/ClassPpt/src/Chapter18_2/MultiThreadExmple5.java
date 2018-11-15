package Chapter18_2;

public class MultiThreadExmple5 {

	public static void main(String[] args) {
		SharedArea area = new SharedArea();
		TransferThread thread1 = new TransferThread(area);
		PrintThread thread2 = new PrintThread(area);
		
		area.account1 = new Account("111-111-11111", "이몽룡", 20000000);
		area.account2 = new Account("222-222-22222", "성춘향", 10000000);
		
		thread1.start();
		thread2.start();

	}

}
