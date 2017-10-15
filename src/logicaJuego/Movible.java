package logicaJuego;

import interfaces.IMovible;
import util.Movimiento;

public abstract class Movible extends Elemento implements IMovible {
	private int direccion=this.getAdministradorJuego().getConfiguracionInicial().getDireccionMovible(); 
	private int velocidadAvance=this.getAdministradorJuego().getConfiguracionInicial().getVelocidadAvanceMovible(); 
	
	
	/**
	 * Constructor de la clase Movible
	 * @param posicion
	 * @param tamanio
	 * @param administradorJuego
	 */
	public Movible(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
		this.direccion=this.getAministradorJuego().getConfiguracionInicial().getVelocidadAvanceMovible();
		this.velocidadAvance=this.getAministradorJuego().getConfiguracionInicial().getVelocidadAvanceMovible();
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
	
	public void girar(int direccion) {
		util.Movimiento.girar(this, direccion);
	}
	
}
