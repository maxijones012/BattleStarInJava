package configuracion;

import logicaJuego.AdministradorJuego;

/**
 * Contiene todos los datos del juego
 * configuracion inicial por defecto
 * @author Maxi Jones
 *
 */
public class ConfiguracionInicial {
	private AdministradorJuego administradorJuego;
	
	public static final int DURACION_JUEGO = 1000;
	private int nivelVida=10000;
	private int tiempoDeExplosion=150;
	private int nivelCombustible=100000000; //debe estar en 1000
	
	private int anchoNave=70;
	private int altoNave=70;
	
	
	
	private int posicionXNave=20;
	private int posicionYNave=20;
	
	public static final int POSICION_X_NAVE_MANUAL=250;
	public static final int POSICION_Y_NAVE_MANUAL=850;
	
	public static final int POSICION_X_PASADIZO_A=200;
	public static final int POSICION_Y_PASADIZO_A=200;

	public static final int POSICION_X_PASADIZO_B=730;
	public static final int POSICION_Y_PASADIZO_B=430;
	
	
	private int cantidadMunicionNave=20;
	
	private int anchoEscenario=900;
	private int altoEscenario=700;
	public static final int ALTO_PASADIZO=30;
	public static final int ANCHO_PASADIZO=30;
	
	public static final int ANCHO_NAVE=50;
	public static final int ALTO_NAVE=50;

	public static final int POSICION_X_OBSTACULO_EXPLOSIVO = 800;
	public static final int POSICION_Y_OBSTACULO_EXPLOSIVO = 200;
	
	public static final int ANCHO_OBSTACULO_EXPLOSIVO = 40;
	public static final int ALTO_OBSTACULO_EXPLOSIVO = 80;

	public static final int VELOCIDAD_MISIL = 35;
	public static final int VELOCIDAD_BOMBA = 30;

	public static final int CANTIDAD_MUNICION = 50;

	public static final int CANTIDAD_BOMBA = 50;

	public static final int ANCHO_MISIL = 50;
	public static final int ALTO_MISIL = 20;

	public static final int ANCHO_BOMBA = 40;
	public static final int ALTO_BOMBA = 40;

	public static final int DANIO_OBSTACULO_EXPLOSIVO = 80;

		
	private int nivelDanioBomba=50;
	private int danioMisil=20;
	
	private int cantidadAvanceHaciaArriba=380;
	
	private int anchoBonus=30;
	private int altoBonus=30;
	
	private int direccionMovible=10;

	
	private int nivelDanioMisil=30;
	private int valorReparacionBonus=40;
	
	private int velocidadAvanceMovible=5;
	
	private int tiempoInmunidad=25;
	private int alcanceRadar=250;
	private int anguloAperturaRadar=15;
	
	
	private int quitarNivelCombustible=50;
	private int tiempoExposicion=10;
	
	private int tiempoVidaBonus=50;
	
	
	private boolean arriba;
	private boolean abajo;
	private boolean izquierda;
	private boolean derecha;
	private boolean disMunicion;
	private boolean disBomba;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean isDisMunicion() {
		return disMunicion;
	}
	public void setDisMunicion(boolean disMunicion) {
		this.disMunicion = disMunicion;
	}
	public boolean isDisBomba() {
		return disBomba;
	}
	public void setDisBomba(boolean disBomba) {
		this.disBomba = disBomba;
	}
	public boolean isArriba() {
		return arriba;
	}
	public void setArriba(boolean arriba) {
		this.arriba = arriba;
	}
	public boolean isAbajo() {
		return abajo;
	}
	public void setAbajo(boolean abajo) {
		this.abajo = abajo;
	}
	public boolean isIzquierda() {
		return izquierda;
	}
	public void setIzquierda(boolean izquierda) {
		this.izquierda = izquierda;
	}
	public boolean isDerecha() {
		return derecha;
	}
	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}
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

	public int getNivelCombustible() {
		return nivelCombustible;
	}
	public int getTiempoDeExplosion() {
		return tiempoDeExplosion;
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
	public int getTiempoVidaBonus() {
		return tiempoVidaBonus;
	}
	
	
	
	
	
	
	
}
