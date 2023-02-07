package Demineur;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CaseMontree extends JPanel implements AfficheCase {
	private Position pos;
	private int taille;
	private Case c;
	
	public CaseMontree(Position pos, int taille, Case c) {
		this.pos = pos;
		this.taille = taille;
		this.c = c;
	}
	
	private Color setColor(int value){
		Color color = null;
		switch (value) {
		case 0:
			color = this.getBackground();
			break;
		case 1:
			color = Color.BLUE;
			break;
		case 2:
			color = Color.GREEN;
			break;
		case 3:
			color = Color.RED;
			break;
		case 4:
			color = Color.MAGENTA;
			break;
		case 5:
			color = Color.DARK_GRAY;
			break;
		case 6:
			color = Color.GRAY;
			break;
		case 7:
			color = Color.ORANGE;
			break;
		case 8:
			color = Color.BLACK;
			break;
		default:
			break;
		}
		return color;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(setColor(c.getValue()));
		g.setFont(new Font("SansSerif", 1, (int)((double)taille * 0.8)));
		g.drawString("" + c.getValue(), (int)((double)taille * 0.1), taille - (int)((double)taille * 0.1));
	}
	
	public void set(){
		this.setBackground(new Color(200, 200, 200));
		this.setBounds(pos.getX() * taille, pos.getY() * taille, taille, taille);
	}
	
}
