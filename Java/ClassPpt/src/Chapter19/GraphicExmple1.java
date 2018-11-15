package Chapter19;
import java.awt.*;
import javax.swing.*;

public class GraphicExmple1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("자동차 프로그램");
		frame.setLocation(500,200);
		frame.setPreferredSize(new Dimension(400,300));
		Container contentPane = frame.getContentPane();
		CarDrawingPanel draw = new CarDrawingPanel();
		contentPane.add(draw);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
