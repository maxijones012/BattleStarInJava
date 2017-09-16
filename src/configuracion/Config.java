package configuracion;

import logicaJuego.Escenario;

/**
 * Contiene todos los datos del juego
 * @author Maxi Jones
 *
 */
public class Config {
	public NaveConfig naveConfig;
	private Escenario escenario;
	private ConfigEscenario configEscenario;
	
	
	
	public NaveConfig getNaveConfig() {
		return naveConfig;
	}




	public ConfigEscenario getConfigEscenario() {
		return configEscenario;
	}




	public void setEscenario(Escenario escenario) {
		this.escenario=escenario;
	}

	public Escenario getEscenario() {
		return escenario;
	}

	
	
	
	
}
