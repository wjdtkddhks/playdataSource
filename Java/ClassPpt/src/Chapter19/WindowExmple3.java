package Chapter19;
import java.awt.*;
import javax.swing.*;
public class WindowExmple3 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("zoo program");
		frame.setLocation(300, 400);
		Container contentPane = frame.getContentPane();
		GridLayout layout = new GridLayout(3,2);
		contentPane.setLayout(layout);
		contentPane.add(new JButton("얼룩말"));
		contentPane.add(new JButton("기린"));
		contentPane.add(new JButton("송아지"));
		contentPane.add(new JButton("사자"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
	}

}
