package logicaJuego;

public class Bomba extends Movible{
	private Movible duenio;
	private int danio; //TODO AGREGAR A CONFIG
	private int velocidadInicial; //TODO AGREGAR A CONFIG
	
	/**
	 * la bomba se crea con la posicion del duenio, donde 
	 * duenio es quien crea la bomba
	 * @param duenio
	 * @param posicion
	 * @param tamanio
	 */
	public Bomba(Movible duenio, Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
		this.duenio= duenio;
		this.danio=this.getEscenario().getConfig().getBombaConfig().getNivelDanio();

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
			this.setVelocidadInicial(velocidadInicial-1); //TODO verificar que anda
		}
		else{
			//TODO HACER EXPLOTAR
			super.destruir(this);
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

	public Movible getDuenio() {
		return duenio;
	}

	public void setDuenio(Movible duenio) {
		this.duenio = duenio;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
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
	
	
	
	

}
