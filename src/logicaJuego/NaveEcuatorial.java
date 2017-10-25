package logicaJuego;

import java.util.ArrayList;
import java.util.Random;

import util.uArmamento;
import util.uEstrategia;

public class NaveEcuatorial extends Nave{
	private int cantidadAvanceVertical;
	private int turno=10;
	private boolean chocoPared=true;
	
	
	public NaveEcuatorial(Posicion posicion, Tamanio tamanio, AdministradorJuego escenario) {
		super(posicion, tamanio, escenario);
		this.cantidadAvanceVertical=this.getAministradorJuego().getConfiguracionInicial().getCantidadAvanceHaciaArriba();
		this.setDireccion(90);
	}
	
	@Override
	public void jugar() {
		if (chocoPared==true){			
			avanzar();
			this.turno--;
			if (turno == 0){
				chocoPared=false;
			}
		}
		this.getRadar().escanear();
		this.avanzar();
		this.getRadar().girar(5);
//		super.jugar();
	}




	@Override
	public void chocarContraPared() {
		this.girar(90);
		this.avanzar();
		chocoPared=true;		
		calcularDesplazamiento();
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
//		detecta  a  más  de  3  naves,  dispara​ ​una​ ​bomba.
		int cant = buscarCantidadNave(elementos);
		for (int i = 0; i < elementos.size(); i++) {
			
			if (cant>0){
				if (cant==3){
					this.dispararBomba(this);
				}else
					this.dispararMisil(this);
			}
			 Elemento e = elementos.get(i);

			 if ((e instanceof Misil) || (e instanceof Bomba) || (e instanceof Nave)){
					uEstrategia.eludir(this);
				}
		}
		
	}

	
	

	/**
	 * busca la cantidad de Naves que se han detectado
	 * @param elementos
	 * @return
	 */
	private int buscarCantidadNave(ArrayList<Elemento> elementos) {
		int contador=0;
		
		for (int i = 0; i < elementos.size(); i++) {
			 Elemento e = elementos.get(i);

			if (e instanceof Nave){contador++;}
		}
		return (contador);
	}

	@Override
	public String toString() {
		return ("ECUATORIAL");
	}


	
}
