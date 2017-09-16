package logicaJuego;

import interfaces.INave;
import util.Armamento;

public abstract class Nave extends Movible implements INave{
	private int cantidadMunicion; //TODO QUE LA MUNICION LA SETEE DESDE CONFIG
	
//	constructor
	public Nave(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio,escenario);
	}

	
	
	
	
	
//---------------------------------------------------------------

	@Override
	public void dispararBomba() {
		Armamento.dispararBomba(this);
	}

	
	
	@Override
	public void dispararMunicion() {
		Armamento.dispararMunicion(this);
	}

	
	

	public int getCantidadMunicion() {
		return cantidadMunicion;
	}

	public void setCantidadMunicion(int cantidadMunicion) {
		this.cantidadMunicion = cantidadMunicion;
	}

}
