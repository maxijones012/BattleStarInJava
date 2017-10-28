package logicaJuego;

import interfaces.IMovible;
import util.uMovimiento;

/**
 * Clase abstracta Movible de la cual, las subclases deberan redefinir los metodos
 * @author Maxi Jones
 *
 */
public abstract class Movible extends Elemento implements IMovible {
	private int direccion; 
	private int velocidadAvance; 
	
	
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
		uMovimiento.avanzarX(this);
		uMovimiento.avanzarY(this);
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
		util.uMovimiento.girar(this, direccion);
	}
	
	@Override
	public void jugar() {
		super.jugar();
	}
}
