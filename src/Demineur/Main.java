package Demineur;

import javax.swing.JFrame;

public class Main {
	static JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		Grille g = new Grille(20,20,40);
		g.setBombs(60);
		frame.setContentPane(new DemineurPanel(g));
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(820, 820);
		frame.setVisible(true);
	}
	
	public static void Perdu() {
		((DemineurPanel)frame.getContentPane()).Perdu();
		frame.getContentPane().repaint();
	}
	
	public static void Gagne() {
		((DemineurPanel)frame.getContentPane()).Gagne();
		frame.getContentPane().repaint();
	}
	
}
