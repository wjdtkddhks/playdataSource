package Chapter19;
import java.awt.event.*;
import javax.swing.*;
public class LoadActionListener implements ActionListener {
	ImagePane image;
	JTextField text;
	
	LoadActionListener(ImagePane image, JTextField text){
		this.image = image;
		this.text = text;
	}
	public void actionPerformed(ActionEvent e) {
		image.setPath(text.getText());
		image.repaint();
	}
}
