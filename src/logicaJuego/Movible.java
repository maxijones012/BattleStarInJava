package logicaJuego;

import interfaces.IMovible;
import util.Movimiento;

public class Movible extends Elemento implements IMovible {
	private int direccion; //TODO SACARLO DE CONFIG
	private int velocidadAvance; //TODO SACARLO DE CONFIG
	
	//constructor
	
	
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
