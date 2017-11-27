package logicaJuego;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import configuracion.ConfiguracionInicial;
import grafica.BarraEstado;
import grafica.vTableroJuego;
import interfaces.IAdministradorJuego;
import util.uAdministradorJuego;


/**
 * Clase administrador de juego, es la encargada de crear, controlar, y mostrar todo lo relacionado al 
 * 	juego
 * @author carlos
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
	private int tiempo=0;
	private int duracionJuego=ConfiguracionInicial.DURACION_JUEGO;
	private static AdministradorJuego instancia = new AdministradorJuego();
	
	/**
	 * devuelve la instancia de AdministradorJuego
	 * @return
	 */
	public static AdministradorJuego getInstancia() {
		return instancia;
	}

	
	/**
	 * Constructor de la clase Administrador de juego
	 */
	private AdministradorJuego() {
		this.configuracionInicial= new ConfiguracionInicial();
		this.tamanio= new Tamanio(ancho, alto);
		this.ancho=ConfiguracionInicial.ANCHO_ESCENARIO;
		this.alto=ConfiguracionInicial.ALTO_ESCENARIO;
	}
	
	@Override
	/**
	 * Inicia el juego 
	 *Crea los bonus y da el turno a los elementos dentro del escenario 
	 */
	public void iniciarJuego() {
		crearElementos();
		vTableroJuego vista = new vTableroJuego(this);
		BarraEstado barraEstado = new BarraEstado();
		while (tiempo<duracionJuego){
			if (!isPausa()){
				crearBonus();
				
				turnos();
				
				vista.actualizar(this);
				
				verificarChoques();
				
				depurarElementos();
				
			 	espera(60);
			 	
			 	barraEstado.actualizar(this.getListaElemento());
			tiempo++;
			}else{
				espera(60); //le doy una pqueña espera para poder cambiar el boton
			}
		}
		verificarResultados();
	}

	
	/**
	 * Verifica los resultados de cada uno, muestra la nave ganadora
	 */
	private void verificarResultados() {
		int cant=uAdministradorJuego.buscarNaveVivos(this.getListaElemento());
		System.out.println("CANTIDAD VIVOS: "+cant);
		
		
	}

	/**
	 * TODO verificar si los poligonos de los elmentos que chocan estan superpuestos
	 */
	private void verificarChoques() {
		uAdministradorJuego.verficarChoques();
		
	}

	private void crearBonus() {
		Random rand = new Random();
		if (rand.nextBoolean()==true){
			//TODO[CORREGIR] Al implementar SIngleton, no se debe pasar el admin del juego como parametro
			uAdministradorJuego.crearBonus();
		}
		
	}

	//TODO ARREGLAR TURNOS
	@Override
	public void turnos() {
		util.uLogica.darTurno(this);		
	}

	@Override
	public void crearElementos() {
		uAdministradorJuego.crearElementos();
		
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
	 * @param radar que posee una {@link Nave nave}
	 * @return lista de elementos
	 */
	public ArrayList<Elemento> detectarElementos(Radar radar){
		ArrayList<Elemento> elementosVistos = new ArrayList<Elemento>();
		
		Polygon areaRadar = radar.getAreaCobertura();
		
		for(int i= 0; i< this.getListaElemento().size();i++){
			Elemento elemento = this.getListaElemento().get(i);
			
			Rectangle areaElemento = dibujarRectangulo(elemento); 			
			
			if (areaRadar.intersects(areaElemento)){				
				elementosVistos.add(elemento);	
			}			
		}
		return elementosVistos;
	}


	
	/**
	 * dibujamos el rectangulo del {@link Elemento elemento}
	 * @param elemento
	 * @return
	 */
	private Rectangle dibujarRectangulo(Elemento elemento) {
		Rectangle areaElemento = new Rectangle((int)elemento.getPosicion().getX(),
											   (int)elemento.getPosicion().getY(),
											    elemento.getTamanio().getAncho(),
											    elemento.getTamanio().getAlto());
		return areaElemento;
	}
	
	/**
	 * Se encarga de monitorear los estados de vida de los elementos presentes en el juego
	 * en caso de que un elemento no este vivo es retirado del juego.
	 * 
	 */
	//TODO[CORREGIR] quedan sin eliminar algunas naves con vida negativa 
	private void depurarElementos() {
		uAdministradorJuego.eliminarElementos();
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	
}
