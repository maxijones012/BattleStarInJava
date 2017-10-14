package util;


import logicaJuego.Elemento;
import logicaJuego.AdministradorJuego;


public abstract class Logica{
	
	
	/**
	 * da los turno a cada elemento del juego 
	 * @param administradorJuego
	 */
	public static void darTurno(AdministradorJuego administradorJuego){
		for(int i=0; i<administradorJuego.getListaElemento().size(); i++){
			Elemento elemento = administradorJuego.getListaElemento().get(i);			
			elemento.jugar();
		}
	}
	


	


}
