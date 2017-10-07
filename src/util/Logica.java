package util;

import java.util.Random;

import logicaJuego.Elemento;
import logicaJuego.Escenario;
import logicaJuego.NaveCrazy;
import logicaJuego.Posicion;


public class Logica{
	
	
	/**
	 * da los turno a cada elemento del juego 
	 * @param escenario
	 */
	public static void darTurno(Escenario escenario){
		for(int i=0; i<escenario.getListaElemento().size(); i++){
			Elemento elemento = escenario.getListaElemento().get(i);			
			elemento.jugar();
		}
	}
	


	


}
