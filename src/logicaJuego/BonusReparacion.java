package logicaJuego;

import configuracion.ConfiguracionInicial;

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
	public BonusReparacion(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego, Nave nave) {
		super(posicion, tamanio, administradorJuego,nave);
		this.valorReparacion=this.getAdministradorJuego().getConfiguracionInicial().getValorReparacionBonus();
	}


	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBonusReparacion(this);
		
	}


	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		darBeneficio(bonus.getDuenio());
	}




	@Override
	public void darBeneficio(Nave nave) {
		darBonusReparacion(nave);
	}

	
	public void darBeneficio(Misil misil) {
		darBonusReparacion(misil);
	}
	
	
	
	/**
	 * le da el beneficio de combustible y vida al dueño del misil
	 * @param misil
	 */
	private void darBonusReparacion(Misil misil) {
		Nave nave=misil.getDuenio(); 
		nave.setNivelVida(nave.getNivelVida()+valorReparacion);
		nave.setNivelCombustible(ConfiguracionInicial.NIVEL_COMBUSTIBLE);

		
	}

	private void darBonusReparacion(Nave nave) {
		if (nave != null){
			nave.setNivelVida(nave.getNivelVida()+valorReparacion);		
			nave.setNivelCombustible(ConfiguracionInicial.NIVEL_COMBUSTIBLE);
		}
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
		this.destruir(this);
	}


	@Override
	public void chocarContraNave(Nave nave) {
		this.destruir(this);
	}


	@Override
	public void chocarContraPazadizo(Pasadizo pasadizo) {}


	@Override
	public void chocarContraMisil(Misil misil) {
		this.destruir(this);
	}

}
