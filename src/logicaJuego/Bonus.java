package logicaJuego;

import java.awt.Robot;

public abstract class Bonus extends Estatico{
	private int tiempoVida;
	
//	constructor
	public Bonus(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
	}

	@Override
	public void jugar(){
		if (this.getTiempoVida()>0){
			
		}
		else{
			super.destruir(this);
		}
	};

	public int getTiempoVida() {
		return tiempoVida;
	}

	public void setTiempoVida(int tiempoVida) {
		this.tiempoVida = tiempoVida;
	}


	public abstract  void darBeneficio(Nave nave);	
}
