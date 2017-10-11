package logicaJuego;

import java.util.ArrayList;

import configuracion.Config;
import interfaces.IEscenario;
import util.UEscenario;

public class Escenario implements IEscenario{
	private Tamanio tamanio;
	ArrayList<Elemento> listaElemento = new ArrayList<>();
	private Config config;
	private int bonusContador = 0;
	private Boolean bonusAleatorio=true;
	
	public Escenario(Config config) {
		this.config=config;
		this.tamanio= new Tamanio(800, 600);
	}

	//TODO arreglar el iniciar juego
	@Override
	public void iniciarJuego() {
		crearElementos();
		
		while (true){
			crearBonus();
			
			turnos();
			
			verificarChoques();
		}
	}

	
	private void verificarChoques() {
		UEscenario.verficarChoques(this);
		
	}

	private void crearBonus() {
		UEscenario.crearBonus(this);
		
	}

	//TODO ARREGLAR TURNOS
	@Override
	public void turnos() {
		util.Logica.darTurno(this);		
	}

	@Override
	public void crearElementos() {
		UEscenario.crearElementos(this);
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
	}

	public int getBonusContador() {
		return bonusContador;
	}

	public void setBonusContador(int bonusContador) {
		this.bonusContador = bonusContador;
	}

	public Boolean getBonusAleatorio() {
		return bonusAleatorio;
	}

	public void setBonusAleatorio(Boolean bonusAleatorio) {
		this.bonusAleatorio = bonusAleatorio;
	};
	
	
	
}
