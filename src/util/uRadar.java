package util;

import java.awt.Polygon;

import logicaJuego.Nave;
import logicaJuego.Posicion;
import logicaJuego.Radar;

public abstract class uRadar {

	
	/**
	 * Devuelve el area de cobertura del radar
	 * @param radar
	 * @return
	 */
	public static Polygon getAreaCobertura(Radar radar) {

		   	Polygon areaCobertura = new Polygon();

			Posicion auxPosicion = uMovimiento.getCentro(radar.getDuenio());

			//corregimos la posicion del robot para que el radar salga desde el centro
			int duenioX= auxPosicion.getX(); 
			int duenioY= auxPosicion.getY();

			int direccion = radar.getDireccion();	
			
			//APUNTA CON LA MISMA DIRECCION DEL ROBOT
			if (radar.getDuenio() instanceof Nave){
				direccion +=( (Nave)radar.getDuenio()  ).getDireccion();
			}
			
			areaCobertura.addPoint(duenioX, duenioY);
			
			for (int i = ((direccion)-(radar.getAnguloApertura()/2));
					 i < (direccion)+(radar.getAnguloApertura()/2); 
					 i++) {
				
				int x= (int) (duenioX+ Math.cos(Math.toRadians(i))*radar.getAlcance());
				int y= (int) (duenioY+ Math.sin(Math.toRadians(i))*radar.getAlcance());
			
				areaCobertura.addPoint(x, y);
			}		
			
			return areaCobertura; //devuelvo el poligono
		}

}
