package logicaJuego;

import java.util.ArrayList;
import java.util.Random;

import util.uArmamento;
import util.uEstrategia;

public class NaveGreenwich extends Nave{
/**
 * constructor de la clase  NaveGreenwich
 * @param posicion
 * @param tamanio
 * @param administradorJuego
 */
	public NaveGreenwich(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
	}
	
	@Override
	public void jugar() {
		super.jugar();
		avanzar();
	}
	
	
	@Override
	//TODO preguntar por el giro en un angulo x 
	public void avanzar() {
		avanzarGrenwich();
		System.out.println("Grenwich:"+"x: "+this.getPosicion().getX()+"y: "+this.getPosicion().getY());
	}


	private void avanzarGrenwich() {
		Random random = new Random();
		Boolean valorLogico=random.nextBoolean();
		
		girar(180); //avanza hacia arriba
		
	}


	@Override
	/**
	 * llamo al  metodo de chocarContra del elemento que choca con la nave
	 */
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
	}


	@Override
	/**
	 *TODO VER EL CHOCAR CONTRA  DE BonusReparacion 
	 */
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		// TODO Auto-generated method stub
		
	}


	@Override
	/**
	 * 
	 */
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		// TODO Auto-generated method stub
		
	}


	@Override
	/**
	 * 
	 */
	public void chocarContraBonusMisil(BonusMisil bonus) {
		// TODO Auto-generated method stub
		
	}


	@Override
	/**
	 * INVIERTO LA DIRECCION DE LA NAVE 
	 */
	public void chocarContraPared() {
		girar(this.getDireccion()-90);
	}

	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {
		//TODO VERIFICAR LA DISTANCIA OPTIMA
		
		/*TODO
		 * IF (LA DISTANCIA ES OPTIMA){
		 * }
		 * */
		
//		disparar(new Misil(this,null, null, this.getAdministradorJuego()));
		uEstrategia.inteligencia(elementos, this);
//		for (int i = 0; i < elementos.size(); i++) {
//			dispararMunicion(this);
//			Elemento e = elementos.get(i);
//			if ((e instanceof Misil) || (e instanceof Bomba)){
//				uEstrategia.eludir(this);
//			}
//			if (e instanceof Nave){
//				uEstrategia.eludir(this);
//			}
//		}
		
	}
	
	

	
	@Override
	public String toString() {
		return ("GREENWICH");
	}

}
