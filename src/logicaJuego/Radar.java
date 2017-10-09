package logicaJuego;

import java.awt.Polygon;

import util.Movimiento;
import util.uRadar;

public class Radar extends Movible{
	private Nave duenio;
	private int anguloApertura=20; //TODO SACAR ESTO DE CONFIG
	private int alcance=40; //TODO SACAR ESTO DE CONFIG
	
	
	
	public Radar(Posicion posicion, Tamanio tamanio, Escenario escenario, Nave nave) {
		super(posicion, tamanio, escenario);
		this.duenio=nave;
	}
	
	
	
	//TODO HACER EL ESCANEAR
	public void escanear(){ //TODO anda mejorar y hacer 
		
			System.out.println("Escanenando..." );
	};
	
	@Override
	public void jugar() {
		this.escanear();
		
	}
	
	/**
	 * devuelve el un polygono
	 * @return
	 */
	public Polygon getAreaCobertura(){
		return (uRadar.getAreaCobertura(this));
	}
	
	/**
	 * gira con respecto a un  angula dado
	 * @param angulo
	 */
	public void girar (int angulo){
		Movimiento.girar(this, angulo);
	}


	@Override
	public void avanzar() {
		Movimiento.avanzarX(duenio);
		Movimiento.avanzarY(duenio);
		super.avanzar();
	}



	public Nave getDuenio() {
		return duenio;
	}



	public void setDuenio(Nave duenio) {
		this.duenio = duenio;
	}



	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
	}

	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
	}

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
	}

	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {	}



	@Override
	public void chocarContraPared() {
	}



	public int getAnguloApertura() {
		return anguloApertura;
	}



	public int getAlcance() {
		return alcance;
	}



	public void setAnguloApertura(int anguloApertura) {
		this.anguloApertura = anguloApertura;
	}
	
	
	
	
}
