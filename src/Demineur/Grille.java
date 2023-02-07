package Demineur;

import java.util.ArrayList;
import java.util.Random;

public class Grille {
	private Case[][] grille;
	private int nBomb = 0;
	private final int width;
	private final int height;
	private int nCases = 0;
	
	public Grille(int width, int height, int tailleCases) {
		this.width = width;
		this.height = height;
		grille = new Case[width][height];
		for(int i = 0; i < width; i++){
			for (int j = 0; j < height; j++) {
				grille[i][j] = new Case(i, j, tailleCases, this);
				nCases ++;
			}
		}
	}
	
	/**Renvoie la i-ieme case en parcourant de gauche à droite et de haut en bas, en ignorant les bombes*/
	private Position associateCase(int i){
		int x = 0, y = 0;
		while (i > 0) {
			y = (x == width-1 ? y + 1 : y);
			x = (x == width-1 ? 0 : x + 1);
			i -= (grille[x][y].isBomb() ? 0 : 1);
		}
		return new Position(x, y, width, height);
	}
	
	public void setBombs(int n){
		
		//Creation de variables dont on aura besoin
		Random rand = new Random();
		int r; Position p; Position[] casesToUpdate;
		
		//Pour chaque bombes
		for (int i = 0; i < n; i++) {
			
			//On calcule la case aleatoire
			r = rand.nextInt(width * height - nBomb);
			nBomb ++;
			p = associateCase(r);
			
			//On met la bombe
			casesToUpdate = grille[p.getX()][p.getY()].setBomb();
			
			//On update les cases autour
			for (Position pos : casesToUpdate) {
				grille[pos.getX()][pos.getY()].addValue();
			}
			
			nCases --;
			
		}
	}
	
	
	public Case[][] getGrille(){
		return grille;
	}
	
	public Case get(Position pos){
		return grille[pos.getX()][pos.getY()];
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public void dimCase(){
		nCases--;
	}
	
	public void caseDiscovered(Position posInit){
		get(posInit).setVisible();
		if (get(posInit).getValue() == 0){
			Position posCur = posInit;
			ArrayList<Position> CasesToCheck = new ArrayList<Position>();
			ArrayList<Position> CasesChecked = new ArrayList<Position>();
			CasesToCheck.add(posCur);
			while (!CasesToCheck.isEmpty()){
				get(posCur).setVisible();
				posCur = CasesToCheck.get(0);
				if (get(posCur).getValue() == 0){
					for (Position posRec : posCur.getCasesAround()) {
						if (!CasesChecked.contains(posRec)){
							CasesToCheck.add(posRec);
						}
					}
					CasesChecked.add(posCur);
				}
				CasesToCheck.remove(0);
			}
		}
	}
	
	public boolean isSolved(){
		return nCases == 0;
	}
	
}
