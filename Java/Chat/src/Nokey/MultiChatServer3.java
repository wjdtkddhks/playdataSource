package Nokey;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiChatServer3 {

	private ServerSocket ss = null;
	private Socket s = null;

	static ArrayList<ChatThread> list = new ArrayList<ChatThread>();
	static ArrayList<String> idvolum = new ArrayList<String>();

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
		MultiChatServer3 server = new MultiChatServer3();
		server.start();
	}

	void msgSendAll(String str) {
		for (ChatThread ct : list)
			ct.writer.println(str);
	}

	void StartOneChat(String msg) {
		String[] rmsg = msg.split("/");
		for (ChatThread ct : list) {
			if (ct.myId.equals(rmsg[2]))
				ct.writer.println(msg);
		}
	}

	void msgSendOneBy(String msg) {
		String[] rmsg = msg.split("/");

		for (ChatThread ct : list) {
			if (ct.myId.equals(rmsg[2]) && ct.takeId.equals(rmsg[3]))
				ct.writer.println(msg);
			else if(ct.myId.equals(rmsg[3]) && ct.takeId.equals(rmsg[2]))
				ct.writer.println(msg);
		}
	}

	class ChatThread extends Thread {
		String msg;
		String[] rmsg;
		String myId;
		String takeId;

		private BufferedReader reader;
		private PrintWriter writer;

		public void run() {
			boolean status = true;
			System.out.println("###ChatThread start");
			try {
				reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
				writer = new PrintWriter(s.getOutputStream(), true);

				while (status) {
					msg = reader.readLine();
					rmsg = msg.split("/");
					if (rmsg[1].equals("logout")) {
						myId = rmsg[0];
						list.remove(this);
						idvolum.remove(myId);
						msgSendAll("server/" + rmsg[0] + "님이 나가셨습니다.");
						msgSendAll(myId + "/" + "out");
						status = false;
					} else if (rmsg[1].equals("login")) {
						myId = rmsg[0];
						msgSendAll("server/" + rmsg[0] + "님이 입장하였습니다.");
						msgSendAll(myId + "/" + "in");
						for (String str : idvolum) {
							writer.println(str + "/" + "in");
						}
						idvolum.add(myId);
					} else if (rmsg[1].equals("oneTalk")) {
						StartOneChat(msg);
						myId = rmsg[0];
						takeId = rmsg[2];
					} else if (rmsg[1].equals("oneTo")) {
						msgSendOneBy(msg);
					} else if (rmsg[1].equals("createTake")) {
						myId = rmsg[0];
						takeId = rmsg[2];
						continue;
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
