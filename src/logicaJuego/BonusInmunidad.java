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
		darBeneficio(bonus.getDuenio());
	}

	@Override
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

}
