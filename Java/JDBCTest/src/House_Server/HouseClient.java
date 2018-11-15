package House_Server;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class HouseClient implements ActionListener, Runnable {
	private String ip;
	private String id;
	private boolean status;
	private Socket socket = null;
	private BufferedReader reader = null;
	private PrintWriter writer = null;

	private JLabel introImage;
	private JPanel idInputPanel;
	private JLabel idLabel;
	private JTextField idInput;
	private JPanel psInputPanel;
	private JLabel psLabel;
	private JTextField psInput;
	private JButton idMake;
	private JButton psSearch;
	private JPanel optionPanel;
	private Container introPanel;
	private JButton idButton;
	private Container Panel1;
	private JPanel Panel2;

	private Container centerPanel;
	private CardLayout clayout;
	private JLabel firstLabel;
	private JLabel secondLabel;
	private JTextArea serverInput;
	private JPanel secondPanel;
	private ImageIcon dabang= new ImageIcon("C:/BigDeep/Java_Source/JDBCTest/src/images/dabang.png");

	private JPanel bottomPanel;
	private JTextField inputField;
	private JButton exitButton;

	private JPanel mainPanel;
	private JTextPane menubar;
	private CardLayout ilayout;
	private JPanel loginPanel;
	private JFrame frame;

	HouseClient(String ip) {
		this.ip = ip;

		introImage = new JLabel(dabang);
		idInputPanel = new JPanel();
		idLabel = new JLabel("아이디 : ");
		idInput = new JTextField(20);
		idInputPanel.add(idLabel);
		idInputPanel.add(idInput);
		psInputPanel = new JPanel();
		psLabel = new JLabel("비밀번호 : ");
		psInput = new JTextField(20);
		psInputPanel.add(psLabel);
		psInputPanel.add(psInput);
		Panel1 = new JPanel();
		Panel1.setLayout(new BoxLayout(Panel1, BoxLayout.Y_AXIS));
		Panel1.add(idInputPanel);
		Panel1.add(psInputPanel);
		idButton = new JButton("로그인");
		idButton.addActionListener(this);
		Panel2 = new JPanel();
		Panel2.setLayout(new BorderLayout());
		Panel2.add(Panel1, BorderLayout.CENTER);
		Panel2.add(idButton, BorderLayout.EAST);
		
		optionPanel = new JPanel();
		idMake = new JButton("회원가입");
		psSearch = new JButton("비밀번호찾기");
		optionPanel.add(idMake);
		optionPanel.add(psSearch);
		introPanel = new JPanel();
		introPanel.setLayout(new BoxLayout(introPanel, BoxLayout.Y_AXIS));
		introPanel.add(introImage);
		introPanel.add(Panel2);
		introPanel.add(optionPanel);

		firstLabel = new JLabel(dabang);
		secondLabel = new JLabel(dabang);
		serverInput = new JTextArea(" ", 10, 10);
		secondPanel = new JPanel();
		secondPanel.add(secondLabel);
		secondPanel.add(serverInput);
		centerPanel = new JPanel();
		clayout = new CardLayout();
		centerPanel.setLayout(clayout);
		centerPanel.add(firstLabel, "first");
		centerPanel.add(secondPanel, "second");// centerPanel 완성.

		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		exitButton = new JButton("로그아웃");
		inputField = new JTextField(15);
		inputField.addActionListener(this);
		bottomPanel.add(inputField, BorderLayout.CENTER);
		bottomPanel.add(exitButton, BorderLayout.EAST);

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		Font font = new Font("arian", Font.BOLD, 15);

		menubar = new JTextPane();
		
		StyledDocument doc = menubar.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		String menustr = "*** 메뉴 ***\n1. 회   원   등  록\n2. 매   물   확  인\n3. 관심상품  등록\n"
				+ "4. 관심상품  변경\n5. 관심상품  삭제 \n6. 회   원   삭  제 \n7. 종               료 \n=== 관 리 자 ===\n"
				+ "8. 회   원   출  력";
		menubar.setText(menustr);
		menubar.setFont(font);
		clayout.show(centerPanel, "first");
		loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		loginPanel.add(mainPanel, BorderLayout.CENTER);
		loginPanel.add(menubar, BorderLayout.EAST);
		
		
		ilayout = new CardLayout();
		frame = new JFrame("다나와방");
		frame.setLayout(ilayout);
		frame.add(introPanel, "intro");
		frame.add(loginPanel, "login");
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	void connectSever() {
		try {
			socket = new Socket(ip, 7777);
			System.out.println("[HouseClient] 접속 성공");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			writer.println("login/" + "id");

			Thread thread = new Thread(this);
			thread.start();
		} catch (Exception e) {
			System.out.println("[HouseClient] 접속 실패, connectSever()" + e.getMessage());
			System.out.println();
		}
	}

	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();

		if (obj == exitButton) {
			writer.println("logout/" + "id");
			clayout.show(centerPanel, "first");
			inputField.setText(" ");
			serverInput.setText(" ");
			writer.close();
		} else if (obj == idButton) {
			clayout.show(centerPanel, "second");
			connectSever();
		}try {
				if(socket != null) reader.close();
				if(socket != null) reader.close();
			}catch(Exception e) {
				System.out.println("[HouseClient] 종료 실패, close()" + e.getMessage());
				System.out.println();
			}
	}

	public void run() {
		String msg;
		status = true;
		while (status) {
			try {
				msg = reader.readLine();
				serverInput.append(msg);
				serverInput.setCaretPosition(serverInput.getDocument().getLength());
			} catch (Exception e) {
				System.out.println("[HouseClient] 메시지 읽기 실패, run()" + e.getMessage());
				System.out.println();
				status = false;
			}
		}
	}

	public static void main(String[] args) {
		HouseClient hc = new HouseClient("127.0.0.1");
	}
}
