package logicaJuego;

import interfaces.IMovible;
import util.Movimiento;

public abstract class Movible extends Elemento implements IMovible {
	private int direccion=this.getEscenario().getConfig().getDireccionMovible(); 
	private int velocidadAvance=this.getEscenario().getConfig().getVelocidadAvanceMovible(); 
	
	
	/**
	 * Constructor de la clase Movible
	 * @param posicion
	 * @param tamanio
	 * @param escenario
	 */
	public Movible(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
	}


	@Override
	public void avanzar() {
		Movimiento.avanzarX(this);
		Movimiento.avanzarY(this);
	}

	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}


	public int getVelocidadAvance() {
		return velocidadAvance;
	}


	public void setVelocidadAvance(int velocidadAvance) {
		this.velocidadAvance = velocidadAvance;
	}
	
	
	
}
