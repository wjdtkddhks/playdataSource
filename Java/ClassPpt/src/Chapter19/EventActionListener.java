package Chapter19;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;

public class EventActionListener implements ActionListener{
	JTable table;
	JTextField text1, text2, text3;
	
	EventActionListener(JTable table, JTextField text1, JTextField text2, JTextField text3){
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;		
	}
	EventActionListener(JTable table){
		this.table = table;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("추가"))
			input();
		else
			remove();	
	}
	public void input() {
		String str[] = {text1.getText(), text2.getText(), text3.getText()};
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addRow(str);
	}
	public void remove() {
		int row = table.getSelectedRow();
		if(row == -1)
			return;
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.removeRow(row);
	}

}
