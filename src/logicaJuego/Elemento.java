package logicaJuego;

import interfaces.IElemento;

public class Elemento implements IElemento{
	private Posicion posicion;
	private int Velocidad;
	
	
//	constructor
	public Elemento(Posicion posicion) {
		this.posicion=posicion;
	}


	
	
	
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}






	public int getVelocidad() {
		return Velocidad;
	}






	public void setVelocidad(int velocidad) {
		Velocidad = velocidad;
	}
	

	
	
	

}
