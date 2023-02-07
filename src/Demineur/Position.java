package Demineur;

public class Position {
	private final int x;
	private final int y;
	private final int xMax;
	private final int yMax;
	
	public Position(int x, int y, int xMax, int yMax) {
		this.x = x;
		this.y = y;
		this.xMax = xMax;
		this.yMax = yMax;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getMaxX(){
		return xMax;
	}
	public int getMaxY(){
		return yMax;
	}
	
	public Position[] getCasesAround(){
		
		//Comptage du nombre de bonnes cases autour
		int[][] cases = new int[8][];
		int i = 0;
		for (int[] c : new int[][]{{x-1,y-1},{x,y-1},{x+1,y-1},{x+1,y},{x+1,y+1},{x,y+1},{x-1,y+1},{x-1,y}}) {
			if(c[0] >= 0 && c[0] < xMax && c[1] >= 0 && c[1] < yMax){
				cases[i] = c;
				i++;
			}
		}
		
		//Creation du tableau de positions
		Position[] pos = new Position[i];
		for (int j = 0; j < pos.length; j++) {
			pos[j] = new Position(cases[j][0], cases[j][1], xMax, yMax);
		}
		return pos;
	}
	
	public boolean equals(Object pos) {
		return (x == ((Position) pos).x && y == ((Position) pos).y);
	}
	
	public String toString() {
		return "(" + x + ";" + y + ")";
	}
	
}
