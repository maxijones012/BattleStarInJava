package interfaces;

public interface IMovible {
	
	
	/**
	 * Todos los objetos que sean un Movible, avanzaran por el escenario
	 */
	public void avanzar();
	
	/**
	 * devuelve la direccion de un objeto
	 * @return
	 */
			
	public int getDireccion();

	
	/**
	 * setea la direccion de un objeto
	 * @param direccion
	 */
	public void setDireccion(int direccion) ;	
	
	
}
