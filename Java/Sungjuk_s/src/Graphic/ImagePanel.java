package Graphic;
import java.awt.*;
import javax.swing.*;
public class ImagePanel extends JPanel{
		int kor, eng, math;
		double avg;
	
		public void paint(Graphics g) {
			g.clearRect(0,0, getWidth(), getHeight());
			g.drawLine(50, 250, 450, 250);
			for(int i=0; i<11; i++) {
				g.drawString(i*10 + " ", 25, 255-i*20);
				g.drawLine(50, 250-i*20, 450, 250-i*20);
			}
			g.drawLine(50, 20, 50, 250);
			g.drawString("국어", 100, 270);
			g.drawString("수학", 200, 270);
			g.drawString("영어", 300, 270);
			g.drawString("평균", 400, 270);
			g.setColor(Color.RED);
			if(kor>0)
				g.fillRect(110, 250-kor*2, 10, kor*2);
			if(eng>0)
				g.fillRect(210, 250-eng*2, 10, eng*2);
			if(math>0)
				g.fillRect(310, 250-math*2, 10, math*2);
			g.setColor(Color.BLUE);
			if(avg>0)
				g.fillRect(410, 250-(int)avg*2, 10, (int)avg*2);
		}
		public void setScore(int kor, int eng, int math, double avg) {
			this.kor = kor;
			this.eng = eng;
			this.math = math;
			this.avg = avg;
		}
}
		

