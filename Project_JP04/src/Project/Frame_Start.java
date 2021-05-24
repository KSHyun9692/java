package Project;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame_Start extends JFrame {
	private ImageIcon img = new ImageIcon("images/BACK.jpg"); 
	public Frame_Start() {
		//jframe º≥¡§
		setTitle("4¡∂ ºÓ«Œ∏Ù");
		Main panel = new Main(this) {
			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		add(panel);
		setBounds(100, 100, 450, 443);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args) {
		new Frame_Start();
	}
}
