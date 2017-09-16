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
		movible.getPosicion().setPosicionX((int) (movible.getPosicion().getPosicionX()+ Math.cos(Math.toRadians(movible.getDireccion()))*movible.getVelocidad()));		
	}
	public static void avanzarY(Movible obj){
		obj.getPosicion().setPosicionY((int) (obj.getPosicion().getPosicionY()+ Math.sin(Math.toRadians(obj.getDireccion()))*obj.getVelocidad()));		
	}
	
}
