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
	/**
	 * Nave Crazy Redefine el metodo jugar de Nave
	 */
	public void jugar() {
		if (this.getNivelCombustible()>0){
			super.jugar();
			uEstrategia.girarCorrectorRadar(this, 10, 0, 1);
			super.avanzar();			
		}
		super.jugar();
	}





	@Override
	/**
	 * cuando choco contra una pared disparo el misl 
	 */
	public void chocarContraPared() {
		super.girar(70); //TODO CAPAZ QUE HAY QUE CAMBIARLO A 90
		this.dispararMisil(this);
		System.out.println("Nave choco contra pared");
	}




	@Override
	/**
	 * ArrayList De elelemtos detectados por el radar de NaveCrazy
	 */
	public void elementosVistos(ArrayList<Elemento> elementos) {
		// TODO preguntar que deberia hacer
		
		if (this.getNivelCombustible()>0){
			uEstrategia.inteligencia(elementos, this);
		}else{	// si la nave se queda sin combustible entonces escanea el esecenario en busqueda de  un bonus de combustible 
			uEstrategia.buscarCombustible(elementos, this);
			this.getRadar().girar(3);
		}
		
		

	}

	
	@Override
	/**
	 * Nombre De La Nave 
	 */
	public String toString() {
		return ("CRAZY");
	}

	


}
