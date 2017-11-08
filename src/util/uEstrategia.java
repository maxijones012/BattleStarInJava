package util;

import java.util.ArrayList;

import logicaJuego.Bomba;
import logicaJuego.Bonus;
import logicaJuego.BonusReparacion;
import logicaJuego.Elemento;
import logicaJuego.Misil;
import logicaJuego.Nave;
import logicaJuego.NaveEcuatorial;

public class uEstrategia {

	
	/**
	 * cambia la direccion de la nave
	 * @param nave
	 */
	public static void eludir(Nave nave) {
		nave.setDireccion(nave.getDireccion()-90);
	}

	
	
	/**
	 * Esquiva todos los elementos del juego como {@link Misil misil} {@link Bomba bomba} {@link Nave nave},
	 * 
	 * 
	 * Y SI ENCUENTRA UN {@link Bonus bonus} dispara 
 	 * @param elementos
	 * @param nave
	 */
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
			
			if (e instanceof Bonus){
				nave.dispararMisil(nave);
			}
		}
		
	};
	
	
	
	/**
	 * Cuando detecta una nave, realiza el seguimiento del mismo
	 * @param elementos
	 * @param nave
	 */
	public static void seguirNave(ArrayList<Elemento> elementos, Nave nave){
		for (int i = 0; i < elementos.size(); i++) {
			Elemento e = elementos.get(i);
			if (e instanceof Nave){
				if (e != nave){
					nave.getRadar().setDireccion(((Nave) e).getDireccion());
					
				}
			}
		}
	}
	
	
	/**
	 * Cuando la {@link NaveGreenwich  naveGreenwich} encuentra un elemento
	 * que sea una {@link Nave nave} dispara
	 * @param elementos
	 * @param nave
	 */
	public static void inteligenciaGreenwich(ArrayList<Elemento> elementos, Nave nave) {
		for (int i = 0; i < elementos.size(); i++) {
//			nave.dispararMunicion(nave);
			Elemento e = elementos.get(i);
			if (e instanceof Nave){
				if (e != nave){
					nave.dispararMisil(nave, nave.getRadar().getDireccion());
				}
			}
		}
		
	};
	/**
	 * Mueve el radar en grados ( ° ) tomando como angulo de vision
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
	
	/**
	 * Cuando la {@link Nave nave} detecta otra {@link Nave nave} dispara un misil 
	 * @param elementos
	 * @param nave
	 */
	public static void inteligenciaDispararNave(ArrayList<Elemento> elementos, Nave nave) {
		for (int i = 0; i < elementos.size(); i++) {
//			nave.dispararMunicion(nave);
			Elemento e = elementos.get(i);
			if (e instanceof Nave){
				if (e != nave){
					nave.dispararMisil(nave);
				}
			}
		}
		
	}

	
	
	/**
	 * la {@link Nave nave} busca con su radar un {@link BonusReparacion bonusReparacion},
	 * 		si lo encuentra dispara un {@link Misil misil}, en caso de no poseer misiles, dispara una 
	 * 		{@link Bomba bomba}
	 * @param elementos
	 * @param nave
	 */
	public static void buscarCombustible(ArrayList<Elemento> elementos, Nave nave) {
		for (int i = 0; i < elementos.size(); i++) {
			Elemento e = elementos.get(i);
			
			if (e instanceof BonusReparacion) {
				//si tene municion que misil
				if (nave.getCantidadMunicion()>0){
					
					int dir = nave.getRadar().getDireccion();
					dir += nave.getDireccion();
					nave.dispararMisil(nave, dir);					
				}else{ //que dispare una bomb
					int dir = nave.getRadar().getDireccion();
					dir += nave.getDireccion();
					nave.dispararBomba(nave, dir);
				}
			}
			
			
		}
		
	}



	public static void inteligenciaEcuatorial(ArrayList<Elemento> elementos, NaveEcuatorial naveEcuatorial) {
		int cant = buscarCantidadNave(elementos);
		for (int i = 0; i < elementos.size(); i++) {
			int dir=0;
			
			if (cant>0){
				if (cant==3){
					int dir1 = naveEcuatorial.getRadar().getDireccion();
					naveEcuatorial.dispararBomba(naveEcuatorial,dir1);
				}else
					dir = naveEcuatorial.getRadar().getDireccion();
					naveEcuatorial.dispararMisil(naveEcuatorial, dir);
			}
//			 Elemento e = elementos.get(i);

		}		
	};
	
	
	
	
	/**
	 * busca la cantidad de Naves que se han detectado
	 * @param elementos
	 * @return
	 */
	private static int buscarCantidadNave(ArrayList<Elemento> elementos) {
		int contador=0;
		
		for (int i = 0; i < elementos.size(); i++) {
			 Elemento e = elementos.get(i);

			if (e instanceof Nave){contador++;}
		}
		return (contador);
	}
}
