package logicaJuego;

import java.util.ArrayList;
import util.uEstrategia;

/**
 * Se  mueve  por  el  escenario  sin  un  rumbo  fijo,  y  dispara  misiles  cada  vez  que  toca  
 * alguno​ ​de​ ​los​ ​límites​ ​del​ ​escenario.
 * @author Maxi Jones
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
		this.getRadar().setAnguloApertura(20);
	}
	
	@Override
	public void jugar() {		
		super.jugar();
		uEstrategia.girarCorrectorRadar(this, 10, 0, 1);
		super.avanzar();
	}





	@Override
	public void chocarContraPared() {
		super.girar(70); //TODO CAPAZ QUE HAY QUE CAMBIARLO A 90
		this.dispararMisil(this);
		System.out.println("Nave choco contra pared");
	}




	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {
		// TODO preguntar que deberia hacer
		uEstrategia.inteligencia(elementos, this);

	}

	
	@Override
	public String toString() {
		return ("CRAZY");
	}

	


}
