package first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiChatServer2 {

	private ServerSocket ss = null;
	private Socket s = null;

	static ArrayList<ChatThread> list = new ArrayList<ChatThread>();

	public void start() {
		try {
			ss = new ServerSocket(8888);
			System.out.println("server start");
			while (true) {
				s = ss.accept();
				ChatThread chat = new ChatThread();
				list.add(chat);
				chat.start();
			}
		} catch (Exception e) {
			System.out.println("[MultiChatServer] start () EX 발생");
		}
	}

	public static void main(String[] args) {
		MultiChatServer2 server = new MultiChatServer2();
		server.start();
	}

	void msgSendAll(String str) {
		for (ChatThread ct : list)
			ct.writer.println(str);
	}

	class ChatThread extends Thread {
		String msg;
		String[] rmsg;
		String id;

		private BufferedReader reader;
		private PrintWriter writer;

		public void run() {
			boolean status = true;
			System.out.println("###ChatThread start");
			try {
				reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
				writer = new PrintWriter(s.getOutputStream(), true);

				for (ChatThread cht : list)
					cht.writer.println(id + "/" + "in");

				while (status) {
					msg = reader.readLine();
					rmsg = msg.split("/");
					if (rmsg[1].equals("logout")) {
						list.remove(this);
						msgSendAll("server/" + rmsg[0] + "님이 나가셨습니다.");
						msgSendAll(id + "/" + "out");
						status = false;
					} else if (rmsg[1].equals("login")) {
						id = rmsg[0];
						msgSendAll("server/" + rmsg[0] + "님이 입장하였습니다.");
						msgSendAll(id + "/" + "in");
					} else {
						msgSendAll(msg);
					}
				}
				this.interrupt();
				System.out.println("##" + this.getName() + "logout");
			} catch (Exception e) {
				list.remove(this);
				System.out.println("[ChatThread]run( ) Ex발생");
			}
		}
	}
}
