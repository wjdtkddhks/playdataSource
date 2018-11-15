package Chapter19;
import java.awt.*;
import javax.swing.*;
public class WindowExmple5 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("phone");
		Container contentPane = frame.getContentPane();
		frame.setLocation(500, 300);
		BoxLayout layout = new BoxLayout(contentPane, BoxLayout.X_AXIS);
		contentPane.setLayout(layout);
		contentPane.add(new JButton("아이폰"));
		contentPane.add(new JButton("갤럭시"));
		contentPane.add(new JButton("샤오미"));
		contentPane.add(new JButton("블랙베리"));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
