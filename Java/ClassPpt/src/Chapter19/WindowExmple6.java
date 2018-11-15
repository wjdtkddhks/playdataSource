package Chapter19;
import java.awt.*;
import javax.swing.*;
public class WindowExmple6 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("개인정보");
		frame.setLocation(200, 300);
		Container contentPane = frame.getContentPane();
		JPanel panel= new JPanel(new GridLayout(3,2));
	//	JPanel panel = new JPanel();
	//	GridLayout layout = new GridLayout(3,2);
	//	panel.setLayout(layout);
		panel.add(new JLabel("이름"));
		panel.add(new JTextField());
		panel.add(new JLabel("주소"));
		panel.add(new JTextField());
		panel.add(new JLabel("전화번호"));
		panel.add(new JTextField());
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(new JButton("확인"), BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
