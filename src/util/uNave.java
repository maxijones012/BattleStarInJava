package util;

import logicaJuego.Bomba;
import logicaJuego.Misil;
import logicaJuego.Nave;
import logicaJuego.NaveEcuatorial;

public abstract class uNave {
	public static void disminuirEscudo(Nave nave, Bomba bomba) {
		if (nave.equals(bomba.getDuenio())){
			nave.setNivelCombustible(nave.getNivelEscudo()- bomba.getDanioBomba());
		}		
	}


	public static void disminuirEscudo(Nave robot, Misil misil) {
		if (robot.equals(misil.getDuenio())){
			robot.setNivelEscudo(robot.getNivelEscudo()- misil.getNivelDanio());			
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
