package Chapter19;
import java.awt.*;
import javax.swing.*;
public class WindowExmple7 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("참가자");
		frame.setLocation(400, 500);
		frame.setPreferredSize(new Dimension(300,150));
		Container contentPane = frame.getContentPane();
		String str[] = {"이름", "나이", "성별"};
		Object data[][] = {{"박기자", 30, '남'}, {"김기자", 28, '남'}, {"서기자", 27, '여'}};
		JTable table = new JTable(data, str);
		JScrollPane pane = new JScrollPane(table);
		contentPane.add(pane, BorderLayout.CENTER);
		JButton button = new JButton("출력");
		button.addActionListener(new PrintActionListener(table));
		contentPane.add(button, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		}
	}


