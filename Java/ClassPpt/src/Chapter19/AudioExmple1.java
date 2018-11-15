package Chapter19;
import java.awt.*;
import javax.swing.*;
public class AudioExmple1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("오디오");
		frame.setLocation(500,200);
		frame.setPreferredSize(new Dimension(500,70));
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JTextField text = new JTextField(30);
		JButton button = new JButton("플레이");
		contentPane.add(text);
		contentPane.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new PlayActionListener(text));
		frame.pack();
		frame.setVisible(true);

	}

}
