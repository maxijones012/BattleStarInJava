package util;

import logicaJuego.Elemento;
import logicaJuego.Nave;

public abstract class uDebugConsola {

	/**
	 * Muestra la posicion del elemento en {@linkplain (X,Y)}
	 * @param elemento
	 */
	public static void mostrarPosicion(Elemento elemento){
		int x= elemento.getPosicion().getX();
		int y= elemento.getPosicion().getY();
		System.out.println("X:"+x+"Y: "+y);
	}
	
	public static void mostrarNombreElemento(Elemento elemento){
		String c = elemento.getClass().getName();
		c = c.substring(12, c.length());
		System.out.println(c);
		System.out.println("|------------------------------------------");
	};

	
	
	public static String retornarNombreElemento(Elemento elemento){
		String c = elemento.getClass().getName();
		c = c.substring(12, c.length());
		return (c);
	};
	
	
	/**
	 * Muestra la colision entre dos {@link Elemento elementos} 
	 * @param e
	 * @param e1
	 */
	public static void mostrarColision(Elemento e, Elemento e1){
		String c = e.getClass().getName();
		c = c.substring(12, c.length());
		
		String c1 = e1.getClass().getName();
		c1 = c1.substring(12, c1.length());
		
		System.out.println("COLISION: ");
		
		System.out.println(c +", con: "+ c1);
		
	}
	
	
	/**
	 * Muestra  el estado del elemento, vida, posicion
	 * @param elemento
	 * @return
	 */
	public static String mostrarEstado(Elemento elemento) {
		String c=("Vida: "+Integer.toString(elemento.getNivelVida())); 
		c +=(", X: "+Integer.toString(elemento.getPosicion().getX())); 
		c += (", Y: "+Integer.toString(elemento.getPosicion().getY()));
		Nave nave = (Nave) elemento;
		c += (", Municion: "+Integer.toString(nave.getCantidadMunicion()));
		c += (", Bomba: "+Integer.toString(nave.getCantidadBomba()));
		c += (", Combustible: "+Integer.toString(nave.getNivelCombustible()));
		
		return c;
	};
}
