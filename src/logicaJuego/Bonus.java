package logicaJuego;


public abstract class Bonus extends Estatico{
	private int tiempoVida;
	private Nave duenio;
//	constructor
	public Bonus(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego, Nave duenio) {
		super(posicion, tamanio, administradorJuego);
		this.duenio=duenio;
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

	public Nave getDuenio() {
		return duenio;
	}	
}
