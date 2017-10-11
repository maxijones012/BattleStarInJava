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
	 * @param escenario
	 */
	public Estatico(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
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
