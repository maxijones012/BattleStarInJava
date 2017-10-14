package logicaJuego;

import interfaces.INave;
import util.Armamento;
import util.DebugConsola;
import util.Movimiento;

public abstract class Nave extends Movible implements INave{
	private int cantidadMunicion=this.getAministradorJuego().getConfig().getCantidadMunicionNave();
	private int cantidadBomba;
	private int nivelCombustible;
	private Radar radar;
	private int nivelEscudo;
	private int contadorInumidad=0;
	protected static int danioNave=10;
	private Boolean RadarOn=true;
	private Boolean inmunidad=false;
	private int tiempoInmunidad=this.getAministradorJuego().getConfig().getTiempoInmunidad(); 
	private int nivelVida=100;
	
//	constructor
	public Nave(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio,administradorJuego);
		this.radar=new Radar(posicion, tamanio, administradorJuego, this);
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
			super.avanzar();
		}
		//sino se rompio escudo
		else{
			if (this.getInmunidad()==false){destruir(this);}
		}
		DebugConsola.posicion(this);
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
	
	/**
	 * Girar de la clase Nave
	 * @param direccion
	 */
	public void girar(int direccion) {
		Movimiento.girar(this, direccion);
	}
	
	
	
	
	
//	------------------------------------------------------
	
	
	/**
	 * dispara una municion en una direccion
	 */
	private void dispararMunicion() {
		Armamento.dispararMisil(this);
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
		bonus.darBeneficio(this);
	}

	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		
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
	
	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		bonus.darBeneficio(this);
	}
	
	
	@Override
	public void chocarContraNave(Nave nave) {
		this.setNivelEscudo(this.getNivelEscudo()-danioNave);
	}

}
