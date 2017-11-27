package logicaJuego;

import configuracion.ConfiguracionInicial;


/**
 * clase Misil
 * @author Maxi
=======
/**
 * Clase misil 
 * @author carlos
>>>>>>> 6e7d4ce53ccf88826b50abf489bffed50a4b3cf0
 *
 */
public class Misil extends Movible{
	private int nivelDanioMisil=ConfiguracionInicial.DANIO_MISIL;
	private Nave duenio;
	
	/**
	 * Constructor de la clase Misil donde toma la posicion de la {@link Nave nave}
	 * @param duenio
	 * @param posicion
	 * @param tamanio
	 * @param administradorJuego
	 */
	public Misil(Nave duenio, Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion,tamanio, administradorJuego);
		this.duenio= duenio;
		this.setVelocidadAvance(ConfiguracionInicial.VELOCIDAD_MISIL);		
		this.nivelDanioMisil=getAministradorJuego().getConfiguracionInicial().getNivelDanioMisil();
	}

	@Override
	/**
	 * JUGAR DE MISIL REDEFINE EL METODO JUGAR DE ELEMENTO 
	 */
	public void jugar() {
		if (this.getVelocidadAvance()>0){
			super.avanzar();
			this.setVelocidadAvance(this.getVelocidadAvance()-1); // SI LA VELOCIDAD DE AVANCE ES MAYOR A 0
																 // LA DECREMENTO EN UNA UNIDAD
		}
		else{
			super.destruir(this); // CUANDO LLEGA A CERO DESTRUYO EL MISIL 
		}
		
	}
	public Nave getDuenio() {
		return duenio;
	}

	public void setDuenio(Nave duenio) {
		this.duenio = duenio;
	}

	public int getNivelDanio() {
		return nivelDanioMisil;
	}



	@Override
	/**
	 * llamo al chocar contra del elemeto que choca con el misil
	 * @param elemento
	 * TODO cualquier elemento que choca con el misl
	 */
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraMisil(this);
		
	}


	@Override
	/**
	 *Se invoca el metodo destruir del bonus de reparacion
	 *@param bonus
	 */
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		bonus.darBeneficio(this);
		this.destruir(this);
	}


	@Override
	/**
	 * se llama al destruir del bonus
	 * @param bonus
	 */
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		this.destruir(this);		
	}


	@Override
	/**
	 * se destruye el bonus
	 * @author carlos
	 * @param bonus
	 */
	public void chocarContraBonusMisil(BonusMisil bonus) {
		this.destruir(this);
		
	}


	@Override
	/**
	 * se destruye el misl 
	 * si el misl se pasa de rango se destruye 
	 */
	public void chocarContraPared() {
		this.destruir(this);
		System.out.println("MISIL CHOCO CONTRA PARED Y MURIO");
	}


	@Override
	/**
	 * llamo al metodo destruir de bomba 
	 * @param bomba 
	 */
	public void chocarContraBomba(Bomba bomba) {
		this.destruir(this);
	}


	@Override
	/**
	 * llamo al metodo destruir de nave
	 * @param nave
	 */
	public void chocarContraNave(Nave nave) {
		if (nave != this.getDuenio()){
			this.destruir(this);			
		}
	}

	@Override
	/**
	 * Destruyo el misil 
	 */
	public void chocarContraPazadizo(Pasadizo pasadizo) {
		this.destruir(this);
		
	}



	@Override
	/**
	 *  SI  EL MISIL CHOCA CONTRA UN MISIL DE OTRA NAVE  ESTE PRIMERO SE DESTRUYE	
	 */
	public void chocarContraMisil(Misil misil) {
		if (misil.getDuenio()!= this.getDuenio()){
			this.destruir(this);
		}
	}

	@Override
	/**
	 * CUANDO CHOCO CONTRA UN OBSTACULO EXPLOSIVO EL MISIL LO DESTRUYO 
	 */
	public void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculoExplosivo) {
		this.destruir(this);
	}
	
	

}
