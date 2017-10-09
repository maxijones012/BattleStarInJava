package logicaJuego;

import interfaces.INave;
import util.Armamento;

public abstract class Nave extends Movible implements INave{
	private int cantidadMunicion; //TODO QUE LA MUNICION LA SETEE DESDE CONFIG
	private int cantidadBomba;
	private int nivelCombustible;
	private Radar radar;
	private int nivelEscudo;
	private int contadorInumidad=0;
	private Boolean RadarOn=true;
	private Boolean inmunidad=false;
	private static int tiempoInmunidad=25; //TODO SACAR ESTO DE CONFIG
	private int nivelVida=100;
	
//	constructor
	public Nave(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio,escenario);
		this.radar=new Radar(posicion, tamanio, escenario, this);
	}

	
//---------------------------------------------------------------


	@Override
	/**
	 * cada vez que avanza una nave gasta un nivel de combustible
	 */
	public void avanzar() {
		if (this.getNivelCombustible()>=0){
			super.avanzar();
			this.setNivelCombustible(this.getNivelCombustible()-1);
		}
	}
	
	
	@Override
	public void jugar() {
		controlarInmunidad();
		//tengo escudo
		
		if (this.getNivelEscudo()>=0){	
			this.getRadar().escanear();				
		}
		//sino se rompio escudo
		else{
			if (this.getInmunidad()==false){destruir(this);}
		}		
	}

	
	
	
	
	private void controlarInmunidad() {
		this.setContadorInumidad(this.getContadorInumidad()+1);
		
		//si la inmunidada esta por debajo de un valor, chau inmunidad
		if (this.getContadorInumidad()>this.contadorInumidad){
			this.setInmunidad(false);
		}
	}


	public void disparar(Bomba bomba){
		dispararBomba();
	}
	public void disparar(Misil municion){
		dispararMunicion();
	}
	
	
	
	
	
	
	
	
//	------------------------------------------------------
	
	
	/**
	 * dispara una municion en una direccion
	 */
	private void dispararMunicion() {
		Armamento.dispararMunicion(this);
	}

	

	/**
	 * Dispara una bomba en una direccion
	 */
	private void dispararBomba() {
		Armamento.dispararBomba(this);
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


	public Radar getRadar() {
		return radar;
	}


	public int getNivelEscudo() {
		return nivelEscudo;
	}


	public void setNivelEscudo(int nivelEscudo) {
		this.nivelEscudo = nivelEscudo;
	}


	public Boolean getRadarOn() {
		return RadarOn;
	}


	public void setRadarOn(Boolean radarOn) {
		RadarOn = radarOn;
	}
	
	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
	}
	
	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		
	}


	public Boolean getInmunidad() {
		return inmunidad;
	}


	public void setInmunidad(Boolean inmunidad) {
		this.inmunidad = inmunidad;
	}


	public int getContadorInumidad() {
		return contadorInumidad;
	}


	public void setContadorInumidad(int contadorInumidad) {
		this.contadorInumidad = contadorInumidad;
	}


	public int getNivelVida() {
		return nivelVida;
	}


	public void setNivelVida(int nivelVida) {
		this.nivelVida = nivelVida;
	}

	@Override
	public void chocarContraBomba(Bomba bomba) {
		this.setNivelVida(getNivelVida()-bomba.getDanioBomba());	// TODO Auto-generated method stub
		
	}
	
}
