package logicaJuego;

public class Bomba extends Movible{
	private Movible duenio;
	private int nivelDanio; //TODO AGREGAR A CONFIG
	private int alcance; //TODO AGREGAR A CONFIG
	
//	constructor
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

	}

	@Override
	public void jugar() {
		if (getAlcance()>0){
			super.avanzar();
			this.setAlcance(alcance-1); //TODO verificar que anda
		}
		else{
			super.destruir(this);
		}
		
	}

	
	
	/**
	 * metodo que sirve para obtener el alcance de la bomba
	 * @return
	 */
	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}
	
	
	
	

}
