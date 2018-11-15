package Chapter19;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class WindowExmple9 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("참가자 명단");
		frame.setLocation(400, 500);
		frame.setPreferredSize(new Dimension(500, 200));
		Container contentPane = frame.getContentPane();
		String str []= {"이름", "나이", "전화번호"};
		DefaultTableModel model = new DefaultTableModel(str, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		JPanel pane = new JPanel();
		pane.add(new JLabel("이름 : "));
		JTextField text1 = new JTextField(5);
		JTextField text2 = new JTextField(3);
		JTextField text3 = new JTextField(6);
		pane.add(text1);
		pane.add(new JLabel("성별 : "));
		pane.add(text2);
		pane.add(new JLabel("전화번호 : "));
		pane.add(text3);
		JButton button1 = new JButton("추가");
		JButton button2 = new JButton("삭제");
		pane.add(button1);
		pane.add(button2);
		/*button1.addActionListener(new AddActionListener(table, text1, text2, text3));
		button2.addActionListener(new RemoveActionListener(table));*/
		button1.addActionListener(new EventActionListener(table, text1, text2, text3));
		button2.addActionListener(new EventActionListener(table));
		contentPane.add(pane, BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
