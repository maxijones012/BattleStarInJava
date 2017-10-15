package configuracion;

import logicaJuego.AdministradorJuego;

/**
 * Contiene todos los datos del juego
 * @author Maxi Jones
 *
 */
public class ConfiguracionInicial {
	private AdministradorJuego administradorJuego;
	
	private int nivelVida=100;
	
	private int anchoNave=20;
	private int altoNave=20;
	
	private int posicionXNave=20;
	private int posicionYNave=20;
	
	private int cantidadMunicionNave=20;
	
	private int anchoEscenario=800;
	private int altoEscenario=600;
		
	private int nivelDanioBomba=50;
	private int danioMisil=20;
	
	private int cantidadAvanceHaciaArriba=5;
	
	private int anchoBonus=30;
	private int altoBonus=30;
	
	private int direccionMovible=10;

	private int velocidadInicialBomba=60;
	private int nivelDanioMisil=30;
	private int valorReparacionBonus=40;
	
	private int velocidadAvanceMovible=20;
	
	private int tiempoInmunidad=25;
	private int alcanceRadar=25;
	private int anguloAperturaRadar=13;
	
	
	private int quitarNivelCombustible=20;
	private int tiempoExposicion=10;
	
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

	public void setEscenario(AdministradorJuego escenario) {
		this.administradorJuego = escenario;
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
	public AdministradorJuego getEscenario() {
		return administradorJuego;
	}
	public int getVelocidadInicialBomba() {
		return velocidadInicialBomba;
	}
	public int getNivelVida() {
		return nivelVida;
	}
	public int getNivelDanioMisil() {
		return nivelDanioMisil;
	}
	public int getCantidadMunicionNave() {
		return cantidadMunicionNave;
	}
	public int getTiempoInmunidad() {
		return tiempoInmunidad;
	}
	public int getAlcanceRadar() {
		return alcanceRadar;
	}
	public int getAnguloAperturaRadar() {
		return anguloAperturaRadar;
	}
	public int getValorReparacionBonus() {
		return valorReparacionBonus;
	}
	public int getVelocidadAvanceMovible() {
		return velocidadAvanceMovible;
	}
	public int getDireccionMovible() {
		return direccionMovible;
	}
	public int getQuitarNivelCombustible() {
		return quitarNivelCombustible;
	}
	public AdministradorJuego getAdministradorJuego() {
		return administradorJuego;
	}
	public void setAdministradorJuego(AdministradorJuego administradorJuego) {
		this.administradorJuego = administradorJuego;
	}
	public int getTiempoExposicion() {
		return tiempoExposicion;
	}
	
	
	
	
	
	
	
}
