package util;

import logicaJuego.Elemento;

public abstract class DebugConsola {

	
	public static void posicion(Elemento elemento){
		int x= elemento.getPosicion().getX();
		int y= elemento.getPosicion().getY();
		System.out.println("X:"+x+"Y: "+y);
	}
}
