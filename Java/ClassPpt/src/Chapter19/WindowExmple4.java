package Chapter19;
import java.awt.*;
import javax.swing.*;

public class WindowExmple4 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("cafe");
		Container contentPane = frame.getContentPane();
		frame.setLocation(400, 500);
		FlowLayout layout = new FlowLayout();
		contentPane.setLayout(layout);
		contentPane.add(new JButton("아메리카노"));
		contentPane.add(new JButton("카푸치노"));
		contentPane.add(new JButton("카페라떼"));
		contentPane.add(new JButton("롱블랙"));
		contentPane.add(new JButton("아포카도"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

}
