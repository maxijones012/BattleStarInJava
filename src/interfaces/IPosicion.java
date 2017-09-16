package interfaces;

public interface IPosicion {

	
	/**
	 * Obtiene la posicion en X 
	 * @return X
	 */
	public int getPosicionX();
	
	
	/**
	 * Obtiene la posicion en Y
	 * @return
	 */
	public int getPosicionY();
	
	/**
	 * Setea la posicion con un valor X 
	 * @param posicionX
	 */
	public void setPosicionX(int posicionX);
	
	
	/**
	 * Setea la posicion con un valor Y
	 * @param posicionY
	 */
	public void setPosicionY(int posicionY);
}
