package util;

import logicaJuego.Elemento;

public abstract class uDebugConsola {

	
	public static void posicion(Elemento elemento){
		int x= elemento.getPosicion().getX();
		int y= elemento.getPosicion().getY();
		System.out.println("X:"+x+"Y: "+y);
	}
	
	public static void mostrarNombreElemento(Elemento elemento){
		String c = elemento.getClass().getName();
		c = c.substring(12, c.length());
		System.out.println(c);
	};
}
