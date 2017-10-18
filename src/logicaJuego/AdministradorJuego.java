package logicaJuego;

import java.util.ArrayList;

import configuracion.ConfiguracionInicial;
import interfaces.IAdministradorJuego;
import util.UAdministradorJuego;

public class AdministradorJuego implements IAdministradorJuego{
	private Tamanio tamanio;
	ArrayList<Elemento> listaElemento = new ArrayList<>();
	private ConfiguracionInicial configuracionInicial;
	private int bonusContador = 0;
	private Boolean bonusAleatorio=true;
	private int ancho;
	private int alto;
	
	
	public AdministradorJuego(ConfiguracionInicial configuracionInicial) {
		this.configuracionInicial=configuracionInicial;
		this.tamanio= new Tamanio(ancho, alto);
		this.ancho=this.getConfiguracionInicial().getAnchoEscenario();
		this.alto=this.getConfiguracionInicial().getAltoEscenario();
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

	/**
	 * TODO verificar si los poligonos de los elmentos que chocan estan superpuestos
	 */
	private void verificarChoques() {
		UAdministradorJuego.verficarChoques(this);
		
	}

	private void crearBonus() {
		UAdministradorJuego.crearBonus(this);
		
	}

	//TODO ARREGLAR TURNOS
	@Override
	public void turnos() {
		util.uLogica.darTurno(this);		
	}

	@Override
	public void crearElementos() {
		UAdministradorJuego.crearElementos(this);
		//TODO crear elementos
		
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
	}
	public ConfiguracionInicial getConfiguracionInicial() {
		return configuracionInicial;
	};
	
	
	
}
