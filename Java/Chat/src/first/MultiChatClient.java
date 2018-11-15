package first;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatClient implements ActionListener, Runnable {
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

	boolean status;

	public MultiChatClient(String ip) {
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

		frame.add(tab, BorderLayout.NORTH);
		frame.add(jsp, BorderLayout.CENTER);
		frame.add(msgPanel, BorderLayout.SOUTH);

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

			thread = new Thread(this);
			thread.start();
		} catch (Exception e) {
			System.out.println("[MultiChatClient]connectServer()Exp발생");
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();

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
			writer.println(id + "/" + msgInput.getText());
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
				msgOut.append(rmsg[0] + ">" + rmsg[1] + "\n");
				msgOut.setCaretPosition(msgOut.getDocument().getLength());
			} catch (IOException e) {
				status = false;
			}
		}
		System.out.println("[MultiChatClient]" + thread.getName() + "종료됨");
	}

	public static void main(String[] args) {
		MultiChatClient mcc = new MultiChatClient("127.0.0.1");
	}

}
