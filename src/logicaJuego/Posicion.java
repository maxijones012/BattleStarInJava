package logicaJuego;


public class Posicion{
	private int X;
	private int Y;
	
//	constructor
	public Posicion(int X, int Y) {
		this.X=X;
		this.Y=Y;
	}
	/**
	 * Obtiene la posicion en X 
	 * @return X
	 */
	public int getX() {
		return X;
	}
	/**
	 * Setea la posicion con un valor X 
	 * @param posicionX
	 */
	public void setX(int x) {
		X = x;
	}

	
	/**
	 * Obtiene la posicion en Y
	 * @return
	 */
	public int getY() {
		return Y;
	}
	/**
	 * Setea la posicion con un valor Y
	 * @param posicionY
	 */
	public void setY(int y) {
		Y = y;
	}
	
	
	
	
	
	
	
	
	
}
