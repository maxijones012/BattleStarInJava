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
	/**
	 * EJECUTA EL METODO chocarContraBonusReparacion del  elemento 
	 */
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBonusReparacion(this);
		
	}


	@Override
	/**
	 * TODO ver que hago si se superponen dos bonus
	 */
	public void chocarContraBonusMisil(BonusMisil bonus) {
		darBeneficio(bonus.getDuenio());
	}




	@Override
	/**
	 * Otorogo el bonus de reparacion a la naves 
	 */
	public void darBeneficio(Nave nave) {
		darBonusReparacion(nave);
	}

	/**
	 * otorgo el bonus de reparacion a la nave duenia del misil 
	 * @param misil
	 */
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
	/**
	 * la nave duenia de la bomba enviada por parametro recive el bonus 
	 * el bonus reparacion se destruye
	 */
	public void chocarContraBomba(Bomba bomba) {
		darBeneficio(bomba.getDuenio());
		this.destruir(this);
	}


	@Override
	/**
	 * El bonus se destruye	
	 */
	public void chocarContraNave(Nave nave) {
		this.destruir(this);
	}


	@Override
	/**
	 * Metodo vacion si el bonus choca contra un pasazido no hago nada 
	 */
	public void chocarContraPazadizo(Pasadizo pasadizo) {}


	@Override
	/**
	 * el bonus se destruye 
	 */
	public void chocarContraMisil(Misil misil) {
		this.destruir(this);
	}

}
