package logicaJuego;

import util.Movimiento;

public class NaveEcuatorial extends Nave{
	private boolean verticalArriba=true;
	private int contadorAvanceVertical=0;
	private int cantidadAvanceVertical=this.getEscenario().getConfig().getCantidadAvanceHaciaArriba();
	
	public NaveEcuatorial(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
	}
	
	@Override
	public void avanzar() {
		super.avanzar(); //TODO CONTROLAR EL AVANCE HACIA ARRIBA, REHACER
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
		avanzarEnVertical(); //este avanzar
		this.setDireccion(this.getDireccion()-90); //TODO verificar si la media vuelta es igual a -90 
		
		
	}

	/**
	 * controla el avance en vertical de la Nave 
	 */
	private void avanzarEnVertical() {
		if (this.isVerticalArriba()){ //pensar bien
			Movimiento.avanzarY(this);		
			
		}
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
