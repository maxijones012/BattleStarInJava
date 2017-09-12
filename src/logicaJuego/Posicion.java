package logicaJuego;

import interfaces.IPosicion;

public class Posicion implements IPosicion{
	private int posicionX;
	private int posicionY;
	
//	constructor
	public Posicion(int X, int Y) {
		this.posicionX=X;
		this.posicionY=Y;
	}
	
	
	public int getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
	
	
	
	
	
	
}
