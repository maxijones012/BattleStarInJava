package util;

import java.util.ArrayList;

import logicaJuego.Bomba;
import logicaJuego.Elemento;
import logicaJuego.Misil;
import logicaJuego.Nave;
import logicaJuego.NaveGreenwich;

public class uEstrategia {

	
	/**
	 * cambia la direccion de la nave
	 * @param nave
	 */
	public static void eludir(Nave nave) {
		nave.setDireccion(nave.getDireccion()-90);
	}

	public static void inteligencia(ArrayList<Elemento> elementos, Nave nave) {
		for (int i = 0; i < elementos.size(); i++) {
			Elemento e = elementos.get(i);
			if ((e instanceof Misil) || (e instanceof Bomba)){
				uEstrategia.eludir(nave);
			}
			if (e instanceof Nave){
				if (e != nave){
					uEstrategia.eludir(nave);
				}
			}
		}
		
	};
	
	
	public static void inteligenciaGreenwich(ArrayList<Elemento> elementos, Nave nave) {
		for (int i = 0; i < elementos.size(); i++) {
//			nave.dispararMunicion(nave);
			Elemento e = elementos.get(i);
			if (e instanceof Nave){
				if (e != nave){
					nave.dispararMunicion(nave);
				}
			}
		}
		
	};
	/**
	 * Mueve el radar en grados ( � ) tomando como angulo de vision
	 * @param tope como referencia.
	 * 
	 * 
	 * 
	 * @param nave
	 * @param tope
	 * @param ini
	 * @param velocidadGiro es recomendable dejar en velocidadGiro=1
	 * 
	 * Ejemplo girarCorrector(nave, 10 , 0, 2);
	 * 
	 *	el radar gira desde la posicion de la {@link Nave nave}
	 *	con 10 grados hacia izquierda y derecha
	 */
	public static void girarCorrectorRadar(Nave nave, int tope, int ini,int velocidadGiro) {
		
		if (nave.getRadarOn()==true){
			nave.getRadar().girar(velocidadGiro);
			if (   nave.getRadar().getDireccion()>tope ){
				nave.setRadarOn(false);
			}
			else
				nave.setRadarOn(true);
		}
		else
			nave.getRadar().girar(-velocidadGiro);
		if (   nave.getRadar().getDireccion()<ini ){
			nave.setRadarOn(true);
		}
	}
	
	
}