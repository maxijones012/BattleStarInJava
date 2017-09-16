package util;

import logicaJuego.Bomba;
import logicaJuego.Nave;
import logicaJuego.Posicion;
import logicaJuego.Tamanio;

public class Armamento {

	
	//TODO hacer disparar BOMBA
	public static void dispararBomba(Nave nave) {
		if (nave.getCantidadMunicion()>0){
			Posicion posicion = new Posicion(nave.getPosicion().getX(),nave.getPosicion().getY());
			Tamanio tamanio = new Tamanio(nave.getTamanio().getAncho(), nave.getTamanio().getAlto());
			new Bomba(nave, posicion,tamanio, nave.getEscenario());
		}
	}

	
	//TODO hacer disparar MUNICION
	public static void dispararMunicion(Nave nave) {
		
	}

}
