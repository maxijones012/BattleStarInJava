package logicaJuego;

public class Misil extends Movible{
	private int nivelDanio; //TODO AGREGAR A CONFIG
	private Nave duenio;
	private int danio; //TODO sacar esto de config
	
	/**
	 * Constructor de la clase municion
	 * @param nave
	 * @param posicion
	 * @param tamanio
	 * @param escenario
	 */
	public Misil(Nave duenio, Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
		this.duenio= duenio;
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
		return nivelDanio;
	}

	public void setNivelDanio(int nivelDanio) {
		this.nivelDanio = nivelDanio;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}


	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
		
	}


	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		this.destruir(this);
	}


	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		this.destruir(this);		
	}


	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		this.destruir(this);
		
	}


	@Override
	public void chocarContraPared() {
		this.destruir(this);
	}


	@Override
	public void chocarContraBomba(Bomba bomba) {
		this.destruir(this);
	}
	
	

}
