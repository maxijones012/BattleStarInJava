package configuracion;

import logicaJuego.Escenario;

/**
 * Contiene todos los datos del juego
 * @author Maxi Jones
 *
 */
public class Config {
	private Escenario escenario;
	
	private int anchoNave=20;
	private int altoNave=20;
	
	private int posicionXNave=20;
	private int posicionYNave=20;
	
	private int anchoEscenario=800;
	private int altoEscenario=600;
		
	private int nivelDanioBomba=50;
	private int danioMisil=20;
	
	private int cantidadAvanceHaciaArriba=5;
	
	private int anchoBonus=30;
	private int altoBonus=30;
	
	public int getAnchoNave() {
		return anchoNave;
	}
	public int getAltoNave() {
		return altoNave;
	}
	public int getPosicionXNave() {
		return posicionXNave;
	}
	public int getPosicionYNave() {
		return posicionYNave;
	}
	
	public int getNivelDanioBomba() {
		return nivelDanioBomba;
	}
	public int getDanioMisil() {
		return danioMisil;
	}

	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}
	public int getCantidadAvanceHaciaArriba() {
		return cantidadAvanceHaciaArriba;
	}
	public int getAnchoEscenario() {
		return anchoEscenario;
	}
	public int getAltoEscenario() {
		return altoEscenario;
	}
	public int getAnchoBonus() {
		return anchoBonus;
	}
	public int getAltoBonus() {
		return altoBonus;
	}
	public Escenario getEscenario() {
		return escenario;
	}
	
	
	
	
	
	
	
}
