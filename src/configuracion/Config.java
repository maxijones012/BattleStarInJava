package configuracion;

import logicaJuego.Escenario;

/**
 * Contiene todos los datos del juego
 * @author Maxi Jones
 *
 */
public class Config {
	private NaveConfig naveConfig;
	private BombaConfig bombaConfig;
	private ObstaculoExplosivoConfig obstaculoExplosivoConfig;
	private BonusConfig bonusConfig;
	
	
	private Escenario escenario;
	private ConfigEscenario configEscenario;
	
	
//	Getters Setters
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

	public BombaConfig getBombaConfig() {
		return bombaConfig;
	}

	public ObstaculoExplosivoConfig getObstaculoExplosivoConfig() {
		return obstaculoExplosivoConfig;
	}

	public BonusConfig getBonusConfig() {
		return bonusConfig;
	}

	public void setBonusConfig(BonusConfig bonusConfig) {
		this.bonusConfig = bonusConfig;
	}

	
	
	
	
}
