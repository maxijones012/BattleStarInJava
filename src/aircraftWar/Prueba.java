package aircraftWar;

import grafica.ingresoDatos.PantallaDatosUsuario;
import grafica.pantallaCarga.PantallaCargandoMain;
import logicaJuego.AdministradorJuego;
import sonido.uSonido;
import util.uMovimiento;


/**
 * Clase Prueba es la que se encarga inicar el juego 
 * @author carlos
 *
 */
public class Prueba {

	public static void main(String[] args) {
//		uSonido.reproducir("/sonido/inicio.wav"); //intro del juego 

//		pantallaCarga(); // pantalla de carga del juego 
		
		pantallaIngresoDatos(); //ingreso de datos del jugadoor
		
		AdministradorJuego administradorJuego = AdministradorJuego.getInstancia();
		administradorJuego.iniciarJuego();
		
	}

	
	/**
<<<<<<< HEAD
	 * muestra una pantalla con los ingresos de datos del usuario
=======
	 * Panel de ingreso de datos del usuario (nombre)
>>>>>>> 6e7d4ce53ccf88826b50abf489bffed50a4b3cf0
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
