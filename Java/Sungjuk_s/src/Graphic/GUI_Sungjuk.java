package Graphic;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class GUI_Sungjuk {

	public static void main(String[] args) {
		JFrame frame = new JFrame("성적프로그램");
		frame.setLocation(100,200);
		frame.setPreferredSize(new Dimension(500, 580));
		Container contentPane = frame.getContentPane();
		String str[] = {"학번", "이름", "국어", "영어", "수학", "총점", "평균", "등급"};
		DefaultTableModel model = new DefaultTableModel(str, 0);
		JTable table = new JTable(model);
		
		table.setPreferredScrollableViewportSize(new Dimension(500,150));
		
		int widths[] = {70, 70, 50, 50, 50, 50, 50, 50};
		for(int i=0; i<widths.length; i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(widths[i]);
		}
		contentPane.add(new JScrollPane(table), BorderLayout.NORTH);
		
		DrawingPanel drawingPanel = new DrawingPanel();
		contentPane.add(drawingPanel, BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();		
		JTextField hakbun = new JTextField(5);
		JTextField irum = new JTextField(5);
		JTextField kor = new JTextField(3);
		JTextField eng = new JTextField(3);
		JTextField math = new JTextField(3);
		panel1.add(new JLabel("학번 :"));
		panel1.add(hakbun);
		panel1.add(new JLabel("이름 : "));
		panel1.add(irum);
		panel1.add(new JLabel("국어 : "));
		panel1.add(kor);
		panel1.add(new JLabel("영어 : "));
		panel1.add(eng);
		panel1.add(new JLabel("수학 : "));
		panel1.add(math);
		
		JPanel panel2 = new JPanel();
		JButton button1 = new JButton("추가");
		JButton button2 = new JButton("삭제");
		JButton button3 = new JButton("수정");
		JButton button4 = new JButton("그래프출력");
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		
		JPanel panel3 = new JPanel(new BorderLayout());
		panel3.add(panel1, BorderLayout.CENTER);
		panel3.add(panel2, BorderLayout.SOUTH);
		contentPane.add(panel3, BorderLayout.SOUTH);
	
		button1.addActionListener(new T_EventAction(table, hakbun, irum, kor, eng, math));
		button2.addActionListener(new T_EventAction(table));
		button3.addActionListener(new T_EventAction(table, hakbun, kor, eng, math));
		button4.addActionListener(new T_EventAction(table, drawingPanel));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
