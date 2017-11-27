package logicaJuego;


public class BonusMisil extends Bonus{

	/**
	 * Constructor de la clase bonus misil
	 * @param posicion
	 * @param tamanio
	 * @param administradorJuego
	 */
	public BonusMisil(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego, Nave nave) {
		super(posicion, tamanio, administradorJuego, nave);
	}



	@Override
	/**
	 * ejeuctual el metodo chocarContraBonusMisil del elemento enviado por parametro 
	 */
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBonusMisil(this);
		
	}


	@Override
	/**
	 * Metodo Vacio
	 */
	public void chocarContraBonusMisil(BonusMisil bonus) {
//		darBeneficio(bonus.getDuenio());
	}
	@Override
	/**
	 * otorgo el bonus de misil a la nave duenia del misil 
	 * ejecuto el metodo destruir del bonus 
	 */
	public void darBeneficio(Nave nave) {
		this.darBonusMisil(nave);
		this.destruir(this);
	}

	
	
	/**
	 * TODO VERFICAR QUE LA INSTANCIA DE NAVE NO SEA NULL
	 * @param nave
	 */
	private void darBonusMisil(Nave nave) { //TODO VERFICIAR QUE TOME LA MITAD
		if (nave!=null){
			nave.setCantidadMunicion(nave.getCantidadMunicion()+(nave.getCantidadMunicion()/2));
		}
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

	@Override
	public void chocarContraPazadizo(Pasadizo pasadizo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContraMisil(Misil misil) {
		this.destruir(this);
	}
	
}
