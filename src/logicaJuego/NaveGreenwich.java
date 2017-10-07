package logicaJuego;

import util.Movimiento;

public class NaveGreenwich extends Nave{

	public NaveGreenwich(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
	}

	
	@Override
	public void jugar() {
		super.jugar();
		this.avanzar();
	}
	
	
	@Override
	public void avanzar() {
		Movimiento.avanzarY(this);		
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
	
	
	
	
}
