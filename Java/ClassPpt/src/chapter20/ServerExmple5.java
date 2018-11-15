package chapter20;

import java.net.*;

public class ServerExmple5 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9005);
			while(true) {
			socket = serverSocket.accept();
			PerClientThread thread1 = new PerClientThread(socket);
			thread1.start();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}


