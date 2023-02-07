package Demineur;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DemineurPanel extends JPanel {
	private Grille grille;
	private boolean perdu = false;
	private boolean gagne = false;
	
	public DemineurPanel(Grille g) {
		this.grille = g;
	}
	
	public void Perdu(){perdu = true;}
	public void Gagne(){gagne = true;}
	
	protected void paintComponent(Graphics g) {
		this.removeAll();
		if (perdu){
			PerduPanel pp = new PerduPanel();
			pp.set();
			this.add(pp);
		} else if (gagne) {
			PanelGagne pg = new PanelGagne();
			pg.set();
			this.add(pg);
		} else {
			for (Case[] ligne : grille.getGrille()) {
				for (Case c : ligne){
					this.add((Component) c.getAffichage());
					c.getAffichage().set();
				}
			}
		}
	}
}
