package logicaJuego;

import java.awt.Polygon;
import java.util.ArrayList;

import interfaces.IRadarListener;
import util.Movimiento;
import util.uRadar;
	
public class Radar extends Movible{
	private Nave duenio;
	private int direccion;
	private int alcanceMaximo=25;
	private int anguloAperturaRadar=this.getAdministradorJuego().getConfiguracionInicial().getAnguloAperturaRadar(); 
	private int alcanceRadar=this.getAdministradorJuego().getConfiguracionInicial().getAlcanceRadar(); 
	private ArrayList<IRadarListener> listeners;
	
	public Radar(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego, Nave nave) {
		super(posicion, tamanio, administradorJuego);
		this.duenio=nave;
		this.listeners=  listeners; //TODO VERFICAR ESTO
	}
	
	public void addRadarListener(IRadarListener listeners) {
		this.listeners.add(listeners);
		
	}
	public void removeRadarListener(IRadarListener listeners) {
		
		this.listeners.remove(listeners);		
	}
	
	
	
	//TODO HACER EL ESCANEAR
	public void escanear(){ //TODO anda mejorar y hacer 
			for (IRadarListener listener : this.listeners)
				
			System.out.println("Escanenando..." );
	};
	
	@Override
	public void jugar() {
		this.escanear();
		
	}
	
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
		Movimiento.girar(this, angulo);
	}


	@Override
	public void avanzar() {
		Movimiento.avanzarX(duenio);
		Movimiento.avanzarY(duenio);
		super.avanzar();
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
	
	
	
}
