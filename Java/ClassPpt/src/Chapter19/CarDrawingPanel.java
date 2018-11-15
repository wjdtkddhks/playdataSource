package Chapter19;
import java.awt.*;
import javax.swing.*;

public class CarDrawingPanel extends JPanel {
	
	public void paint(Graphics g) {
		g.drawRect(100, 110, 200, 40);
		g.drawRect(150, 70, 100, 40);
		g.drawOval(125, 150, 30, 30);
		g.drawOval(245, 150, 30, 30);
		g.drawLine(50, 180, 350, 180);
		
	}
	
}
