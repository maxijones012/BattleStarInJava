package logicaJuego;

import configuracion.ConfiguracionInicial;

public class Prueba {

	public static void main(String[] args) {
		
		ConfiguracionInicial config = new ConfiguracionInicial();
		AdministradorJuego administradorJuego = new AdministradorJuego(config);
		
		config.setEscenario(administradorJuego);
		
		administradorJuego.iniciarJuego();

		
	}

}
