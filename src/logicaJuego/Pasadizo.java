
package logicaJuego;

/**
 * Clase Pasadizo del juego
 * @author Maxi Jones
 *
 */
public class Pasadizo extends Estatico{
	private Posicion pasadizoSalida;
	private int quitarNivelCombustible;
		
	
	/**
	 * Constructor de la clase Pasadizo
	 * @param posicion
	 * @param tamanio
	 * @param escenario
	 * @param pasadizoSalida
	 */
	public Pasadizo(Posicion posicion, Tamanio tamanio, AdministradorJuego escenario, Posicion pasadizoSalida) {
		super(posicion, tamanio, escenario);
		this.pasadizoSalida=pasadizoSalida;
		this.quitarNivelCombustible=this.getAdministradorJuego().getConfiguracionInicial().getQuitarNivelCombustible();
	}

	@Override
	public void jugar() {
		
	}

	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
		
	}


	@Override
	public void chocarContraBomba(Bomba bomba) {
		this.setNivelVida(getNivelVida()-bomba.getDanioBomba());
	}

	
	@Override
	public void chocarContraNave(Nave nave) {
		diminuirNivelCombustible(nave);
		this.setPosicion(getPasadizoSalida());
	}

	/**
	 * disminuye en nivel de combustible de una nave
	 * @param nave
	 */
	public void diminuirNivelCombustible(Nave nave){
		nave.setNivelCombustible(nave.getNivelCombustible()-getQuitarNivelCombustible());
	};

	
	public Posicion getPasadizoSalida() {
		return pasadizoSalida;
	}
	
	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {}
	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {}
	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {}
	@Override
	public void chocarContraPared() {}

	public int getQuitarNivelCombustible() {
		return quitarNivelCombustible;
	}
	
	
}

