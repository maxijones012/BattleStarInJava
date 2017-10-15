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
	 * @param administradorJuego
	 */
	public Estatico(Posicion posicion, Tamanio tamanio, AdministradorJuego AdministradorJuego) {
		super(posicion, tamanio, AdministradorJuego);
		this.setPosicion(getPosicionAleatoria());
	}

	
	
	/**
	 * Devuelve una posicion aleatoria con X>=,Y>0 
	 * @return Posicion(X,Y)
	 */
	private Posicion getPosicionAleatoria(){
		return (new Posicion( util.Movimiento.posicionAleatoriaX(), util.Movimiento.posicionAleatoriaY() ) );
	}



	public abstract void chocarContraNave(Nave nave);
	

}
