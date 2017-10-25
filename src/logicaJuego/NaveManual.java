package logicaJuego;


import java.util.ArrayList;
import sonido.uSonido;

/**
 * Clase de la Nave Manua, controlado por Teclado
 * @author Maxi Jones
 *
 */
public class NaveManual extends Nave{

	public NaveManual(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
	}

	
	
	@Override
	public void jugar() {
		this.getRadar().escanear();
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
			this.avanzar();
		}
		else{
			if (this.getAdministradorJuego().getConfiguracionInicial().isIzquierda()){
				this.setDireccion(180);
				this.avanzar();
			}
			else{
				if (this.getAdministradorJuego().getConfiguracionInicial().isArriba()){
					this.setDireccion(270);
					this.avanzar();
				}
				else{
					this.setDireccion(90); 
					this.avanzar();
				}
			}
		}				
	}
	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {
//		uEstrategia.inteligenciaDisparar(elementos, this);
	}

	@Override
	public void chocarContraPared() {
		cambiarDireccion(-180);
		super.avanzar();

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
