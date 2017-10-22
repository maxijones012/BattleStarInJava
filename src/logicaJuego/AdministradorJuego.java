package logicaJuego;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

import configuracion.ConfiguracionInicial;
import grafica.vTableroJuego;
import interfaces.IAdministradorJuego;
import util.UAdministradorJuego;


/**
 * Clase administrador de juego, es la encargada de crear, controlar, y mostrar todo lo relacionado al 
 * 	juego
 * @author Maxi Jones
 *
 */
public class AdministradorJuego implements IAdministradorJuego{
	private Tamanio tamanio;
	ArrayList<Elemento> listaElemento = new ArrayList<>();
	private ConfiguracionInicial configuracionInicial;
	private int bonusContador = 0;
	private Boolean bonusAleatorio=true;
	private int ancho;
	private int alto;
	private boolean pausa=false;
	
	
	public AdministradorJuego(ConfiguracionInicial configuracionInicial) {
		this.configuracionInicial=configuracionInicial;
		this.tamanio= new Tamanio(ancho, alto);
		this.ancho=this.getConfiguracionInicial().getAnchoEscenario();
		this.alto=this.getConfiguracionInicial().getAltoEscenario();
	}
	
	@Override
	public void iniciarJuego() {
		crearElementos();
		
		vTableroJuego vista = new vTableroJuego(this);
		while (true){
//			crearBonus();
			
			turnos();
			
			vista.actualizar(this);
			
			verificarChoques();
			
			depurarElementos();
			
		 	espera(60);
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
		
	}


	public void espera(int c){
		if (c==0){ c=150;} //valor por defecto
	 	try {
			Thread.sleep(c); //aca va un 1000
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};

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
	}

	public boolean isPausa() {
		return pausa;
	}
	public void setPausa(boolean pausa) {
		this.pausa = pausa;
	}


	/**
	 * añade a una lista todos los elementos que puede visualizar un radar
	 * @param radar
	 * @return lista de elementos
	 */
	public ArrayList<Elemento> detectarElementos(Radar radar){
		ArrayList<Elemento> elementosVistos = new ArrayList<Elemento>();
		
		Polygon areaRadar = radar.getAreaCobertura();
		
		for(int i= 0; i< this.getListaElemento().size();i++){
			Elemento elemento = this.getListaElemento().get(i);
			
			Rectangle areaElemento = new Rectangle((int)elemento.getPosicion().getX(),
												   (int)elemento.getPosicion().getY(),
												    elemento.getTamanio().getAncho(),
												    elemento.getTamanio().getAlto()); 			
			
			if (areaRadar.intersects(areaElemento)){				
				elementosVistos.add(elemento);	
			}			
		}
		return elementosVistos;
	}
	
	/**
	 * Se encarga de monitorear los estados de vida de los elementos presentes en el juego
	 * en caso de que un elemento no este vivo es retirado del juego.
	 * 
	 */
	private void depurarElementos() {
		UAdministradorJuego.eliminarElementos(this);
	}
	
	
}
