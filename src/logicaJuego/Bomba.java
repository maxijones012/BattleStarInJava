package logicaJuego;

public class Bomba extends Movible{
	private Nave duenio;
	private int danioBomba=this.getEscenario().getConfig().getNivelDanioBomba(); 
	private int velocidadInicial; //TODO AGREGAR A CONFIG
	
	/**
	 * la bomba se crea con la posicion del duenio, donde 
	 * duenio es quien crea la bomba
	 * @param duenio
	 * @param posicion
	 * @param tamanio
	 */
	public Bomba(Nave duenio, Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
		this.duenio= duenio;
		

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
	public void chocarContraBomba(Bomba bomba) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
