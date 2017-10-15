package logicaJuego;


public class NaveEcuatorial extends Nave{
	private int cantidadAvanceVertical=this.getAministradorJuego().getConfiguracionInicial().getCantidadAvanceHaciaArriba();
	
	
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
		this.girar(-90); //TODO verificar si la media vuelta es igual a -90 
		
		
	}

	/**
	 * controla el avance en vertical de la Nave 
	 */
	private void avanzarEcuatorial() {
		this.girar(90);
	}

	
	


	
	
}
