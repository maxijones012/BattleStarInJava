package logicaJuego;

import java.util.ArrayList;

/**
 *  Se  mueve  por  el  escenario  sin  un  rumbo  fijo,  y  dispara  misiles  cada  vez  que  toca  
 *     alguno​ ​de​ ​los​ ​límites​ ​del​ ​escenario.
 * @author Maxi Jones
 *
 */
public class NaveCrazy extends Nave{
	
	
	
	/**
	 * Constructor de la clase crazy
	 * @param posicion
	 * @param tamanio
	 * @param escenario
	 */
	public NaveCrazy(Posicion posicion, Tamanio tamanio, AdministradorJuego escenario) {
		super(posicion, tamanio, escenario);
	}


	
	
	@Override
	public void jugar() {
		
		super.jugar();
	}




	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
	}


	@Override
	public void chocarContraPared() {
		super.girar(-90); //TODO CAPAZ QUE HAY QUE CAMBIARLO A 90
		this.disparar(new Misil(this, null, null, null)); //TODO VERIFICAR LOS 'NULL'
	}




	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {
		// TODO preguntar que deberia hacer
		
	}













	

}
