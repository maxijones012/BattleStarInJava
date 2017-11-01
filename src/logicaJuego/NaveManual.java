package logicaJuego;


import java.util.ArrayList;

import configuracion.ConfiguracionInicial;
import sonido.uSonido;
import util.uControles;
import util.uEstrategia;

/**
 * Clase de la Nave Manua, controlado por Teclado
 * @author Maxi Jones
 *
 */
public class NaveManual extends Nave{

	
	/**
	 * Constructor de la clase nave Manual
	 * @param posicion
	 * @param tamanio
	 * @param administradorJuego
	 */
	public NaveManual(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
	}

	
	
	@Override
	public void jugar() {
		this.getRadar().escanear();
	
		controlarTeclaPulsada();

		this.avanzar();
	}
	
	
	
	
	
	
	/**
	 * Verifica la tecla que pulso el usuario (ARRIBA,ABAJO,DERECHA,IZQUIERDA,B,BARRA_ESPARCIADORA)
	 */
	private void controlarTeclaPulsada() {
		
//		String tecla = uControles.verficarTecla(this);
		
 		if(this.getAdministradorJuego().getConfiguracionInicial().isDisMunicion()){			
			this.dispararMisil(this);
			this.getAdministradorJuego().getConfiguracionInicial().setDisMunicion(false);
			uSonido.reproducir("/sonido/misil2.wav");
		}
		if(this.getAdministradorJuego().getConfiguracionInicial().isDisBomba()){
			this.dispararBomba(this);
			this.getAdministradorJuego().getConfiguracionInicial().setDisBomba(false);
			uSonido.reproducir("/sonido/laser2.wav");
		}
		if (this.getAdministradorJuego().getConfiguracionInicial().isDerecha()){
			this.setDireccion(0);		
		}
		else{
			if (this.getAdministradorJuego().getConfiguracionInicial().isIzquierda()){
				this.setDireccion(180);
			}
			else{
				if (this.getAdministradorJuego().getConfiguracionInicial().isArriba()){
					this.setDireccion(270);
				}
				else{
					this.setDireccion(90); 
				}
			}
		}
	}



	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {
		if (this.getNivelCombustible()>0){
			uEstrategia.inteligenciaDispararNave(elementos, this);
		}else{
			uEstrategia.buscarCombustible(elementos, this);
			this.getRadar().girar(3);
		}
	}

	@Override
	public void chocarContraPared() {
		cambiarDireccion(-180);
		super.avanzar();
		System.out.println("Nave choco contra pared");

	}

	@Override
	public void chocarContraNave(Nave nave) {
	}
	
	@Override
	public String toString() {
		return ("MANUAL");
	}
	
	
	public void cambiarDireccion(int i){
		this.setDireccion(this.getDireccion()-i);
		super.avanzar();

	};
	
	
	

	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		super.chocarContraBonusMisil(bonus);
		uSonido.reproducir("/sonido/bonus.wav");
	}


}
