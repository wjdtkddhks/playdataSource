package chapter20;

import java.net.Socket;

public class ClientExmple4 {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("닉네임을 입력해주세요.");
		}
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9005);
			Thread thread1 = new SenderThread1(socket, args[0]);
			Thread thread2 = new ReceiverThread1(socket);
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
