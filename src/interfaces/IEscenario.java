package interfaces;

import configuracion.Config;

/**
 * 
 * 
 * @author Maxi Jones
 *
 */

public interface IEscenario {

	/**
	 * 
	 */
	public void iniciarJuego();

	/**
	 * Genera turnos por cada lapso de tiempo
	 */
	public void turnos();
	
	
	
	public void crearElementos();
	
	
	
}
