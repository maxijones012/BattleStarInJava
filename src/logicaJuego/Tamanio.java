package logicaJuego;


public class Tamanio{
	private int ancho;
	private int alto;
	
	

	/**
	 * constructor de clase tamanio, genera los valor de ANCHO y ALTO
	 * @param ancho
	 * @param alto
	 */
	public Tamanio(int ancho, int alto) {
		this.ancho=ancho;
		this.alto=alto;
	}

	
	public int getAncho() {
		return this.ancho;
	}
	public int getAlto() {
		return this.alto;
	}
	public void setAlto(int alto) {
		this.alto= alto;
	}
	public void setAncho(int ancho) {
		this.ancho=ancho;		
	}
	
	
	
	
}
