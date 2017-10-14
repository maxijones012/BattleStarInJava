package logicaJuego;

public class Bomba extends Movible{
	private int velocidadInicial; 
	private int danioBomba; 
	private Nave duenio;
	private int tiempoDeExposicion=10; //TODO SACAR ESTO DE CONFIG
	private boolean estaExplotando=false;
	
	/**
	 * la bomba se crea con la posicion del duenio, donde 
	 * duenio es quien crea la bomba
	 * @param duenio
	 * @param posicion
	 * @param tamanio
	 */
	public Bomba(Nave duenio, Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
		this.duenio= duenio;
		this. velocidadInicial=this.getAministradorJuego().getConfig().getVelocidadInicialBomba();
		this.danioBomba=this.getAministradorJuego().getConfig().getNivelDanioBomba();
		

	}

	@Override
	/**
	 * Clase bomba, mientras tenga un alcance, se seguira movimendo
	 * cuando su alcance sea 0, debe explotar CON UN RADIO DE EXPANSION
	 * @param alcance
	 */
	public void jugar() {
		if (getVelocidadInicial()>0){
			super.avanzar();
			verificarExplosion();
			this.setVelocidadInicial(velocidadInicial-1); //TODO verificar que anda
		}
		else{
			super.destruir(this);
		}
		
	}

	
	/**
	 * Verifica si la bomba esta explotando
	 */
	private void verificarExplosion() {
		if (isEstaExplotando()){
			this.setTiempoDeExposicion(this.getTiempoDeExposicion()-1);
			if (this.getTiempoDeExposicion()==0){
				this.setEstaExplotando(false);
			}
		}
		
	}

	/**
	 * metodo que sirve para obtener el alcance de la bomba
	 * @return
	 */
	public int getVelocidadInicial() {
		return velocidadInicial;
	}

	public void setVelocidadInicial(int alcance) {
		this.velocidadInicial = alcance;
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
		this.destruir(this);
		
	}

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		this.destruir(this);
	}

	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		this.destruir(this);
		
	}

	public int getDanioBomba() {
		return danioBomba;
	}

	public void setDanioBomba(int danioBomba) {
		this.danioBomba = danioBomba;
	}


	@Override
	public void chocarContraPared() {
		this.destruir(this);
	}

	@Override
	public void chocarContraBomba(Bomba bomba) {this.destruir(this);}

	@Override
	public void chocarContraNave(Nave nave) {
		this.destruir(this);
	}
	
	
	public void explotar(){
		util.Armamento.explotar(this);
	}

	public int getTiempoDeExposicion() {
		return tiempoDeExposicion;
	}

	public void setTiempoDeExposicion(int tiempoDeExposicion) {
		this.tiempoDeExposicion = tiempoDeExposicion;
	}

	public boolean isEstaExplotando() {
		return estaExplotando;
	}

	public void setEstaExplotando(boolean estaExplotando) {
		this.estaExplotando = estaExplotando;
	}



}
