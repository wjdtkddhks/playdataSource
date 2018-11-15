package oneBy;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
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
	BufferedReader reader;
	PrintWriter writer;
	Socket socket;
	String takeId;
	String myId;
	boolean status;

	OnebyChat() {
	}

	OnebyChat(BufferedReader reader, PrintWriter writer, String myId, String takeId) {
		this.reader = reader;
		this.writer = writer;
		this.myId = myId;
		this.takeId = takeId;

		label = new JLabel(takeId + "와 1:1채팅중입니다.");

		oneChat = new JTextArea(" ", 10, 30);
		JScrollPane jsp = new JScrollPane(oneChat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		oneChat.setEditable(false);

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

	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();

		if (obj == oneText) {
			writer.println(myId + "/" + "귓속말중" + "/" + takeId + "/" + oneText.getText());
			oneText.setText(" ");
			oneChat.append(myId + ">" + oneText.getText() + "\n");
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
				if (rstr[1].equals("귓속말중") && rstr[0].equals(takeId))
					oneChat.append(rstr[0] + ">" + rstr[3]);
				oneChat.setCaretPosition(oneChat.getDocument().getLength());
			} catch (IOException e) {
				status = false;
			}
		}
	}
}