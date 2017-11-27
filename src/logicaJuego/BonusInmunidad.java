package logicaJuego;
/**
 * Cuando una nave obtiene este bonus, permanece inmune (no
	se​ ​destruye)​ ​por​ ​un​ ​tiempo​ ​determinado.
 * @author carlos
 *
 */
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
	 * llamO al metodo del elemento que chocaContraBonusInmunidad ()
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

	
	
	/**
	 * TODO VERIFICO QUE LA INSTANCIA DE NAVE NO SEA NULL
	 * @param nave
	 */
	private void darBonusInmunidad(Nave nave) {
		if (nave != null){
			nave.setInmunidad(true);			
		}
	}

	@Override
	/**
	 * METODO VACIO NO HAGO NADA 
	 */
	public void chocarContraPared() {}

	@Override
	/**
	 * ejecuto el metodo destruir de bonus de inmunidad  
	 */
	public void chocarContraBomba(Bomba bomba) {
		this.destruir(this);
	}

	@Override
	
	public void chocarContraNave(Nave nave) {
		this.destruir(this);
	}

	@Override
	/**
	 * Cuando choco contra otro bonus no hago nada 
	 */
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {}

	@Override
	/**
	 * cuando choco  contra un pasadizo no hago nada 
	 */
	public void chocarContraPazadizo(Pasadizo pasadizo) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void chocarContraMisil(Misil misil) {
		this.destruir(this);
	};

}
