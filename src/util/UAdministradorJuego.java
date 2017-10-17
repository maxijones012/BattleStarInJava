package util;


import java.awt.Rectangle;
import java.util.Random;

import logicaJuego.Bonus;
import logicaJuego.BonusInmunidad;
import logicaJuego.BonusMisil;
import logicaJuego.BonusReparacion;
import logicaJuego.Elemento;
import logicaJuego.AdministradorJuego;
import logicaJuego.NaveCrazy;
import logicaJuego.NaveEcuatorial;
import logicaJuego.Posicion;
import logicaJuego.Tamanio;

public abstract class UAdministradorJuego {
	/**
	 * da los turno a cada elemento del juego 
	 * @param escenario
	 */
	public static void darTurno(AdministradorJuego escenario){
		for(int i=0; i<escenario.getListaElemento().size(); i++){
			Elemento elemento = escenario.getListaElemento().get(i);			
			elemento.jugar();
		}
	}
	

	/**
	 * Elimina los elementos de la lista
	 * @param escenario
	 */
	public static void eliminarElementos(AdministradorJuego escenario){
		
		for(int i=0; i<escenario.getListaElemento().size();i++){
			if (!escenario.getListaElemento().get(i).getEstaVivo())
				escenario.getListaElemento().remove(i);
		}
		
		
	}


	//TODO HACER LOS CREAR ELEMENTOS
	public static void crearElementos(AdministradorJuego escenario) {
		NaveCrazy naveCrazy = new NaveCrazy(new Posicion(40, 40), new Tamanio(30, 30), escenario);
		escenario.getListaElemento().add(naveCrazy);
		
		NaveEcuatorial naveEcutaorial = new NaveEcuatorial(new Posicion(255, 255), new Tamanio(30, 30), escenario);
		escenario.getListaElemento().add(naveEcutaorial);
		
	}
	
	
	public static void crearBonus(AdministradorJuego escenario) {
		  Random timeRandom = new Random();
		  int tiempoRandom = (int)(timeRandom.nextDouble()*10);  //3000
		  escenario.setBonusContador(escenario.getBonusContador()+1);
		  if (escenario.getBonusContador()>=tiempoRandom){
			  escenario.setBonusAleatorio(true);
			  escenario.setBonusContador(0);
		  }
		  Bonus bonus= null;
		  Random tipoRandom = new Random();
		  int tipoBonus = (int)(tipoRandom.nextDouble()*2+1);
		  if(escenario.getBonusAleatorio()==true){				  
			  int x = (int) (uMovimiento.posicionAleatoriaX()*escenario.getConfiguracionInicial().getAnchoEscenario());
			  int y = (int) (uMovimiento.posicionAleatoriaY()*escenario.getConfiguracionInicial().getAltoEscenario());
			switch (tipoBonus) {
				case 1:	
						bonus = new BonusMisil(new Posicion(x,y),new Tamanio(escenario.getConfiguracionInicial().getAnchoBonus(), escenario.getConfiguracionInicial().getAltoBonus()),escenario, null); 
						break;
		
				case 2:	bonus = new BonusInmunidad(new Posicion(x,y),new Tamanio(escenario.getConfiguracionInicial().getAnchoBonus(), escenario.getConfiguracionInicial().getAltoBonus()),escenario,null);
						break;
				case 3: bonus = new BonusReparacion(new Posicion(x,y),new Tamanio(escenario.getConfiguracionInicial().getAnchoBonus(), escenario.getConfiguracionInicial().getAltoBonus()),escenario,null);
			}
			bonus.getTamanio().setAlto(escenario.getConfiguracionInicial().getAltoBonus());
			bonus.getTamanio().setAncho(escenario.getConfiguracionInicial().getAnchoBonus());
			
			bonus.setTiempoVida(99);

			
			escenario.getListaElemento().add(bonus);
			escenario.setBonusAleatorio(false);
		  }		

	}
	
	
	
	
	
	
	
	
	
	/**
	 * controla si un elemento se choco con otro elemento dentro del escenario
	 */
	public static void verficarChoques(AdministradorJuego escenario) {
		
		for(int i=0; i<escenario.getListaElemento().size();i++){
			
			Elemento e1 = escenario.getListaElemento().get(i);
			
			//guaramos las coordenadas para verificar si choco contra el tablero
			int coord1 = uMovimiento.obtenerPosicionX(e1);
			int coord2 = uMovimiento.obtenerPosicionY(e1);

			//Creamos el rectangulo
			Rectangle r1 = new Rectangle(e1.getPosicion().getX(),e1.getPosicion().getY(),
										e1.getTamanio().getAncho(),e1.getTamanio().getAlto());
			
			for(int j=i+1; j<escenario.getListaElemento().size(); j++){
				
				//Creamos el rectangulo
				Elemento e2 = escenario.getListaElemento().get(j);
				Rectangle r2 = new Rectangle(e2.getPosicion().getX(),
						e2.getPosicion().getY(),
						e2.getTamanio().getAncho(),
						e2.getTamanio().getAlto());												
				
				if(r1.intersects(r2)){
					e1.chocarContra(e2);
					uDebugConsola.posicion(e2); //TODO 
					e2.chocarContra(e1);
					uDebugConsola.posicion(e2);
				}
			}
			
			
			// estaContenidoDentro, hace referencia si no se paso del tope del tablero
			// esta contenidoposito, se fija si las posiciones son positivas 
			boolean estaContenidoDentro = ( (coord1 >= escenario.getConfiguracionInicial().getAnchoEscenario()) || (coord2 >= escenario.getConfiguracionInicial().getAltoEscenario()) ); 
			boolean estaContenidoPositivo= (coord1<= 0) || (coord2 <= 0 ); 
			if(estaContenidoPositivo || estaContenidoDentro){
				e1.chocarContraPared();
			}			
		}


	}

	
	
	
	
	
	
	
}



