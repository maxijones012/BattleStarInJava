package logicaJuego;

public class Misil extends Movible{
	private int nivelDanioMisil;
	private Nave duenio;
	
	/**
	 * Constructor de la clase municion
	 * @param nave
	 * @param posicion
	 * @param tamanio
	 * @param administradorJuego
	 */
	public Misil(Nave duenio, Posicion posicion, Tamanio tamanio, AdministradorJuego escenario) {
		super(posicion, tamanio, escenario);
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
	
	

}
