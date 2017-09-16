package logicaJuego;


import interfaces.IElemento;

public abstract class Elemento implements IElemento{
	private Posicion posicion;
	private int Velocidad;
	private Tamanio tamanio;
	private Escenario escenario;
	
	
//	constructor
	public Elemento(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		this.posicion=posicion;
		this.tamanio=tamanio;
		this.escenario= escenario;
	}



	@Override
	public void jugar() {
		
	}
		



	@Override
	public void turnos() {
		
	}

	/**
	 * Destruye un elemento del campo de juego
	 * @param elemento
	 */
	public void destruir(Elemento elemento){
		this.getEscenario().removeElemento(elemento);
	};
	


	
	
	
//------------------------------------------------------------	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public int getVelocidad() {
		return Velocidad;
	}

	public void setVelocidad(int velocidad) {
		Velocidad = velocidad;
	}



	public Tamanio getTamanio() {
		return tamanio;
	}



	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}



	public Escenario getEscenario() {
		return escenario;
	}


}
