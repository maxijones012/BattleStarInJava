package interfaces;


/**
 * 
 * 
 * @author Maxi Jones
 *
 */

public interface IAdministradorJuego {

	/**
	 * Es la que da inicio al juego
	 */
	public void iniciarJuego();


	/**
	 * Genera turnos por cada lapso de tiempo 
	 */
	public void turnos();
	
	
	/**
	 * Crea todos los elementos del juego
	 */
	public void crearElementos();
	
	
	
}
