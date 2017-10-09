package logicaJuego;

import util.Movimiento;

public class Radar extends Movible{
	private Nave duenio;
	
	
	
	public Radar(Posicion posicion, Tamanio tamanio, Escenario escenario, Nave nave) {
		super(posicion, tamanio, escenario);
		this.duenio=nave;
	}
	
	
	
	//TODO HACER EL ESCANEAR
	public void escanear(){ //TODO anda mejorar y hacer 
		
			System.out.println("Escanenando..." );
	};
	
	@Override
	public void jugar() {
		this.escanear();
		
	}
	
	
	
	/**
	 * gira con respecto a un  angula dado
	 * @param angulo
	 */
	public void girar (int angulo){
		Movimiento.girar(this, angulo);
	}


	@Override
	public void avanzar() {
		Movimiento.avanzarX(duenio);
		Movimiento.avanzarY(duenio);
		super.avanzar();
	}



	public Nave getDuenio() {
		return duenio;
	}



	public void setDuenio(Nave duenio) {
		this.duenio = duenio;
	}



	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
	}

	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
	}

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
	}

	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {	}
	
	
	
	
}
