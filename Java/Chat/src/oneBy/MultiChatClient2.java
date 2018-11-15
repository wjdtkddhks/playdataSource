package oneBy;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MultiChatClient2 implements ActionListener, Runnable {
	private String ip;
	private String id;
	private Socket socket;
	private BufferedReader reader = null;
	private PrintWriter writer = null;

	private JPanel loginPanel;
	private JButton loginButton;
	private JLabel label1;
	private JTextField idInput;

	private JPanel logoutPanel;
	private JLabel label2;
	private JButton logoutButton;

	private JPanel msgPanel;
	private JTextField msgInput;
	private JButton exitButton;
	private JFrame frame;

	private JTextArea msgOut;
	private Container tab;
	private CardLayout clayout;
	private Thread thread;
	private Thread thread_1;
	private Thread thread_2;

	boolean status;
	ArrayList<String> idList;
	LinkedList<OnebyChat> chatList = new LinkedList<OnebyChat>();
	String str;
	String[] rstr;
	JTextArea idListArea;
	JLabel idLabel;
	JPanel idPanel;
	OnebyChat takeOne;
	OnebyChat sendOne;

	public MultiChatClient2(String ip) {
		this.ip = ip;
		frame = new JFrame(";;멀티챗;;");

		loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		idInput = new JTextField(15);
		loginButton = new JButton("로그인");
		loginButton.addActionListener(this);
		label1 = new JLabel("대화명");
		loginPanel.add(label1, BorderLayout.WEST);
		loginPanel.add(idInput, BorderLayout.CENTER);
		loginPanel.add(loginButton, BorderLayout.EAST);

		logoutPanel = new JPanel();
		logoutPanel.setLayout(new BorderLayout());
		label2 = new JLabel();
		logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(this);
		logoutPanel.add(label2, BorderLayout.CENTER);
		logoutPanel.add(logoutButton, BorderLayout.EAST);

		tab = new JPanel();
		clayout = new CardLayout();
		tab.setLayout(clayout);
		tab.add(loginPanel, "login");
		tab.add(logoutPanel, "logout");

		msgOut = new JTextArea(" ", 10, 30);
		msgOut.setEditable(false);
		JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		msgPanel = new JPanel();
		msgPanel.setLayout(new BorderLayout());
		msgInput = new JTextField(30);
		msgInput.addActionListener(this);
		exitButton = new JButton("종료");
		exitButton.addActionListener(this);
		msgPanel.add(msgInput, BorderLayout.CENTER);
		msgPanel.add(exitButton, BorderLayout.EAST);

		idPanel = new JPanel();
		idPanel.setLayout(new BorderLayout());
		idLabel = new JLabel("아이디 리스트", SwingConstants.CENTER);
		idLabel.setSize(10, 40);
		idListArea = new JTextArea(" ", 5, 15);
		idListArea.setEditable(false);
		JScrollPane idScroll = new JScrollPane(idListArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		idPanel.add(idLabel, BorderLayout.NORTH);
		idPanel.add(idScroll, BorderLayout.CENTER);

		JPanel leftPanel = new JPanel(new BorderLayout());

		leftPanel.add(tab, BorderLayout.NORTH);
		leftPanel.add(jsp, BorderLayout.CENTER);
		leftPanel.add(msgPanel, BorderLayout.SOUTH);

		frame.add(leftPanel, BorderLayout.CENTER);
		frame.add(idPanel, BorderLayout.EAST);

		clayout.show(tab, "login");
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void connectServer() {
		try {
			socket = new Socket(ip, 8888);
			System.out.println("[Client]Server 연결 성공!!");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			writer.println(id + "/" + "login");

			idList = new ArrayList<String>();

			str = reader.readLine();
			rstr = str.split("/");
			if (rstr[1].equals("in"))
				idList.add(rstr[0]);
			for (String str : idList)
				idListArea.append(str + "\n");

			thread = new Thread(this);
			thread.start();
		} catch (Exception e) {
			System.out.println("[MultiChatClient]connectServer()Exp발생");
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		String msg;
		String[] rmsg;

		if (obj == exitButton) {
			System.exit(0);
		} else if (obj == loginButton) {
			id = idInput.getText();
			label2.setText("대화명 : " + id);
			clayout.show(tab, "logout");
			connectServer();
		} else if (obj == logoutButton) {
			writer.println(id + "/" + "logout");
			msgOut.setText(" ");
			idListArea.setText(" ");
			clayout.show(tab, "login");
			writer.close();
			try {
				reader.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			status = false;
		} else if (obj == msgInput) {
			msg = msgInput.getText();
			rmsg = msg.split("/");
			if (rmsg[0].equals("귓속말")) {
				sendOne = new OnebyChat(reader, writer, id, rmsg[1]); // rmsg[1] 받는 사람 id
				thread_2 = new Thread(sendOne);
				thread_2.start();
				chatList.add(sendOne);
			}
			writer.println(id + "/" + msg);
			msgInput.setText(" ");
		}
	}

	public void run() {
		String msg;
		String[] rmsg;

		status = true;
		while (status) {
			try {
				msg = reader.readLine();
				rmsg = msg.split("/");
				if (rmsg[1].equals("in")) {
					idList.add(rmsg[0]);
					idListArea.append(rmsg[0] + "\n");
				} else if (rmsg[1].equals("out")) {
					idList.remove(rmsg[0]);
					idListArea.setText(" ");
					for (String str : idList)
						idListArea.append(str + "\n");
				} else if (rmsg[1].equals("귓속말")) {
					takeOne = new OnebyChat(reader, writer, id, rmsg[0]);
					thread_1 = new Thread(takeOne);
					thread_1.start();
					chatList.add(takeOne);
				} else if (rmsg[1].equals("귓속말중")) {
					continue;
				} else {
					msgOut.append(rmsg[0] + ">" + rmsg[1] + "\n");
				}
				msgOut.setCaretPosition(msgOut.getDocument().getLength());
			} catch (IOException e) {
				status = false;
			}
		}
		System.out.println("[MultiChatClient]" + thread.getName() + "종료됨");
	}

	public static void main(String[] args) {
		MultiChatClient2 mcc = new MultiChatClient2("127.0.0.1");
	}
}
