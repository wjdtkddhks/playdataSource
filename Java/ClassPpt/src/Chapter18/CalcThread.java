package Chapter18;

public class CalcThread extends Thread {
		SharedArea sharedArea;
		
		public void run() {
			double tot = 0.0;
			for(int cnt =1; cnt<1000000000; cnt+=2) {
				if(cnt/2%2 == 0)
					tot+=1.0/cnt;
				else
					tot-=1.0/cnt;
				
				sharedArea.result = tot *4;
				sharedArea.isReady = true;
			}
		}
}
