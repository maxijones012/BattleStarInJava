package logicaJuego;

import configuracion.ConfiguracionInicial;

public class Misil extends Movible{
	private int nivelDanioMisil;
	private Nave duenio;
	
	/**
	 * Constructor de la clase Misil donde toma la posicion de la {@link Nave nave}
	 * @param nave
	 * @param posicion
	 * @param tamanio
	 * @param administradorJuego
	 */
	public Misil(Nave duenio, Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(duenio.getPosicion(),tamanio, administradorJuego);
		this.duenio= duenio;
		
		this.nivelDanioMisil=getAministradorJuego().getConfiguracionInicial().getNivelDanioMisil();
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}
	public Nave getDuenio() {
		return duenio;
	}

	public void setDuenio(Nave duenio) {
		this.duenio = duenio;
	}

	public int getNivelDanio() {
		return nivelDanioMisil;
	}



	@Override
	/**
	 * llamo al chocar contra del elemeto que choca con el misil
	 * @param elemento
	 * TODO cualquier elemento que choca con el misl
	 */
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
		
	}


	@Override
	/**
	 *Se invoca el metodo destruir del bonus de reparacion
	 *@param bonus
	 */
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		this.destruir(this);
	}


	@Override
	/**
	 * se llama al destruir del bonus
	 * @param bonus
	 */
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		this.destruir(this);		
	}


	@Override
	/**
	 * se destruye el bonus
	 * @author carlos
	 * @param bonus
	 */
	public void chocarContraBonusMisil(BonusMisil bonus) {
		this.destruir(this);
		
	}


	@Override
	/**
	 * se destruye el misl 
	 * si el misl se pasa de rango se destruye 
	 */
	public void chocarContraPared() {
		this.destruir(this);
	}


	@Override
	/**
	 * llamo al metodo destruir de bomba 
	 * @param bomba 
	 */
	public void chocarContraBomba(Bomba bomba) {
		this.destruir(this);
	}


	@Override
	/**
	 * llamo al metodo destruir de nave
	 * @param nave
	 */
	public void chocarContraNave(Nave nave) {
		this.destruir(this);
	}

	@Override
	public void chocarContraPazadizo(Pasadizo pasadizo) {
		this.destruir(this);
		
	}

	public void disparar(Nave nave, Misil misil) {
			misil.getTamanio().setAlto(30);
			misil.getTamanio().setAncho(30);
			misil.getPosicion().setX(nave.getPosicion().getX());
			misil.getPosicion().setY(nave.getPosicion().getY());
			this.setVelocidadAvance(nave.getAdministradorJuego().getConfiguracionInicial().getVelocidadAvanceMovible()+30);
			nave.getAdministradorJuego().addElemento(misil);
			
	}
	
	

}
