package util;
import java.awt.event.KeyEvent;

import configuracion.ConfiguracionInicial;
import grafica.TableroJuego;
import logicaJuego.NaveManual;

public class uControles {

	
	public static void controlTeclado(TableroJuego obj ,KeyEvent e,ConfiguracionInicial configuracionInicial){

		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			configuracionInicial.setAbajo(true);
			configuracionInicial.setArriba(false);
			configuracionInicial.setIzquierda(false);
			configuracionInicial.setDerecha(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			configuracionInicial.setAbajo(false);
			configuracionInicial.setArriba(true);
			configuracionInicial.setIzquierda(false);
			configuracionInicial.setDerecha(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			configuracionInicial.setAbajo(false);
			configuracionInicial.setArriba(false);
			configuracionInicial.setIzquierda(false);
			configuracionInicial.setDerecha(true);	
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			configuracionInicial.setAbajo(false);
			configuracionInicial.setArriba(false);
			configuracionInicial.setIzquierda(true);
			configuracionInicial.setDerecha(false);	
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE ){
			configuracionInicial.setDisMunicion(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_B){
			configuracionInicial.setDisBomba(true);
		}
	}

	public static String verficarTecla(NaveManual naveManual) {
 		if(naveManual.getAdministradorJuego().getConfiguracionInicial().isDisMunicion()){
 			return("BARRA_ESPACIADORA");
		}
		if(naveManual.getAdministradorJuego().getConfiguracionInicial().isDisBomba()){
			return("B");
		}
		if (naveManual.getAdministradorJuego().getConfiguracionInicial().isDerecha()){
			return("DERECHA");
		}
		else{
			if (naveManual.getAdministradorJuego().getConfiguracionInicial().isIzquierda()){
				return("IZQUIERDA");
			}
			else{
				if (naveManual.getAdministradorJuego().getConfiguracionInicial().isArriba()){
					return("ARRIBA");
				}
				else{
					return("ABAJO");
				}
			}
		}
	}

	public static void apagarTeclas(NaveManual naveManual) {
//		naveManual.getAdministradorJuego().getConfiguracionInicial().setAbajo(false);
//		naveManual.getAdministradorJuego().getConfiguracionInicial().setArriba(false);
//		naveManual.getAdministradorJuego().getConfiguracionInicial().setIzquierda(false);
//		naveManual.getAdministradorJuego().getConfiguracionInicial().setDerecha(false);
		naveManual.getAdministradorJuego().getConfiguracionInicial().setDisBomba(false);
		naveManual.getAdministradorJuego().getConfiguracionInicial().setDisMunicion(false);
	}
}
