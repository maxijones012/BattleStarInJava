package logicaJuego;


public class BonusMisil extends Bonus{

	/**
	 * Constructor de la clase bonus misil
	 * @param posicion
	 * @param tamanio
	 * @param administradorJuego
	 */
	public BonusMisil(Posicion posicion, Tamanio tamanio, AdministradorJuego escenario, Nave nave) {
		super(posicion, tamanio, escenario, nave);
	}

	@Override
	public void jugar() {
		
		
	}

	@Override
	/**
	 * 
	 */
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBonusMisil(this);
		
	}


	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		darBeneficio(bonus.getDuenio());
	}
	@Override
	public void darBeneficio(Nave nave) {
		darBonusMisil(nave);
	}

	
	
	
	private void darBonusMisil(Nave nave) { //TODO VERFICIAR QUE TOME LA MITAD
		if (nave!=null){nave.setCantidadMunicion(nave.getCantidadMunicion()+(nave.getCantidadMunicion()/2));}
	}

	
	
	
	//---------------------------------------------------------------------
	
	//                n o     d e b e n 	h a c e r 	n a  d a
	
	@Override
	public void chocarContraPared() {}

	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {} //TODO ver si se agrega un reacomodo de posicion

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {}

	@Override
	public void chocarContraBomba(Bomba bomba) {
		darBeneficio(bomba.getDuenio());
	}

	@Override
	public void chocarContraNave(Nave nave) {
		this.destruir(this);
	}
	
}
