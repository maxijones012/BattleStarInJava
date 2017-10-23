package logicaJuego;

import configuracion.ConfiguracionInicial;
import interfaces.INave;
import interfaces.IRadarListener;
import util.uArmamento;
import util.uDebugConsola;
import util.uEstrategia;
import util.uMovimiento;

public abstract class Nave extends Movible implements INave,IRadarListener{
	private Boolean RadarOn=true;
	private Boolean inmunidad=false;
	private int cantidadMunicion=ConfiguracionInicial.CANTIDAD_MUNICION;
	private int cantidadBomba=ConfiguracionInicial.CANTIDAD_BOMBA;
	private int nivelCombustible;
	private Radar radar;
	private int nivelEscudo;
	private int contadorInumidad=0;
	protected static int danioNave=10; //si choca contra otra nave recibe un pequeño danio
	private int tiempoInmunidad; 
	private int nivelVida;
	
//	constructor
	public Nave(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, new Tamanio(administradorJuego.getConfiguracionInicial().getAnchoNave(), administradorJuego.getConfiguracionInicial().getAltoNave()),administradorJuego);
		this.nivelVida=this.getAministradorJuego().getConfiguracionInicial().getNivelVida();
		this.cantidadMunicion=this.getAdministradorJuego().getConfiguracionInicial().getCantidadMunicionNave();
		this.tiempoInmunidad=this.getAministradorJuego().getConfiguracionInicial().getTiempoInmunidad();
		this.nivelCombustible=this.getAministradorJuego().getConfiguracionInicial().getNivelCombustible();
		this.radar=new Radar(posicion, tamanio, administradorJuego, this);
		this.radar.addRadarListener(this);
		
	}

	
//---------------------------------------------------------------


	@Override
	/**
	 * cada vez que avanza una nave gasta un nivel de combustible
	 */
	public void avanzar() {
		if (this.getNivelCombustible()>=0){
			this.setNivelCombustible(this.getNivelCombustible()-1);
			super.avanzar();
		}else{
			uEstrategia.girarCorrectorRadar(this,360, 90, 800);
		}
		
		
	}
	
	
	@Override
	public void jugar() {
		
		super.jugar();
		controlarInmunidad();
		//tengo escudo		
		if (this.getNivelVida()>=0){
			uEstrategia.girarCorrectorRadar(this, 10, 0, 1);
   			avanzar();
			this.getRadar().escanear();

		}
		//sino se rompio escudo
		else{
			if (this.getInmunidad()==false){
				destruir(this);
			}
		}
	}

	
	
	
	
	private void controlarInmunidad() {
		this.setContadorInumidad(this.getContadorInumidad()+1);
		
		//si la inmunidada esta por debajo de un valor, chau inmunidad
		if (this.getContadorInumidad()>this.contadorInumidad){
			this.setInmunidad(false);
		}
	}


	/**
	 * metodo girar que segun un valor @see direccion gira la nave
	 */
	public void girar(int direccion) {
		uMovimiento.girar(this, direccion);
	}
	
	
	
	
	
//	------------------------------------------------------
	
	
	/**
	 * Dispara una {@link Municion municion} desde la posicion de la nave 
	 * @param nave
	 */
	public void dispararMunicion(Nave nave) {
		uArmamento.dispararMisil(nave);
	}

	

	/**
	 * Dispara una {@link Bomba bomba} desde la posicion de la nave 
	 * @param nave
	 */
	public void dispararBomba(Nave nave) {
		uArmamento.dispararBomba(nave);
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
	/**
	 * invoco el chocar contra del elemento
	 * TODO el tipo de elemento que se intersecta con la nave 
	 */
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraNave(this);
	}
	
	@Override
	/**
	 * otorga el beneficio de inmunidad a la nave que choca con el bonus
	 * TODO durante una cierta cantidad de tiempo el flag de inmunidad esta en true
	 */
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		bonus.darBeneficio(this);
	}

	@Override
	/**
	 * otorga el beneficio de misil a la naver
	 * TODO Se Setea el nivel de misiles por defaul
	 */
	public void chocarContraBonusMisil(BonusMisil bonus) {
		bonus.darBeneficio(this);
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
	/**
	 * reduzco el nivel de vida de la nave 
	 * @param bomba
	 */
	public void chocarContraBomba(Bomba bomba) {
		if (bomba.getDuenio()!=this){
			this.setNivelVida(getNivelVida()-bomba.getDanioBomba());	// TODO Auto-generated method stub
		}
		
	}
	
	@Override
	/**
	 * el nivel de combustible vuelve al valor por defecto
	 * aumenta el nivel de vida de vida de la nave 
	 */
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		bonus.darBeneficio(this);
	}
	
	
	@Override
	/**
	 * reduzco el nivel de escudo de la nave 
	 */
	public void chocarContraNave(Nave nave) {
		this.girar(90);
	}

	
	@Override
	public void chocarContraPazadizo(Pasadizo pasadizo) {
		this.setPosicion(pasadizo.getPasadizoSalida());
	}
	
	
	@Override
	public void chocarContraMisil(Misil misil) {
		if (misil.getDuenio()!= this){
			this.setNivelVida(this.getNivelVida()-misil.getNivelDanio());
		}
		
	}
	
	
	@Override
	public void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculoExplosivo) {
		this.setNivelVida(this.getNivelVida()-obstaculoExplosivo.getNivelDanio());
		uEstrategia.eludir(this);
	}
}
