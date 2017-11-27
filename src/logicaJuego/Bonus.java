package logicaJuego;

import util.uDebugConsola;
/**
 * Clase abstracta bonus las sub clases que extienden de bonus deben de redefinir sus metodos 
 * @author carlos
 *
 */

public abstract class Bonus extends Elemento{
	private int tiempoVida;
	private Nave duenio;
/**
 * Constructor de la clase bonus 
 * @param posicion
 * @param tamanio
 * @param administradorJuego
 * @param duenio
 */
	public Bonus(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego, Nave duenio) {
		super(posicion, tamanio, administradorJuego);
		this.duenio=duenio;
		this.tiempoVida=this.getAdministradorJuego().getConfiguracionInicial().getTiempoVidaBonus();
	}

	@Override
	/**
	 * logica de juego del bonus 
	 */
	public void jugar(){
		uDebugConsola.mostrarPosicion(this);
		uDebugConsola.mostrarNombreElemento(this);
		if (this.getTiempoVida()>0){
			this.setTiempoVida(this.getTiempoVida()-1);
		}
		else{
			super.destruir(this);
		}
	};
	/**
	 * metodo darBeneficio generico  las sub clases que extienden de bonus re definen este metodo  
	 * @param nave
	 */
	public abstract  void darBeneficio(Nave nave);
	
	
	
	public int getTiempoVida() {
		return tiempoVida;
	}

	public void setTiempoVida(int tiempoVida) {
		this.tiempoVida = tiempoVida;
	}



	public Nave getDuenio() {
		return duenio;
	}	
	
	@Override
	/**
	 * Metodo vacio no hace nada 	
	 * Si Un bonus choca con un 
	 */
	public void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculoExplosivo) {}
	
}
