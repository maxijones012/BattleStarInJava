package logicaJuego;

import interfaces.IMovible;
import util.Movimiento;

public class Movible extends Elemento implements IMovible {
	
	public Movible(Posicion posicion) {
		super(posicion);
	}

	private int direccion;

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
	
	
	
}
