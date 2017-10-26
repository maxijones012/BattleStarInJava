package logicaJuego;

import util.uDebugConsola;

public abstract class Bonus extends Estatico{
	private int tiempoVida;
	private Nave duenio;
//	constructor
	public Bonus(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego, Nave duenio) {
		super(posicion, tamanio, administradorJuego);
		this.duenio=duenio;
		this.tiempoVida=this.getAdministradorJuego().getConfiguracionInicial().getTiempoVidaBonus();
	}

	@Override
	public void jugar(){
		uDebugConsola.posicion(this);
		uDebugConsola.mostrarNombreElemento(this);
		if (this.getTiempoVida()>0){
			this.setTiempoVida(this.getTiempoVida()-1);
		}
		else{
			super.destruir(this);
		}
	};

	public abstract  void darBeneficio(Nave nave);
	
	
	
	public int getTiempoVida() {
		return tiempoVida;
	}

	public void setTiempoVida(int tiempoVida) {
		this.tiempoVida = tiempoVida;
	}



	public Nave getDuenio() {
		return duenio;
	}	
	
	@Override
	public void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculoExplosivo) {}
	
}
