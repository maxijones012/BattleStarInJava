package util;
import java.awt.event.KeyEvent;

import configuracion.ConfiguracionInicial;
import grafica.TableroJuego;

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
}
