package util;

import logicaJuego.Movible;

public class Movimiento{
	
	public static void girar(Movible movible, int direccion){
		int dirNueva = movible.getDireccion() + direccion;
		while (dirNueva >= 360){
			dirNueva = dirNueva - 360;
		}
		movible.setDireccion(dirNueva);
	}
	
	/**
	 * Avanza obteniendo la posicion del objeto
	 * @param movible
	 */
	public static void avanzarX(Movible movible){
		movible.getPosicion().setX((int) (movible.getPosicion().getX()+ Math.cos(Math.toRadians(movible.getDireccion()))*movible.getVelocidad()));		
	}
	public static void avanzarY(Movible obj){
		obj.getPosicion().setY((int) (obj.getPosicion().getY()+ Math.sin(Math.toRadians(obj.getDireccion()))*obj.getVelocidad()));		
	}
	
}
