package DynamicBeat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {
	
	int mouse_X;
	int mouse_Y;

	private Image screenImage;
	private Graphics screenGraphics;
	private Image introImage = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar.jpg")));

	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/exitbaisc.png")));
	private ImageIcon exitbaisc = new ImageIcon(Main.class.getResource("../images/exitbaisc.png"));
	private ImageIcon exitcontact = new ImageIcon(Main.class.getResource("../images/exitcontact.png"));

	DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat Game");
		setSize(Main.FRAME_WIDTH, Main.FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		Music introMusic = new Music("intromusic.mp3", true);
		introMusic.start();

		add(exitButton);
		exitButton.setBounds(920, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitcontact);
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mousePressed(MouseEvent e) {
				exitButton.setIcon(exitbaisc);
				System.exit(0);
			}
			
		});
		
		
		add(menubar);
		menubar.setBounds(0, 0, 960, 30);
		
		menubar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouse_X = e.getX();
				mouse_Y = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouse_X, y-mouse_Y);
			}
		});
		

		
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.FRAME_WIDTH, Main.FRAME_HEIGHT);
		screenGraphics = screenImage.getGraphics();
		drawBackground(screenGraphics);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void drawBackground(Graphics g) {
		g.drawImage(introImage, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}
