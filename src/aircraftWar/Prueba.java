package aircraftWar;

import grafica.ingresoDatos.PantallaDatosUsuario;
import grafica.pantallaCarga.PantallaCargandoMain;
import logicaJuego.AdministradorJuego;
import sonido.uSonido;
import util.uMovimiento;


public class Prueba {

	public static void main(String[] args) {
		uSonido.reproducir("/sonido/inicio.wav");

		pantallaCarga();
		
		pantallaIngresoDatos();
		
		AdministradorJuego administradorJuego = AdministradorJuego.getInstancia();
		administradorJuego.iniciarJuego();
		
	}

	
	/**
	 * muestra una pantalla con los ingresos de datos del usuario
	 */
	private static void pantallaIngresoDatos() {
		uMovimiento.espera(60);
		PantallaDatosUsuario pantalla = new PantallaDatosUsuario();
		pantalla.main(null);
	}



	/**
	 * Crea la pantalla de carga
	 */
	private static void pantallaCarga() {
		new PantallaCargandoMain();
	}

}
