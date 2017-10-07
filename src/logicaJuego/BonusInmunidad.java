package logicaJuego;

public class BonusInmunidad extends Bonus{

	/**
	 * Constructor de la clase bonus Inmunidad
	 * @param posicion
	 * @param tamanio
	 * @param escenario
	 */
	public BonusInmunidad(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
	}

	@Override
	public void jugar() {

	}

	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBonusInmunidad(this);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBeneficio(Nave nave) {
		darBonusInmunidad(nave);
		
	}

	
	
	
	private void darBonusInmunidad(Nave nave) {
		nave.setInmunidad(true);
	}

}
