package logicaJuego;


public class BonusMisil extends Bonus{

	/**
	 * Constructor de la clase bonus misil
	 * @param posicion
	 * @param tamanio
	 * @param escenario
	 */
	public BonusMisil(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
	}

	@Override
	public void jugar() {
		
		
	}

	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBonusMisil(this);
		
	}

	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		
	}
	@Override
	public void darBeneficio(Nave nave) {
		darBonusMisil(nave);
	}

	
	
	
	private void darBonusMisil(Nave nave) { //TODO VERFICIAR QUE TOME LA MITAD
		nave.setCantidadMunicion(nave.getCantidadMunicion()+(nave.getCantidadMunicion()/2));
	}

	
}
