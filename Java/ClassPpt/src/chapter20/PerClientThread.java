package chapter20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClientThread extends Thread {

	Socket socket;
	PrintWriter writer;
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());

	PerClientThread(Socket socket) {
		this.socket = socket;
		try {
			writer = new PrintWriter(socket.getOutputStream());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		list.add(writer);
	}

	public void run() {
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = reader.readLine();
			sendAll("#" + name + "님이 입장하였습니다.");
			while (true) {
				String str = reader.readLine();
				if (str.equals("bye"))
					break;
				sendAll("#" + name + ">" + str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			list.remove(writer);
			sendAll("#" + name + "님이 나가셨습니다.");
			try {
				socket.close();
			} catch (Exception ignored) {
			}
		}
	}

	public void sendAll(String str) {
		for (PrintWriter writer : list) {
			writer.println(str);
			writer.flush();
		}
	}
}
