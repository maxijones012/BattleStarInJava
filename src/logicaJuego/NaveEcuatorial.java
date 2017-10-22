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
		
	}
	
	@Override
	public void jugar() {
		super.jugar();
		if (chocoPared==true){			
			avanzar();
			this.turno--;
			if (turno == 0){
				chocoPared=false;
			}
		}
		this.avanzar();
	}
	
	@Override
	public void avanzar() {
		super.avanzar();
	}



	@Override
	public void chocarContraPared() {
		this.girar(90);
		this.avanzar();
		chocoPared=true;		
		calcularDesplazamiento();
	}

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
