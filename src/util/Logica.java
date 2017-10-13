package util;


import logicaJuego.Elemento;
import logicaJuego.AdministradorJuego;


public abstract class Logica{
	
	
	/**
	 * da los turno a cada elemento del juego 
	 * @param escenario
	 */
	public static void darTurno(AdministradorJuego escenario){
		for(int i=0; i<escenario.getListaElemento().size(); i++){
			Elemento elemento = escenario.getListaElemento().get(i);			
			elemento.jugar();
		}
	}
	


	


}
