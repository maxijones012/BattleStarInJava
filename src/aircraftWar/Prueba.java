package aircraftWar;

import grafica.ingresoDatos.PantallaDatosUsuario;
import grafica.pantallaCarga.PantallaCargandoMain;
import logicaJuego.AdministradorJuego;
import sonido.uSonido;
import util.uMovimiento;

public class Prueba {

	public static void main(String[] args) {
		uSonido.reproducir("/sonido/inicio.wav");
		pantallaIngresoDatos();

		pantallaCarga();
		
		
		AdministradorJuego administradorJuego = AdministradorJuego.getInstancia();
		administradorJuego.iniciarJuego();

		
	}

	

	private static void pantallaIngresoDatos() {
		PantallaDatosUsuario pantalla = new PantallaDatosUsuario();
		pantalla.main(null);
	}



	/**
	 * Crea la pantalla de carga
	 */
	private static void pantallaCarga() {
		new PantallaCargandoMain();
		uMovimiento.espera(60);
		
	}

}
