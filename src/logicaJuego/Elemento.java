package logicaJuego;


import interfaces.IElemento;

public abstract class Elemento implements IElemento{
	private int nivelVida=this.getEscenario().getConfig().getNivelVida(); 
	private Posicion posicion;
	private Tamanio tamanio;
	private Escenario escenario;
	private Boolean estaVivo;
	
	
//	constructor
	public Elemento(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		this.posicion=posicion;
		this.tamanio=tamanio;
		this.escenario= escenario;
	}



	@Override
	public void jugar(){
		if (getNivelVida()>0){
			
		}else{ destruir(this);}
		
	};
		




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
	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public Boolean getEstaVivo() {
		return estaVivo;
	}

	public void setEstaVivo(Boolean estaVivo) {
		this.estaVivo = estaVivo;
	}

	public int getNivelVida() {
		return nivelVida;
	}
	public void setNivelVida(int nivelVida) {
		this.nivelVida = nivelVida;
	}

	
}
