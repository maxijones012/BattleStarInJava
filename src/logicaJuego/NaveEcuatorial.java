package logicaJuego;

import java.util.ArrayList;

import util.uArmamento;
import util.uEstrategia;

public class NaveEcuatorial extends Nave{
	private int cantidadAvanceVertical;
	
	
	public NaveEcuatorial(Posicion posicion, Tamanio tamanio, AdministradorJuego escenario) {
		super(posicion, tamanio, escenario);
		this.cantidadAvanceVertical=this.getAministradorJuego().getConfiguracionInicial().getCantidadAvanceHaciaArriba();
		
	}
	
	@Override
	public void jugar() {
		super.dispararBomba(this);
		super.jugar();
		avanzar();
	}
	
	@Override
	public void avanzar() {
		super.avanzar();
		avanzarEcuatorial();
	}



	@Override
	public void chocarContraPared() {
		avanzarEcuatorial(); //este avanzar
		this.girar(-90); //TODO verificar si la media vuelta es igual a -90 
		
		
	}

	/**
	 * controla el avance en vertical de la Nave 
	 */
	private void avanzarEcuatorial() {
		this.girar(90);
	}

	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {
//		 Dispara misiles  cuando  detecta  una  nave  en  el  radar.  Si  por  el  contrario  
//		detecta  a  más  de  3  naves,  dispara​ ​una​ ​bomba.
		int contadorInternoNave=0;
		for (int i = 0; i < elementos.size(); i++) {
			
			 Elemento e = elementos.get(i);
			 if (e instanceof Nave){
				 if (contadorInternoNave<=3) {
						this.dispararBomba(this);
					}
					this.dispararMunicion(this);
					contadorInternoNave++;
			 }
			 if ((e instanceof Misil) || (e instanceof Bomba)){
					uEstrategia.eludir(this);
					
				}
		}
		
	}

	
	

	
	@Override
	public String toString() {
		return ("ECUATORIAL");
	}

	
	
}
