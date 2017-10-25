package logicaJuego;

public class BonusInmunidad extends Bonus{

	/**
	 * Constructor de la clase bonus Inmunidad
	 * @param posicion
	 * @param tamanio
	 * @param administradorJuego
	 */
	public BonusInmunidad(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego, Nave nave) {
		super(posicion, tamanio, administradorJuego, nave);
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
	 * @param bonus
	 */
	public void chocarContraBonusMisil(BonusMisil bonus) {
		darBeneficio(bonus.getDuenio());
	}

	@Override
	/** se otroga el benefico de inmunidad a la nave 
	 * @param nave
	 * @param beneficio
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

	@Override
	public void chocarContraPazadizo(Pasadizo pasadizo) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void chocarContraMisil(Misil misil) {
		this.destruir(this);
	};

}
