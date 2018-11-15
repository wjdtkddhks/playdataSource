package Graphic;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class EventAction implements ActionListener{
	
	JTable table;
	JTextField text1, text2, text3, text4, text5;
	int kor, eng, math, tot;
	double avg;
	String hakbun, irum, grade;
	ImagePanel imagePanel;
	
	EventAction(JTable table, JTextField text1, JTextField text2, JTextField text3, JTextField text4, JTextField text5){
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
		this.text5 = text5;		
	}
	EventAction(JTable table, ImagePanel imagePanel, JTextField text3, JTextField text4, JTextField text5){
		this.table = table;
		this.imagePanel = imagePanel;
		this.text3 = text3;
		this.text4 = text4;
		this.text5 = text5;		
	}
	EventAction(JTable table){
		this.table = table;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("추가"))
			input();
		else if(e.getActionCommand().equals("삭제"))
			delete();
		else if(e.getActionCommand().equals("수정"))
			change();
		else if(e.getActionCommand().equals("그래프출력"))
			graph();
	}
	
	void input() {
		if(process()) {
			return;
		}
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for(int i=0; i<model.getRowCount(); i++) {
			if(hakbun.equals(model.getValueAt(i, 0)))
				{System.out.println("해당학번은 존재합니다.");
					not();
					return;
				}
		}
		Object obj[] = {hakbun, irum, kor, eng, math, tot, avg, grade};
		model.addRow(obj);
		System.out.printf("학번 %s 추가 성공!\n", hakbun);
		not();
	}
	void delete() {
		int row = table.getSelectedRow();
		if(row == -1)
			return;
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.removeRow(row);
		not();
	}
	void change() {
		if(process()) {
			return;
		}
		for(int i=0; i<table.getRowCount(); i++) {
			if(hakbun.equals(table.getValueAt(i, 0))) {
				table.setValueAt(kor, i, 2);
				table.setValueAt(eng, i, 3);
				table.setValueAt(math, i, 4);
				table.setValueAt(tot, i, 5);
				table.setValueAt(avg, i, 6);
				table.setValueAt(grade, i, 7);
				System.out.printf("학번 %s 수정 성공!\n", hakbun);
				not();
				return;
			}
		}
		System.out.println("해당학번은 없습니다.");
		not();
	}
	void graph() {
		int row = table.getSelectedRow();
		if(row == -1)
			return;
		
		int k = Integer.parseInt(table.getValueAt(row, 2).toString().trim());
		int e = Integer.parseInt(table.getValueAt(row, 3).toString().trim());
		int m = Integer.parseInt(table.getValueAt(row, 4).toString().trim());
		double av = (k+e+m)/3.;
		imagePanel.setScore(k, e, m, av);
		imagePanel.repaint();
	}
	
	boolean process()
	{	hakbun = text1.getText().trim();
		irum = text2.getText().trim();
		try {
		kor = Integer.parseInt(text3.getText().trim());
		eng = Integer.parseInt(text4.getText().trim());
		math = Integer.parseInt(text5.getText().trim());
		}
		catch(NumberFormatException e) {
			System.out.println("점수에는 숫자를 입력해주세요");
			not();
			return true;
		}
		
		this.tot = kor + eng + math;
		this.avg = tot / 3.;
			
			switch((int) avg / 10)
			{
				case 10:
				case 9:
					grade = "수";
					break;
				case 8:
					grade = "우";
					break;
				case 7:
					grade = "미";
					break;
				case 6:
					grade = "양";
					break;
				default:
					grade = "가";
					break;
			}
			return false;
	}
	void not() {
		text1.setText("");
		text2.setText("");
		text3.setText("");
		text4.setText("");
		text5.setText("");
	}

}
