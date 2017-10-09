package util;

import java.awt.Polygon;

import logicaJuego.Nave;
import logicaJuego.Radar;

public abstract class uRadar {

	public static Polygon getAreaCobertura(Radar radar) {

		   	Polygon areaCobertura = new Polygon();

		   	
			int duenioX= (int)radar.getDuenio().getPosicion().getX()+10; 
			int duenioY= (int)radar.getDuenio().getPosicion().getY()+10;
			
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
