package logicaJuego;

import java.util.Random;

public class NaveGreenwich extends Nave{

	public NaveGreenwich(Posicion posicion, Tamanio tamanio, AdministradorJuego escenario) {
		super(posicion, tamanio, escenario);
	}

	
	@Override
	public void jugar() {
		super.jugar();
	}
	
	
	@Override
	public void avanzar() {
		avanzarGrenwich();
		System.out.println("Grenwich:"+"x: "+this.getPosicion().getX()+"y: "+this.getPosicion().getY());
	}


	private void avanzarGrenwich() {
		Random random = new Random();
		Boolean valorLogico=random.nextBoolean();
		
		this.setDireccion(180); //avanza hacia arriba
		
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
