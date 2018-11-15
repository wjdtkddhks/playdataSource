package Chapter19;
import java.awt.*;
import javax.swing.*;
public class ImageExmple1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("이미지");
		frame.setLocation(500,200);
		frame.setPreferredSize(new Dimension(500,400));
		Container contentPane = frame.getContentPane();
		ImagePane image = new ImagePane();
		contentPane.add(image, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		JTextField text = new JTextField(30);
		JButton button = new JButton("이미지로드");
		panel.add(text);
		panel.add(button);
		contentPane.add(panel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new LoadActionListener(image, text));
		frame.pack();
		frame.setVisible(true);

	}

}
