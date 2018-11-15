package Chapter19;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WindowExample1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello, Java");
		frame.setLocation(500, 400);
		//frame.setPreferredSize(new Dimension(300,200));
		Container contentPane = frame.getContentPane();
		JTextField text = new JTextField();
		JButton button = new JButton("확인");
		JLabel label = new JLabel("안녕", SwingConstants.HORIZONTAL);
		contentPane.add(label, BorderLayout.SOUTH);
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		ActionListener action = new ConfirmButtonActionListener(text, label);
		button.addActionListener(action);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
