package logicaJuego;

import java.util.ArrayList;
import java.util.Random;

import util.uArmamento;
import util.uEstrategia;

public class NaveGreenwich extends Nave{
/**
 * constructor de la clase  NaveGreenwich
 * @param posicion
 * @param tamanio
 * @param administradorJuego
 */
	public NaveGreenwich(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
	}
	
	@Override
	public void jugar() {
		super.jugar();
		avanzar();
	}
	
	
	@Override
	//TODO preguntar por el giro en un angulo x 
	public void avanzar() {
		super.avanzar();
	}



	@Override
	/**
	 * llamo al  metodo de chocarContra del elemento que choca con la nave
	 */
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
	}



	@Override
	/**
	 * INVIERTO LA DIRECCION DE LA NAVE 
	 */
	public void chocarContraPared() {
		girar(90);
	}

	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {
		//TODO VERIFICAR LA DISTANCIA OPTIMA
		
		/*TODO
		 * IF (LA DISTANCIA ES OPTIMA){
		 * }
		 * */
		uEstrategia.inteligenciaGreenwich(elementos, this);
	}
	
	

	
	@Override
	public String toString() {
		return ("GREENWICH");
	}

}
