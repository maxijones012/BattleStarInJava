package util;

import logicaJuego.Bomba;
import logicaJuego.Municion;
import logicaJuego.Nave;
import logicaJuego.Posicion;
import logicaJuego.Tamanio;

/**
 * clase abstracta Armamento, donde tiene todos los metodos para 
 * que SOLO LOS OBJETOS MOVIBLES,puedan usarla
 * @author Maxi Jones
 *
 */
public abstract class Armamento {

	
	//TODO hacer disparar BOMBA
	public static void dispararBomba(Nave nave) {
		if (nave.getCantidadBomba()>0){
			Posicion posicion = new Posicion(nave.getPosicion().getX(),nave.getPosicion().getY());
			Tamanio tamanio = new Tamanio(nave.getTamanio().getAncho(), nave.getTamanio().getAlto());
			new Bomba(nave, posicion,tamanio, nave.getEscenario());
		}
	}

	
	//TODO hacer disparar MUNICION
	public static void dispararMunicion(Nave nave) {
		if (nave.getCantidadMunicion()>0){
			Posicion posicion = new Posicion(nave.getPosicion().getX(),nave.getPosicion().getY());
			Tamanio tamanio = new Tamanio(nave.getTamanio().getAncho(), nave.getTamanio().getAlto());
			new Municion(nave, posicion,tamanio, nave.getEscenario());
		}
	}

	public static void explotar(Bomba bomba){
		
		//generar un circulo
		//si choca 
		
		
	};
}
