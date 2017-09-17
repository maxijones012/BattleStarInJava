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
	
	/**
	 * Genera una posicion aleatoria en el juego base
	 * y devuelve un X
	 * @return X
	 */
	public static Double posicionAleatoriaX(){
		Random randx = new Random();
		return (randx.nextDouble());
	}
	
	/**
	 * Genera una posicion aleatoria en el en juego base 
	 * y devuelve un Y
	 * @return
	 */
	public static Double posicionAleatoriaY(){
		Random randy = new Random();
		return( randy.nextDouble() );
	}
	
	
	public static void eliminarElementos(Escenario escenario){
		
		for(int i=0; i<escenario.getListaElemento().size();i++){
			if (!escenario.getListaElemento().get(i).getEstaVivo())
				escenario.getListaElemento().remove(i);
		}
		
		
	}

	


}
