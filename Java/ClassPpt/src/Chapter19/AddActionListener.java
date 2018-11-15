package Chapter19;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;
public class AddActionListener implements ActionListener{
		
	JTable table;
	JTextField text1, text2, text3;
	
	AddActionListener(JTable table, JTextField text1, JTextField text2, JTextField text3){
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;		
	}
	public void actionPerformed(ActionEvent e) {
		String obj[] = {text1.getText(), text2.getText(), text3.getText()};
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(obj);
	}
	
}
