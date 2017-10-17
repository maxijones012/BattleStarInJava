package logicaJuego;

import configuracion.ConfiguracionInicial;

public class Prueba {

	public static void main(String[] args) {
		
		ConfiguracionInicial configuracionInicial = new ConfiguracionInicial();
		AdministradorJuego administradorJuego = new AdministradorJuego(configuracionInicial);
		
		configuracionInicial.setAdministradorJuego(administradorJuego);
		configuracionInicial.setEscenario(administradorJuego);
		
		administradorJuego.iniciarJuego();

		
	}

}
