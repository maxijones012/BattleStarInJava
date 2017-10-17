package logicaJuego;

/**
 * clase de bonus reparacion
 * @author Maxi Jones
 *
 */
public class BonusReparacion extends Bonus{
	private int valorReparacion; 
	
	/**
	 * Constructor de la clase bonus reparacion
	 * @param posicion
	 * @param tamanio
	 * @param administradorJuego
	 */
	public BonusReparacion(Posicion posicion, Tamanio tamanio, AdministradorJuego escenario, Nave nave) {
		super(posicion, tamanio, escenario,nave);
		this.valorReparacion=this.getAdministradorJuego().getConfiguracionInicial().getValorReparacionBonus();
	}


	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
		
	}


	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		darBeneficio(bonus.getDuenio());
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


	@Override
	public void chocarContraPared() {}
	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {}

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
	}


	@Override
	public void chocarContraBomba(Bomba bomba) {
		darBeneficio(bomba.getDuenio());
	}


	@Override
	public void chocarContraNave(Nave nave) {
		this.destruir(this);
	}

}
