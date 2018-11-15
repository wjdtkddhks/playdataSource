package chapter20;

import java.io.*;
import java.net.Socket;

public class ReceiverThread1 extends Thread {
	Socket socket;

	ReceiverThread1(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String str = reader.readLine();
				if (str == null)
					break;
				System.out.println(str);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
