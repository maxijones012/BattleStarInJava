package logicaJuego;

public class Municion extends Movible{
	private int nivelDanio; //TODO AGREGAR A CONFIG
	private Movible duenio;
	
	/**
	 * Constructor de la clase municion
	 * @param nave
	 * @param posicion
	 * @param tamanio
	 * @param escenario
	 */
	public Municion(Nave nave, Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
		this.duenio= duenio;
	}
	
	

}
