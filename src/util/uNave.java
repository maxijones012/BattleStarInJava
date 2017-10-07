package util;

import logicaJuego.Bomba;
import logicaJuego.Misil;
import logicaJuego.Nave;

public class uNave {
	public static void disminuirEscudo(Nave nave, Bomba bomba) {
		if (nave.equals(bomba.getDuenio())){
			nave.setNivelCombustible(nave.getNivelEscudo()- bomba.getDanio());
		}		
	}


	public static void disminuirEscudo(Nave robot, Misil municion) {
		if (robot.equals(municion.getDuenio())){
			robot.setNivelEscudo(robot.getNivelEscudo()- municion.getDanio());			
		}		
	}
	
	
	public static void girarCorrector(Nave nave, int ini, int max,int velocidadGiro) {
		
		if (nave.getRadarOn()==true){
			nave.getRadar().girar(velocidadGiro);
			if (   nave.getRadar().getDireccion()>ini ){
				nave.setRadarOn(false);
			}
			else
				nave.setRadarOn(true);
		}
		else
			nave.getRadar().girar(-velocidadGiro);
		if (   nave.getRadar().getDireccion()<max ){
			nave.setRadarOn(true);
		}
	}
	
}
