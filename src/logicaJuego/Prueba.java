package logicaJuego;

import configuracion.ConfiguracionInicial;

public class Prueba {

	public static void main(String[] args) {
		
		AdministradorJuego administradorJuego = new AdministradorJuego(new ConfiguracionInicial());
		administradorJuego.iniciarJuego();

		
	}

}
