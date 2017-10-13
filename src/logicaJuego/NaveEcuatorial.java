package logicaJuego;

import util.Movimiento;

public class NaveEcuatorial extends Nave{
	private boolean verticalArriba=true;
	private int contadorAvanceVertical=0;
	private int cantidadAvanceVertical=this.getAdministradorJuego().getConfig().getCantidadAvanceHaciaArriba();
	
	public NaveEcuatorial(Posicion posicion, Tamanio tamanio, AdministradorJuego escenario) {
		super(posicion, tamanio, escenario);
	}
	
	@Override
	public void avanzar() {
		avanzarEcuatorial();
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
		avanzarEcuatorial(); //este avanzar
		this.setDireccion(this.getDireccion()-90); //TODO verificar si la media vuelta es igual a -90 
		
		
	}

	/**
	 * controla el avance en vertical de la Nave 
	 */
	private void avanzarEcuatorial() {
		this.setDireccion(90);
	}

	
	
	public boolean isVerticalArriba() {
		return verticalArriba;
	}

	
	
	public void setVerticalArriba(boolean verticalArriba) {
		this.verticalArriba = verticalArriba;
	}

	public int getContadorAvanceVertical() {
		return contadorAvanceVertical;
	}

	public void setContadorAvanceVertical(int contadorAvanceVertical) {
		this.contadorAvanceVertical = contadorAvanceVertical;
	}

	public int getCantidadAvanceVertical() {
		return cantidadAvanceVertical;
	}


	
	
}
