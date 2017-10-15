package logicaJuego;


import interfaces.IElemento;

public abstract class Elemento implements IElemento{
	private int nivelVida=this.getAdministradorJuego().getConfiguracionInicial().getNivelVida(); 
	private Posicion posicion;
	private Tamanio tamanio;
	private AdministradorJuego administradorJuego;
	private Boolean estaVivo;
	
	
//	constructor
	public Elemento(Posicion posicion, Tamanio tamanio, AdministradorJuego adminstradorJuego) {
		this.posicion=posicion;
		this.tamanio=tamanio;
		this.administradorJuego= adminstradorJuego;
		this.nivelVida=adminstradorJuego.getConfiguracionInicial().getNivelVida();
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
		this.getAministradorJuego().removeElemento(elemento);
		this.getAdministradorJuego().removeElemento(elemento);
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

	public AdministradorJuego getAministradorJuego() {
		return administradorJuego;
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



	public AdministradorJuego getAdministradorJuego() {
		return administradorJuego;
	}

	
}
