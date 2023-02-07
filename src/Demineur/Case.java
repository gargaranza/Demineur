package Demineur;

public class Case {
	private int value;
	private boolean isVisible = false;
	private Position pos;
	private AfficheCase aff;
	private int taille;
	private Grille grille;
	
	public Case(int x, int y, int taille, Grille grille) {
		this.pos = new Position(x, y, grille.getWidth(), grille.getHeight());
		value = 0;
		this.taille = taille;
		this.grille = grille;
		aff = new CaseCachee(pos,taille,grille);
		//aff = new CaseMontree(pos,taille,this);
	}
	
	public int getValue(){
		return value;
	}
	
	public boolean isVisible(){
		return isVisible;
	}
	public void setVisible(){
		if (!isVisible){
			grille.dimCase();
			isVisible = true;
			aff = new CaseMontree(pos,taille,this);
		}
	}
	
	public void addValue(){
		value += (value == -1 ? 0 : 1);
	}
	
	public Position[] setBomb(){
		value = -1;
		return pos.getCasesAround();
	}
	
	public boolean isBomb(){
		return value == -1;
	}
	
	public AfficheCase getAffichage(){
		return aff;
	}
	
	public String toString() {
		return "(" + pos.getX() + ";" + pos.getY() + ") " + (isBomb() ? "est une bombe" : "a " + value + " bombes autour");
	}
	
}
