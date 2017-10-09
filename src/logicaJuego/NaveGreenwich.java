package logicaJuego;

import java.util.Random;

import util.Movimiento;

public class NaveGreenwich extends Nave{
	private static boolean arriba=true;
	private boolean bool=true;

	public NaveGreenwich(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
	}

	
	@Override
	public void jugar() {
		super.jugar();
		
	}
	
	
	@Override
	public void avanzar() {
	}


	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
	}


	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void chocarContraPared() {
		this.setDireccion(this.getDireccion()-90);
	}
	
	
	
	
}
