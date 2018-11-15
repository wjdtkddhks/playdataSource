package Multi;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class T_EventAction implements ActionListener{
	
	JTable table;
	JTextField txtHakbun, txtIrum, txtKor, txtEng, txtMath;
	
	T_EventAction(){}
	
	T_EventAction(JTable table, JTextField txtHakbun, JTextField txtIrum, JTextField txtKor, JTextField txtEng, JTextField txtMath){
		this.table = table;
		this.txtHakbun = txtHakbun;
		this.txtIrum = txtIrum;
		this.txtKor = txtKor;
		this.txtEng = txtEng;
		this.txtMath = txtMath;		
	}
	T_EventAction(JTable table){
		this.table = table;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("추가"))
			insert();
		else if(e.getActionCommand().equals("삭제"))
			delete();
		else if(e.getActionCommand().equals("삭제"))
			update();	
	}
	
	void insert() {
		Sungjuk obj = new Sungjuk();
		int i, rowNum, flag=0;
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		obj.hakbun = txtHakbun.getText().trim();
		
		rowNum = model.getRowCount();
		for(i=0; i<rowNum; i++) {
			String table_hakbun = model.getValueAt(i, 0).toString().trim();
			if(table_hakbun.equals(obj.hakbun))
			{
				flag =1;
				break;
			}
		}
		if(flag ==0) {
			obj.irum = txtIrum.getText().trim();
			obj.kor = Integer.parseInt(txtKor.getText());
			obj.eng = Integer.parseInt(txtEng.getText());
			obj.math = Integer.parseInt(txtMath.getText());
			obj.process();
			
			Object arr[] = new Object[8];
			arr[0] = obj.hakbun;
			arr[1] = obj.irum;
			arr[2] = obj.kor;
			arr[3] = obj.eng;
			arr[4] = obj.math;
			arr[5] = obj.tot;
			arr[6] = obj.avg;
			arr[7] = obj.grade;
			
			model.addRow(arr);
			System.out.println("학번" + obj.hakbun + " 추가 성공!");
		}
		else
			System.out.println("학번" + obj.hakbun + " 중복오류로 추가 실패!");
		
		not();
	}
	
	void delete() {
		int row = table.getSelectedRow();
		if(row == -1)
			return;
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		String hakbun = model.getValueAt(row, 0).toString().trim();
		model.removeRow(row);
		System.out.println("학번" + hakbun + " 삭제성공!");
	}
	
	void update() {
		int i, rowNum, flag=0;
		String table_hakbun =null;
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		Sungjuk obj = new Sungjuk();
		
		obj.hakbun = txtHakbun.getText().trim();
		obj.kor = Integer.parseInt(txtKor.getText());
		obj.eng = Integer.parseInt(txtEng.getText());
		obj.eng = Integer.parseInt(txtMath.getText());
		obj.process();
		
		rowNum = model.getRowCount();
		for(i=0; i<rowNum; i++) {
			table_hakbun = model.getValueAt(i, 0).toString().trim();
			if(table_hakbun.equals(obj.hakbun)) {
				model.setValueAt(obj.kor, i, 2);
				model.setValueAt(obj.eng, i, 3);
				model.setValueAt(obj.math, i, 4);
				model.setValueAt(obj.tot, i, 5);
				model.setValueAt(obj.avg, i, 6);
				model.setValueAt(obj.grade, i, 7);
				flag=1;
				break;
			}
		}
		if(flag == 0)
			System.out.printf("학번" + obj.hakbun + " 수정 실패!");
		else
			System.out.printf("학번" + obj.hakbun + " 수정 성공!");
				
		not();
	}

	void not() {
		txtHakbun.setText("");
		txtIrum.setText("");
		txtKor.setText("");
		txtEng.setText("");
		txtMath.setText("");
	}

}
