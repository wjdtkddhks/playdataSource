package Chapter19;
import java.awt.*;
import javax.swing.*;
public class GraphicExmple2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("성적프로그램");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(400,350));
		Container contentPane = frame.getContentPane();
		DrawingPanel draw = new DrawingPanel();
		contentPane.add(draw, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		JTextField kor = new JTextField(3);
		JTextField eng = new JTextField(3);
		JTextField math = new JTextField(3);
		panel.add(new JLabel("국어"));
		panel.add(kor);
		panel.add(new JLabel("영어"));
		panel.add(eng);
		panel.add(new JLabel("수학"));
		panel.add(math);
		JButton button1 = new JButton("그리기");
		panel.add(button1);
		
		contentPane.add(panel, BorderLayout.SOUTH);
		button1.addActionListener(new DrawingActionListener(kor, eng, math, draw));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
