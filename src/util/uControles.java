package util;
import java.awt.event.KeyEvent;

import configuracion.ConfiguracionInicial;
import grafica.TableroJuego;
import sonido.uSonido;

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
//
//	public static String verficarTecla(NaveManual naveManual) {
// 		if(naveManual.getAdministradorJuego().getConfiguracionInicial().isDisMunicion()){			
//			this.getAdministradorJuego().getConfiguracionInicial().setDisMunicion(false);
//			uSonido.reproducir("/sonido/misil2.wav");
//		}
//		if(this.getAdministradorJuego().getConfiguracionInicial().isDisBomba()){
//			this.dispararBomba(this);
//			this.getAdministradorJuego().getConfiguracionInicial().setDisBomba(false);
//			uSonido.reproducir("/sonido/laser2.wav");
//		}
//		if (this.getAdministradorJuego().getConfiguracionInicial().isDerecha()){
//			this.setDireccion(0);		
//		}
//		else{
//			if (this.getAdministradorJuego().getConfiguracionInicial().isIzquierda()){
//				this.setDireccion(180);
//			}
//			else{
//				if (this.getAdministradorJuego().getConfiguracionInicial().isArriba()){
//					this.setDireccion(270);
//				}
//				else{
//					this.setDireccion(90); 
//				}
//			}
//		}
//		return null;
//	}
}
