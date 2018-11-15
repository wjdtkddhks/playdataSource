package oneBy2;

import java.awt.BorderLayout;
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

class OnebyChat implements ActionListener, Runnable {

	private JLabel label;
	private JTextArea oneChat;
	private JTextField oneText;
	private JButton exitButton;
	private JPanel bottomPanel;
	private JFrame frame;
	private Thread thread;
	BufferedReader reader;
	PrintWriter writer;
	Socket socket;
	String ip;
	String takeId;
	String myId;
	int key;
	boolean status;

	OnebyChat() {
	}

	OnebyChat(String ip, String myId, String takeId) {
		this.ip = ip;
		this.myId = myId;
		this.takeId = takeId;

		label = new JLabel(myId + "(나)와 " + takeId + "(상대방)" + "와(과) 1:1채팅중입니다.");

		oneChat = new JTextArea(" ", 10, 30);
		oneChat.setEditable(false);
		JScrollPane jsp = new JScrollPane(oneChat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		bottomPanel = new JPanel(new BorderLayout());
		oneText = new JTextField(30);
		oneText.addActionListener(this);
		exitButton = new JButton("종료");
		exitButton.addActionListener(this);
		bottomPanel.add(oneText, BorderLayout.CENTER);
		bottomPanel.add(exitButton, BorderLayout.EAST);

		frame = new JFrame();
		frame.add(label, BorderLayout.NORTH);
		frame.add(jsp, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.SOUTH);

		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

	public void connectServer(boolean send) {
		try {
			socket = new Socket(ip, 8888);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			if (send)
				writer.println(myId + "/oneTalk/" + takeId);
			else
				writer.println(myId + "/createTake/" + takeId + "/" + Integer.toString(key));

			thread = new Thread(this);
			thread.start();
		} catch (Exception e) {
			System.out.println("[OnebyChat]connectServer()Exp발생");
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();

		if (obj == oneText) {
			writer.println(oneText.getText() + "/oneTo/" + myId + "/" + takeId + "/" + Integer.toString(key));
			oneText.setText(" ");
		} else if (obj == exitButton) {
			status = false;
			frame.setVisible(false);
		}
	}

	public void run() {
		String str;
		String[] rstr;

		status = true;
		while (status) {
			try {
				str = reader.readLine();
				rstr = str.split("/");

				if (rstr[1].equals("OnlyKey"))
					key = Integer.parseInt(rstr[2]);
				else if (rstr[1].equals("oneTo")) {
					if (rstr[2].equals(myId))
						oneChat.append(myId + ">" + rstr[0] + "\n");
					else
						oneChat.append(takeId + ">" + rstr[0] + "\n");
				}
				oneChat.setCaretPosition(oneChat.getDocument().getLength());
			} catch (IOException e) {
				status = false;
			}
		}
	}
}