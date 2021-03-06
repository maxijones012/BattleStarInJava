package logicaJuego;

import configuracion.ConfiguracionInicial;
import util.uArmamento;
public class Bomba extends Movible{
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
		this.setVelocidadAvance(ConfiguracionInicial.VELOCIDAD_BOMBA);
		this.danioBomba=ConfiguracionInicial.NIVEL_DANIO_BOMBA;
		this.tiempoDeExposicion=this.getAdministradorJuego().getConfiguracionInicial().getTiempoExposicion();

		

	}

	@Override
	/**
	 * Clase bomba, mientras tenga un alcance, se seguira movimendo
	 * cuando su alcance sea 0, debe explotar CON UN RADIO DE EXPANSION
	 * @param alcance
	 */
	public void jugar() {
		if (getVelocidadAvance()>0){
			super.avanzar();
			verificarExplosion();
			this.setVelocidadAvance(this.getVelocidadAvance()-1); //TODO verificar que anda
			if (this.getVelocidadAvance()<8){ //la nave esta explotando	
				this.setEstaExplotando(true);
			}
		}
		else{
			
			super.destruir(this); // ya exploto por lo tanto debo de destruir la nave 
		}
		
	}

	
	/**
		Verifica si la bomba esta explotando
	 */
	private void verificarExplosion() {
		if (isEstaExplotando()){
			this.setTiempoDeExposicion(this.getTiempoDeExposicion()-1);
			if (this.getTiempoDeExposicion()==0){
				this.setEstaExplotando(false);
			}
		}
		
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
	 *  CUANDO SE SUPERPONE UN MOVIBLE CON EL BONUS ESTE SE DESTRUYE
	 */
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		this.destruir(this);
		
	}

	@Override
	/**
	 * CUANDO SE SUPERPONE UNA BOMBA CON EL BONUS ESTE SE DESTRUYE
	 */
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		this.destruir(this);
	}

	@Override
	/**
	 *  CUANDO SE SUPERPONE UNA BOMBA CON EL BONUS ESTE SE DESTRUYE
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
	/**
	 * Se destruye la bomba 
	 */
	public void chocarContraPared() {
		this.destruir(this);
		System.out.println("BOMBA CHOCO CONTRA PARED Y MURIO");
	}

	@Override
	/**
	 * DESTRUIR LAS BOMBAS
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
	 *	Genera un radio de explosion
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
/**
 * Cuando la bomba cohoca con alguno de los elmentos  pasados por parametro en los metodos de abajo la bomba
 * tiene que ejecutar su metodo destruir 
 */
	@Override
	public void chocarContraPazadizo(Pasadizo pasadizo) {
		this.destruir(this);
	}

	@Override
	public void chocarContraMisil(Misil misil) {
		this.destruir(this);
	}

	@Override
	public void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculoExplosivo) {
		this.destruir(this);
	}




}
