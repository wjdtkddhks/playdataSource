package Chapter19;
import java.applet.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;
public class PlayActionListener implements ActionListener {
		JTextField text;
		
		PlayActionListener(JTextField text){
			this.text = text;
		}
		
		public void actionPerformed(ActionEvent e) {
			try {
			File file = new File(text.getText());
			AudioClip audio = Applet.newAudioClip(file.toURL());
			audio.play();
			}
			catch(MalformedURLException mue) {
				JOptionPane.showMessageDialog(text, "잘못된 파일입니다.", "에러메시지", JOptionPane.ERROR_MESSAGE);		
			}
		}
}
