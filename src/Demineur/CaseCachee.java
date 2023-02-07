package Demineur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class CaseCachee extends JButton implements AfficheCase, ActionListener {
	private Position pos;
	private int taille;
	private Grille grille;
	
	public CaseCachee(Position pos, int taille, Grille grille) {
		this.pos = pos;
		this.taille = taille;
		this.grille = grille;
		this.addActionListener(this);
	}
	
	public void set(){
		Color col = Color.GRAY;
		this.setBackground(col);
		this.setBounds(pos.getX() * taille, pos.getY() * taille, taille, taille);
		/*this.addMouseListener(new MouseAdapter() {
			
		    public void mouseClicked(MouseEvent e) {
		        if (e.getModifiers() == MouseEvent.BUTTON3_MASK && e.getClickCount() == 1) {
		        	System.err.println("Right clicked");
		        }
		    }
		});*/
	}
	
	public void actionPerformed(ActionEvent act) {
		Main.frame.getContentPane().repaint();
		if (grille.get(pos).isBomb()) {Main.Perdu();return;}
		grille.caseDiscovered(pos);
		if (grille.isSolved()) {Main.Gagne();return;}
	}

}