package logicaJuego;

import util.uArmamento;
public class Bomba extends Movible{
	private int velocidadInicial=400; 
	private int danioBomba; 
	private Nave duenio;
	private int tiempoDeExposicion; 
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
		this.setVelocidadAvance(this.getAministradorJuego().getConfiguracionInicial().getVelocidadInicialBomba());
		this.danioBomba=this.getAministradorJuego().getConfiguracionInicial().getNivelDanioBomba();
		this.tiempoDeExposicion=this.getAdministradorJuego().getConfiguracionInicial().getTiempoExposicion();

		

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
			this.setVelocidadInicial(this.getVelocidadInicial()-1); //TODO verificar que anda
		}
		else{
			super.destruir(this);
		}
		
	}

	
	/**
		TODO Verifica si la bomba esta explotando
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
	 * @return velocidadInicial
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
	/**
	 * LLAMO AL ChocarContra de la instancia del elemento
	 * @param elemento
	 */
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBomba(this);
		
	}

	@Override
	/**
	 * TODO CUANDO SE SUPERPONE UN MOVIBLE CON EL BONUS ESTE SE DESTRUYE
	 */
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		this.destruir(this);
		
	}

	@Override
	/**
	 * TODO CUANDO SE SUPERPONE UNA BOMBA CON EL BONUS ESTE SE DESTRUYE
	 *
	 */
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		this.destruir(this);
	}

	@Override
	/**
	 * TODO CUANDO SE SUPERPONE UNA BOMBA CON EL BONUS ESTE SE DESTRUYE
	 
	 *
	 *
	 *
	 *
	 */
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
	//TODO 
	public void chocarContraPared() {
		this.destruir(this);
	}

	@Override
	/**
	 * TODO DESTRUIR LAS BOMBAS
	 */
	public void chocarContraBomba(Bomba bomba) {
		if (bomba.getDuenio()!= this.getDuenio()){
			this.destruir(this);
		}
	}

	@Override
	/**
	 * LLAMO AL DESTRUIR DE LA NAVE
	 */
	public void chocarContraNave(Nave nave) {
		if (nave != this.getDuenio()){
			this.destruir(this);			
		}
	}
	
	/**
	 * 
	 */
	/**
	 * TODO revisar esta parte 
	 */
	public void explotar(){
		uArmamento.explotar(this);
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

	@Override
	public void chocarContraPazadizo(Pasadizo pasadizo) {
		this.destruir(this);
	}


}
