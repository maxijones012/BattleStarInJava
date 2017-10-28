package util;

import logicaJuego.Movible;
import logicaJuego.Nave;
import logicaJuego.Posicion;
import logicaJuego.Tamanio;

import java.util.Random;
import logicaJuego.Elemento;

/**
 * Clase encargada UTIL de todos los movimiento de los objetos del escenario
 * @author Maxi Jones
 *
 */
public abstract class uMovimiento{
	
	/**
	 * Gira la dirección del canion en un determinado angulo {@link Movible movible}
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
	 * Avanza obteniendo la posicion del objeto {@link Moible movible} en X
	 * @param movible
	 */
	public static void avanzarX(Movible movible){
		movible.getPosicion().setX((int) (movible.getPosicion().getX()+ Math.cos(Math.toRadians(movible.getDireccion()))*movible.getVelocidadAvance()));		
	}
	
	/**
	 * Avanza obteniendo la posicion del objeto {@link Moible movible} en Y
	 * @param obj
	 */
	public static void avanzarY(Movible obj){
		obj.getPosicion().setY((int) (obj.getPosicion().getY()+ Math.sin(Math.toRadians(obj.getDireccion()))*obj.getVelocidadAvance()));		
	}
	
	/**
	 * Obtiene la posicion de un {@link Elemento elemento}
	 * @param e
	 * @return posicionX
	 */
	public static int obtenerPosicionX(Elemento e) {
		return (e.getPosicion().getX());
	}

	/**
	 * Obtiene la posicion de un {@link Elemento elemento}
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
	
	
	public static final Posicion getCentro(Elemento elemento){
		
		int x = elemento.getTamanio().getAncho()/2 + elemento.getPosicion().getX();
		int y = elemento.getTamanio().getAlto()/2  + elemento.getPosicion().getY();
		
		return new Posicion(x, y);		
	}
	

	
	public static final Posicion getCentro(Tamanio tamanio ,Posicion posicion){
		
		int x = tamanio.getAncho()/2 + posicion.getX();
		int y = tamanio.getAlto()/2  + posicion.getY();
		
		return new Posicion(x, y);		
	}

	
	
	
	
	/**
	 * avanzar tantas veces como el parametro {@linkplain i} , lo indique
	 * @param nave 
	 * @param i
	 */
	public static void avanzarMuchasVeces(Nave nave, int i) {
		for (int j = 0; j < i; j++) {
			nave.avanzar();
		}
		
	}
	
}
