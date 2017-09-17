package logicaJuego;

import java.util.ArrayList;

import configuracion.Config;
import interfaces.IEscenario;

public class Escenario implements IEscenario{
	private Tamanio tamanio;
	ArrayList<Elemento> listaElemento = new ArrayList<>();
	private Config config;
	
	public Escenario(Config config) {
		this.config=config;
		this.tamanio= new Tamanio(config.getConfigEscenario().getAnchoEscenario(), config.getConfigEscenario().getAltoEscenario());
	}

	//TODO arreglar el iniciar juego
	@Override
	public void iniciarJuego() {
		
	}

	
	//TODO ARREGLAR TURNOS
	@Override
	public void turnos() {
		util.Logica.darTurno(this);		
	}

	@Override
	public void crearElementos() {
		
		//TODO crear elementos
		
	}

	public Config getConfig() {
		return config;
	}


	public Tamanio getTamanio() {
		return tamanio;
	}


	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	
	public void addElemento(Elemento elemento){
		this.listaElemento.add(elemento);
	}

	public void removeElemento(Elemento elemento) {
		this.listaElemento.remove(elemento);
	}

	public ArrayList<Elemento> getListaElemento() {
		return listaElemento;
	};
	
	
	
}
