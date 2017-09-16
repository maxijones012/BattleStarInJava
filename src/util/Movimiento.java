package util;

import logicaJuego.Movible;

/**
 * Clase encargada UTIL de todos los movimiento de los objetos del escenario
 * @author Maxi Jones
 *
 */
public abstract class Movimiento{
	
	/**
	 * Gira los elementos del juego, segun una direccion
	 * @param movible
	 * @param direccion
	 */
	public static void girar(Movible movible, int direccion){
		int dirNueva = movible.getDireccion() + direccion;
		while (dirNueva >= 360){
			dirNueva = dirNueva - 360;
		}
		movible.setDireccion(dirNueva);
	}
	
	/**
	 * Avanza obteniendo la posicion del objeto en X
	 * @param movible
	 */
	public static void avanzarX(Movible movible){
		movible.getPosicion().setX((int) (movible.getPosicion().getX()+ Math.cos(Math.toRadians(movible.getDireccion()))*movible.getVelocidadAvance()));		
	}
	
	/**
	 * Avanza obteniendo la posicion del objeto en Y
	 * @param movible
	 */
	public static void avanzarY(Movible obj){
		obj.getPosicion().setY((int) (obj.getPosicion().getY()+ Math.sin(Math.toRadians(obj.getDireccion()))*obj.getVelocidadAvance()));		
	}
	
}
