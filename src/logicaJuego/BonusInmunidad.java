package logicaJuego;

public class BonusInmunidad extends Bonus{

	/**
	 * Constructor de la clase bonus Inmunidad
	 * @param posicion
	 * @param tamanio
	 * @param administradorJuego
	 */
	public BonusInmunidad(Posicion posicion, Tamanio tamanio, AdministradorJuego escenario, Nave nave) {
		super(posicion, tamanio, escenario, nave);
	}

	@Override
	public void jugar() {

	}

	@Override
	/**
	 * llamao al metod del elemento que chocaContraBonusInmunidad ()
	 * @param elemento
	 */
	 
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBonusInmunidad(this);
	}

	@Override
	/**
	 * TODO METODO VACIO SI UN BONUS CHOCA CONTRA OTRO NO HAGO NADA
	 */
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		// TODO Auto-generated method stub
		
	}


	@Override
	/**
	 * Otorgo el bonus de misil a la nave
	 */
	public void chocarContraBonusMisil(BonusMisil bonus) {
		darBeneficio(bonus.getDuenio());
	}

	@Override
	/** se otroga el benefico de inmunidad a la nave 
	 * @param nave
	 */
	public void darBeneficio(Nave nave) {
		darBonusInmunidad(nave);
		
	}

	
	
	
	private void darBonusInmunidad(Nave nave) {
		if (nave != null){
			nave.setInmunidad(true);			
		}
	}

	@Override
	public void chocarContraPared() {}

	@Override
	public void chocarContraBomba(Bomba bomba) {
		this.destruir(this);
	}

	@Override
	public void chocarContraNave(Nave nave) {
		this.destruir(this);
	}

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {} //TODO VER SI ESTO ESTA BIEN

}
