package logicaJuego;

import java.util.ArrayList;
import java.util.Random;

import util.uEstrategia;
/**Clase Nave Ecuatorial
 *  Se mueve en forma horizontal, cuando llega al límite del escenario se desplaza en
forma vertical algunas posiciones y vuelve a retomar su rumbo horizontal contrario. Dispara
misiles cuando detecta una nave en el radar. Si por el contrario detecta a más de 3 naves,
dispara​ ​una​ ​bomba.
 * @author carlos
 *
 */
public class NaveEcuatorial extends Nave{
	private int cantidadAvanceVertical;
	private int turno=1;
	private boolean chocoPared=true;
	
	/**
	 * Constructor De Nave Ecuatorial 
	 * @param posicion
	 * @param tamanio
	 * @param escenario
	 */
	public NaveEcuatorial(Posicion posicion, Tamanio tamanio, AdministradorJuego escenario) {
		super(posicion, tamanio, escenario);
		this.cantidadAvanceVertical=this.getAministradorJuego().getConfiguracionInicial().getCantidadAvanceHaciaArriba();
		this.setDireccion(0);
	}
	
	@Override
	/**
	 * Nave Ecuatoria Redefine el metodo jugar de nave 
	 */
	public void jugar() {
		this.getRadar().escanear();
		this.avanzar();
		this.getRadar().girar(4);// corrige el angulo de radar 
	}




	@Override
	/**
	 * 
	 */
	public void chocarContraPared() {
		super.girar(180);
		chocoPared=true;	
		avanzarMuchasVeces(5);// para evitar que choque continuamente 
		calcularDesplazamiento();
		System.out.println("Nave choco contra pared");
	}

	
	/**
	 * genera una inteligencia para que aleatoriamente decida
	 *  si avanza hacia arriba o hacia abajo
	 */
	private void calcularDesplazamiento() {

		Random randx = new Random();
		boolean aleatorio = randx.nextBoolean();
		
		if (aleatorio==true){ //vaya ARRIBA
			girar(90);
		}else{
			girar(-90);
		}
		
	}

	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {
//		 Dispara misiles  cuando  detecta  una  nave  en  el  radar.  Si  por  el  contrario  
//		detecta  a  mÃ¡s  de  3  naves,  disparaâ€‹ â€‹unaâ€‹ â€‹bomba.
		
		if (this.getNivelCombustible()>0){
//			uEstrategia.inteligenciaEcuatorial(elementos, this);

		}else{
			uEstrategia.buscarCombustible(elementos, this);
			this.getRadar().girar(3);
		}
		

		
	}

	/**
	 * avanzar tantas veces como el parametro {@linkplain i} , lo indique
	 * @param i
	 */
	private void avanzarMuchasVeces(int i) {
		for (int j = 0; j < i; j++) {
			this.avanzar();
		}
		
	}
	



	@Override
	public String toString() {
		return ("ECUATORIAL");
	}


	
}
