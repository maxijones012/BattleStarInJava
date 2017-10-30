package logicaJuego;

/**
 * los elementos de esta clase tienen una POSICION FIJA!
 * @author Maxi Jones
 *
 */
public abstract class Estatico extends Elemento{

	
	/**
	 * constructor de la clase estatico
	 * @param posicion
	 * @param tamanio
	 * @param AdministradorJuego
	 */
	public Estatico(Posicion posicion, Tamanio tamanio, AdministradorJuego AdministradorJuego) {
		super(posicion, tamanio, AdministradorJuego);
	}



	public abstract void chocarContraNave(Nave nave);
	

}
