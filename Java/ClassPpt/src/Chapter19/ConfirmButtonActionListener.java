package Chapter19;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ConfirmButtonActionListener implements ActionListener {
		JTextField text;
		JLabel label;
		
		ConfirmButtonActionListener(JTextField text, JLabel label){
			this.text = text;
			this.label = label;
		}
		
		public void actionPerformed(ActionEvent e) {
			String name = text.getText();
			label.setText("안녕" + name);
		}
}
