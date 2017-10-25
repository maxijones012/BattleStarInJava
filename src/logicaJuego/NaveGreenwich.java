package logicaJuego;

import java.util.ArrayList;
import java.util.Random;

import configuracion.Constante;
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
		this.setDireccion(Constante.UP);
	}
	
	@Override
	public void jugar() {
		avanzar();
		this.getRadar().escanear();
		this.getRadar().girar(1);
	}



	@Override
	/**
	 * INVIERTO LA DIRECCION DE LA NAVE 
	 */
	public void chocarContraPared() {
		this.girar(90);
		this.avanzar();
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
