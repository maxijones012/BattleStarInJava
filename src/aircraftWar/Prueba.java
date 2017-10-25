package aircraftWar;

import configuracion.ConfiguracionInicial;
import logicaJuego.AdministradorJuego;
import sonido.uSonido;

public class Prueba {

	public static void main(String[] args) {
		uSonido.reproducir("/sonido/inicio.wav");
		
		AdministradorJuego administradorJuego = new AdministradorJuego(new ConfiguracionInicial());
		administradorJuego.iniciarJuego();

		
	}

}
