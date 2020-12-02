package Serv;

import java.util.ArrayList;

public class Partie {
	private int Length;
	private int width;
	private int [][] grille1;
	private int [][] grille2;
	private ArrayList<Integer> ships = new ArrayList<Integer>();
	
	public Partie(int length, int width, ArrayList<Integer> ships) {
		super();
		Length = length;
		this.width = width;
		this.grille1 = this.grille2 = new int[length][width];
		this.ships = ships;
	}

	public int getLength() {
		return Length;
	}

	public void setLength(int length) {
		Length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int[][] getGrille1() {
		return grille1;
	}

	public void setGrille1(int[][] grille1) {
		this.grille1 = grille1;
	}

	public int[][] getGrille2() {
		return grille2;
	}

	public void setGrille2(int[][] grille2) {
		this.grille2 = grille2;
	}

	public ArrayList<Integer> getShips() {
		return ships;
	}

	public void setShips(ArrayList<Integer> ships) {
		this.ships = ships;
	}
	public void fillGrid(int [][]grid) {
		for(int i=0; i<grid.length; i++) {
			for(int j=0;j<grid.length;j++) {
				grid[i][j]=0;
			}
		}
	}
	
	boolean checkPlace(int [][] Grille,int x, int y, char o, int taille) {
		if(taille == 2) {
			switch (o) {
			case 'D':
				if(x>Grille.length-2) {
					return false;
				}else return true;
			case 'U':
				if(x>=2) {
					return false;
				}else return true;
			case 'R':
				if(y>Grille.length-2) {
					return false;
				}else return true;
			case 'L':
				if(y>=2) {
					return false;
				}else return true;
				
			default:
				break;
			}
		}
		return false;
	}
	
	
}
