package aircraftWar;

import configuracion.ConfiguracionInicial;
import grafica.pantallaCarga.PantallaCargandoMain;
import logicaJuego.AdministradorJuego;
import sonido.uSonido;
import util.uMovimiento;

public class Prueba {

	public static void main(String[] args) {
//		uSonido.reproducir("/sonido/inicio.wav");

//		pantallaCarga();
		
		AdministradorJuego administradorJuego = AdministradorJuego.getInstancia();
		administradorJuego.iniciarJuego();

		
	}

	
	
	
	/**
	 * Crea la pantalla de carga
	 */
	private static void pantallaCarga() {
		new PantallaCargandoMain();
		uMovimiento.espera(60);
		
	}

}
