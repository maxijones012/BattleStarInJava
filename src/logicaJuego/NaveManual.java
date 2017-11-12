package logicaJuego;


import java.util.ArrayList;

import configuracion.Constante;
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
//		uControles.apagarTeclas(this);
		this.getRadar().escanear();
	
		controlarTeclaPulsada();

		
	}
	
	
	
	/**
	 * Verifica la tecla que pulso el usuario (ARRIBA,ABAJO,DERECHA,IZQUIERDA,B,BARRA_ESPARCIADORA)
	 */
	private void controlarTeclaPulsada() {
		
		String tecla = uControles.verficarTecla(this);
		System.out.println(tecla);
		
		switch (tecla) {
		
		case Constante.TECLA_BARRA_ESPACIADORA:
			if (this.getCantidadMunicion()>0){
				this.dispararMisil(this);
				this.getAdministradorJuego().getConfiguracionInicial().setDisMunicion(false);
				uSonido.reproducir("/sonido/misil2.wav");
				this.avanzar();
				break;
			}else{ //bug encontrado
				this.avanzar();
				break;
			}
			
		case Constante.TECLA_B:
			if (this.getCantidadBomba()>0){
				this.dispararBomba(this);
				uSonido.reproducir("/sonido/laser2.wav");
				this.avanzar();
				break;
			}else{
				break;
			}
			
		case Constante.TECLA_DERECHA:
				this.setDireccion(0);	
				super.avanzar();
			break;
			
		case Constante.TECLA_IZQUIERDA:
			this.setDireccion(180);
			super.avanzar();
			break;
			
		case Constante.TECLA_ARRIBA:
			this.setDireccion(270);
			super.avanzar();
			break;

		case Constante.TECLA_ABAJO:
			this.setDireccion(90); 
			super.avanzar();
			break;
	
		default:
			break;
		}
		uControles.apagarTeclas(this);
	}



	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {
		if (this.getNivelCombustible()>0){
//			uEstrategia.inteligenciaDispararNave(elementos, this);
		}else{
			uEstrategia.buscarCombustible(elementos, this);
			this.getRadar().girar(3);
		}
	}

	@Override
	public void chocarContraPared() {
		cambiarDireccion(-180);
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
