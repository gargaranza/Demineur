package Demineur;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PerduPanel extends JPanel {
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		g.setFont(new Font("SansSerif", 1, 50));
		g.drawString("Tu as perdu", Main.frame.getSize().width / 2 - 110, Main.frame.getSize().height / 2 - 5);
	}
	
	public void set(){
		this.setBackground(new Color(200, 200, 200));
		this.setBounds(0,0,Main.frame.getSize().width, Main.frame.getSize().height);
	}
	
}
