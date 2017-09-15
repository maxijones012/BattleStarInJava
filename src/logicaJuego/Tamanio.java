package logicaJuego;

import interfaces.ITamanio;

public class Tamanio implements ITamanio{
	private int ancho;
	private int alto;
	
	
//	constructor
	public Tamanio(int ancho, int alto) {
		this.ancho=ancho;
		this.alto=alto;
	}
	
	@Override
	public int getAncho() {
		return this.ancho;
	}
	@Override
	public int getAlto() {
		return this.alto;
	}
	@Override
	public void setAlto(int alto) {
		this.alto= alto;
	}
	@Override
	public void setAncho(int ancho) {
		this.ancho=ancho;		
	}
	
	
	
	
}
