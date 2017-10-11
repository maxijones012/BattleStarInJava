package logicaJuego;

public class Misil extends Movible{
	private int nivelDanioMisil=getEscenario().getConfig().getNivelDanioMisil();
	private Nave duenio;
	
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
		return nivelDanioMisil;
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


	@Override
	public void chocarContraNave(Nave nave) {
		this.destruir(this);
	}
	
	

}
