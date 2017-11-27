package logicaJuego;


import configuracion.ConfiguracionInicial;
/**
 * Clase abstracta Elemento las subclases que extienden de Elemento deben de redefinir sus metodos
 * e implementar IElemento
 */
import interfaces.IElemento;
import util.uMovimiento;

public abstract class Elemento implements IElemento{
	private int nivelVida; 
	private Posicion posicion;
	private Tamanio tamanio;
	private AdministradorJuego administradorJuego;
	private Boolean estaVivo=true;
	private boolean pausa=false;
	
	
/**
 * Constructor Clase Elemento 
 * @param posicion
 * @param tamanio
 * @param adminstradorJuego
 */
	
	public Elemento(Posicion posicion, Tamanio tamanio, AdministradorJuego adminstradorJuego) {
		this.posicion=posicion;
		posicion = uMovimiento.getCentro(tamanio, posicion);
		this.tamanio=tamanio;
		this.administradorJuego= adminstradorJuego;
		this.nivelVida=ConfiguracionInicial.NIVEL_VIDA;
		
	}


	@Override
	/**
	 * Metodo jugar generico de de los elementos 
	 */
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
		this.setEstaVivo(false);
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


	public boolean isPausa() {
		return pausa;
	}


	public void setPausa(boolean pausa) {
		this.pausa = pausa;
	}

	
}
