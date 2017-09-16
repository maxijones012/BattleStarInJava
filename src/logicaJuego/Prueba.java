package logicaJuego;

import configuracion.Config;

public class Prueba {

	public static void main(String[] args) {
		Config config = new Config();
		Escenario escenario = new Escenario(config);
		
		config.setEscenario(escenario);
		
		escenario.iniciarJuego();
		
		
		
	}

}
