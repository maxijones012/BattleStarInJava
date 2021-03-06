package logicaJuego;

import java.awt.Polygon;
import java.util.ArrayList;

import interfaces.IRadar;
import interfaces.IRadarListener;
import util.uMovimiento;
import util.uRadar;
	
public class Radar extends Movible implements IRadar{
	private Nave duenio;
	private int direccion;
	private int alcanceMaximo=25;
	private int anguloAperturaRadar; 
	private int alcanceRadar; 
	private ArrayList<IRadarListener> radarListener ;
	private ArrayList<Elemento> elementosVistos;
	
	
	public Radar(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego, Nave nave) {
		super(posicion, tamanio, administradorJuego);
		this.duenio=nave;
		this.alcanceRadar=this.getAdministradorJuego().getConfiguracionInicial().getAlcanceRadar();
		this.anguloAperturaRadar=this.getAdministradorJuego().getConfiguracionInicial().getAnguloAperturaRadar();
		this.elementosVistos= new ArrayList<Elemento>();
		this.radarListener= new ArrayList<IRadarListener>();
	}
	
	/***
	 * agrega un elemento a su lista de escuchadores
	 * @param listener
	 */
	public void addRadarListener(IRadarListener listener) {
		this.radarListener.add(listener);
	}

	
	/***
	 * elimina un elemento de su lista de escuchadores
	 * @param listener
	 */
	public void removeRadarListener(IRadarListener listener) {
		this.radarListener.remove(listener);
	}
	
	
	
	
	//TODO HACER EL ESCANEAR
	public void escanear(){ //TODO anda mejorar y hacer
		this.elementosVistos = this.getAdministradorJuego().detectarElementos(this);
		   for (IRadarListener escuchadores: this.radarListener){		   		 		   
			   escuchadores.elementosVistos(this.elementosVistos);
		   }	
	};
	

	
	/**
	 * devuelve el un polygono
	 * @return
	 */
	public Polygon getAreaCobertura(){
		return (uRadar.getAreaCobertura(this));
	}
	
	/**
	 * gira con respecto a un  angula dado
	 * @param angulo
	 */
	public void girar (int angulo){
		uMovimiento.girar(this, angulo);
	}


	@Override
	public void avanzar() {
		uMovimiento.avanzarX(duenio);
		uMovimiento.avanzarY(duenio);
//		super.avanzar();
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



	@Override
	public void chocarContraPared() {
	}



	public int getAnguloApertura() {
		return anguloAperturaRadar;
	}



	public int getAlcance() {
		return alcanceRadar;
	}



	public void setAnguloApertura(int anguloApertura) {
		this.anguloAperturaRadar = anguloApertura;
		double angulo=(double)(anguloApertura);
		this.alcanceRadar=(int)(this.alcanceRadar - (this.alcanceMaximo*(angulo/360)));
	
	}

	public int getAnguloAperturaRadar() {
		return anguloAperturaRadar;
	}



	public int getAlcanceRadar() {
		return alcanceRadar;
	}



	@Override
	public void chocarContraBomba(Bomba bomba) {}



	@Override
	public void chocarContraNave(Nave nave) {
		// TODO verificar que tiene que hacer
		
	}



	public int getDireccion() {
		return direccion;
	}



	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	@Override
	public void chocarContraPazadizo(Pasadizo pasadizo) {
		
	}

	@Override
	public void chocarContraMisil(Misil misil) {}

	@Override
	public void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculoExplosivo) {
		
	}
	
	
	
}
