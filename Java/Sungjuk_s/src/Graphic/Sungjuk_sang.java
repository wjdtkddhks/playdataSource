package Graphic;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class Sungjuk_sang {

	public static void main(String[] args) {
		JFrame frame = new JFrame("성적프로그램");
		frame.setLocation(100,200);
		frame.setPreferredSize(new Dimension(500, 550));
		Container contentPane = frame.getContentPane();
		String str[] = {"학번", "이름", "국어", "영어", "수학", "총점", "평균", "등급"};
		DefaultTableModel model = new DefaultTableModel(str, 0);
		JTable table = new JTable(model);
		int widths[] = {70, 70, 50, 50, 50, 50, 50, 50};
		for(int i=0; i<widths.length; i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(widths[i]);
		}
		   
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel panel1 = new JPanel();		
		JTextField text1 = new JTextField(5);
		JTextField text2 = new JTextField(5);
		JTextField text3 = new JTextField(3);
		JTextField text4 = new JTextField(3);
		JTextField text5 = new JTextField(3);
		panel1.add(new JLabel("학번 :"));
		panel1.add(text1);
		panel1.add(new JLabel("이름 : "));
		panel1.add(text2);
		panel1.add(new JLabel("국어 : "));
		panel1.add(text3);
		panel1.add(new JLabel("수학 : "));
		panel1.add(text4);
		panel1.add(new JLabel("영어 : "));
		panel1.add(text5);
		
		JPanel panel2 = new JPanel();
		JButton button1 = new JButton("추가");
		JButton button2 = new JButton("삭제");
		JButton button3 = new JButton("수정");
		JButton button4 = new JButton("그래프출력");
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel.add(panel1, BorderLayout.CENTER);
		panel.add(panel2, BorderLayout.SOUTH);
		
		ImagePanel imagePanel = new ImagePanel();
		
		table.setPreferredScrollableViewportSize(new Dimension(150,100));
		
		contentPane.add(new JScrollPane(table), BorderLayout.NORTH);
		contentPane.add(imagePanel, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		button1.addActionListener(new EventAction(table, text1, text2, text3, text4, text5));
		button2.addActionListener(new EventAction(table, text1, text2, text3, text4, text5));
		button3.addActionListener(new EventAction(table, text1, text2, text3, text4, text5));
		button4.addActionListener(new EventAction(table, imagePanel, text3, text4, text5));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
