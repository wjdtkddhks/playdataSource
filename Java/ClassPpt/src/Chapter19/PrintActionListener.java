package Chapter19;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.*;
public class PrintActionListener implements ActionListener {
		
		JTable table;
			
		PrintActionListener(JTable table){
			this.table = table;
		}
		
		public void actionPerformed(ActionEvent e) {
			TableModel model = table.getModel();
			int rownum = model.getRowCount();
			int colnum = model.getColumnCount();
			
			for(int i = 0; i<colnum; i++)
				System.out.print(model.getColumnName(i) + "\t");
			System.out.println();
			
			for(int i =0; i<rownum; i++) {
				for(int j=0; j<colnum; j++) {
					System.out.print(table.getValueAt(i, j) + "\t");
				}
				System.out.println();
			}
		}
}
