package Chapter19;
import javax.swing.*;
import java.awt.event.*;

public class DrawingActionListener implements ActionListener {
	JTextField txt1, txt2, txt3;
	DrawingPanel draw;
	
	DrawingActionListener(JTextField txt1, JTextField txt2, JTextField txt3, DrawingPanel draw){
		this.txt1 = txt1;
		this.txt2 = txt2;
		this.txt3 = txt3;
		this.draw = draw;		
	}
	public void actionPerformed(ActionEvent e) {
		try {
			int kor = Integer.parseInt(txt1.getText());
			int eng = Integer.parseInt(txt2.getText());
			int math = Integer.parseInt(txt3.getText());
			draw.setScore(kor, eng, math);
			draw.repaint();
		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(draw, "잘못된 숫자 포맷입니다.", "에러메시지", JOptionPane.ERROR_MESSAGE);
			
		}
	}

}
