package logicaJuego;

import interfaces.INave;
import util.Armamento;

public abstract class Nave extends Movible implements INave{
	private int cantidadMunicion; //TODO QUE LA MUNICION LA SETEE DESDE CONFIG
	private int cantidadBomba;
	private int nivelCombustible;
	
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
	/**
	 * cada vez que avanza una nave gasta un nivel de combustible
	 */
	public void avanzar() {
		this.setNivelCombustible(this.getNivelCombustible()-1);
		super.avanzar();
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

	public int getCantidadBomba() {
		return cantidadBomba;
	}

	public void setCantidadBomba(int cantidadBomba) {
		this.cantidadBomba = cantidadBomba;
	}

	public int getNivelCombustible() {
		return nivelCombustible;
	}

	public void setNivelCombustible(int nivelCombustible) {
		this.nivelCombustible = nivelCombustible;
	}

}
