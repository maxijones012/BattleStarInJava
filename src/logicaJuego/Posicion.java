package logicaJuego;

import interfaces.IPosicion;

public abstract class Posicion implements IPosicion{
	private int X;
	private int Y;
	
//	constructor
	public Posicion(int X, int Y) {
		this.X=X;
		this.Y=Y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
	
	
	
	
	
	
	
	
	
}
