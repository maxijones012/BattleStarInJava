package util;

import logicaJuego.Movible;
import java.util.Random;
import logicaJuego.Elemento;

/**
 * Clase encargada UTIL de todos los movimiento de los objetos del escenario
 * @author Maxi Jones
 *
 */
public abstract class uMovimiento{
	
	/**
	 * Gira la dirección del canion en un determinado angulo
	 * 
	 * @param angulo Ángulo que se desea girar. Si el canion tiene un angulo actual de 100º y se gira 30º, el resultado 
	 * debera ser un angulo final de 130º
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
	
	/**
	 * Obtiene la posicion de un elemento
	 * @param e
	 * @return posicionX
	 */
	public static int obtenerPosicionX(Elemento e) {
		return (e.getPosicion().getX());
	}

	/**
	 * Obtiene la posicion de un elemento
	 * @param e
	 * @return posicionY
	 */
	public static int obtenerPosicionY(Elemento e) {
		return (e.getPosicion().getY());
	}
	
	/**
	 * Genera una posicion aleatoria en el juego base
	 * y devuelve un X
	 * @return X
	 */
	public static int posicionAleatoriaX(){
		Random randx = new Random();
		return (int) (randx.nextDouble());
	}
	
	/**
	 * Genera una posicion aleatoria en el en juego base 
	 * y devuelve un Y
	 * @return
	 */
	public static int posicionAleatoriaY(){
		Random randy = new Random();
		return (int) ( randy.nextDouble() );
	}



}
