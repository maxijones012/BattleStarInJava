package logicaJuego;

public class BonusReparacion extends Bonus{
	private static int valorReparacion=40; //TODO SACAR ESTO DE CONFIG
	/**
	 * Constructor de la clase bonus reparacion
	 * @param posicion
	 * @param tamanio
	 * @param escenario
	 */
	public BonusReparacion(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
	}


	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
		
	}

	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {}

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
	}

	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBeneficio(Nave nave) {
		darBonusReparacion(nave);
		this.destruir(this);
	}

	
	public void darBeneficio(Misil misil) {
		darBonusReparacion(misil);
		this.destruir(this);
		
	}
	
	
	private void darBonusReparacion(Misil misil) {
		Nave nave=misil.getDuenio(); 
		
		nave.setNivelVida(nave.getNivelVida()+valorReparacion);
		
	}

	private void darBonusReparacion(Nave nave) {
		nave.setNivelVida(nave.getNivelVida()+valorReparacion);
	}

}
