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
import logicaJuego.Posicion;
import logicaJuego.Tamanio;

public abstract class UAdministradorJuego {
	/**
	 * da los turno a cada elemento del juego 
	 * @param administradorJuego
	 */
	public static void darTurno(AdministradorJuego administradorJuego){
		for(int i=0; i<administradorJuego.getListaElemento().size(); i++){
			Elemento elemento = administradorJuego.getListaElemento().get(i);			
			elemento.jugar();
		}
	}
	

	/**
	 * Elimina los elementos de la lista
	 * @param administradorJuego
	 */
	public static void eliminarElementos(AdministradorJuego administradorJuego){
		
		for(int i=0; i<administradorJuego.getListaElemento().size();i++){
			if (!administradorJuego.getListaElemento().get(i).getEstaVivo())
				administradorJuego.getListaElemento().remove(i);
		}
		
		
	}


	//TODO HACER LOS CREAR ELEMENTOS
	public static void crearElementos(AdministradorJuego administradorJuego) {
		NaveCrazy naveCrazy = new NaveCrazy(new Posicion(40, 40), new Tamanio(30, 30), administradorJuego);
		administradorJuego.getListaElemento().add(naveCrazy);
		
		
	}
	
	
	public static void crearBonus(AdministradorJuego administradorJuego) {
		  Random timeRandom = new Random();
		  int tiempoRandom = (int)(timeRandom.nextDouble()*10);  //3000
		  administradorJuego.setBonusContador(administradorJuego.getBonusContador()+1);
		  if (administradorJuego.getBonusContador()>=tiempoRandom){
			  administradorJuego.setBonusAleatorio(true);
			  administradorJuego.setBonusContador(0);
		  }
		  Bonus bonus= null;
		  Random tipoRandom = new Random();
		  int tipoBonus = (int)(tipoRandom.nextDouble()*2+1);
		  if(administradorJuego.getBonusAleatorio()==true){				  
			  int x = (int) (Movimiento.posicionAleatoriaX()*administradorJuego.getConfig().getAnchoEscenario());
			  int y = (int) (Movimiento.posicionAleatoriaY()*administradorJuego.getConfig().getAltoEscenario());
			switch (tipoBonus) {
				case 1:	
						bonus = new BonusMisil(new Posicion(x,y),new Tamanio(administradorJuego.getConfig().getAnchoBonus(), administradorJuego.getConfig().getAltoBonus()),administradorJuego, null); 
						break;
		
				case 2:	bonus = new BonusInmunidad(new Posicion(x,y),new Tamanio(administradorJuego.getConfig().getAnchoBonus(), administradorJuego.getConfig().getAltoBonus()),administradorJuego,null);
						break;
				case 3: bonus = new BonusReparacion(new Posicion(x,y),new Tamanio(administradorJuego.getConfig().getAnchoBonus(), administradorJuego.getConfig().getAltoBonus()),administradorJuego,null);
			}
			bonus.getTamanio().setAlto(administradorJuego.getConfig().getAltoBonus());
			bonus.getTamanio().setAncho(administradorJuego.getConfig().getAnchoBonus());
			
			bonus.setTiempoVida(99);

			
			administradorJuego.getListaElemento().add(bonus);
			administradorJuego.setBonusAleatorio(false);
		  }		

	}
	
	
	
	
	
	
	
	
	
	/**
	 * controla si un elemento se choco con otro elemento dentro del administradorJuego
	 */
	public static void verficarChoques(AdministradorJuego administradorJuego) {
		
		for(int i=0; i<administradorJuego.getListaElemento().size();i++){
			
			Elemento e1 = administradorJuego.getListaElemento().get(i);
			
			//guaramos las coordenadas para verificar si choco contra el tablero
			int coord1 = Movimiento.obtenerPosicionX(e1);
			int coord2 = Movimiento.obtenerPosicionY(e1);

			//Creamos el rectangulo
			Rectangle r1 = new Rectangle(e1.getPosicion().getX(),e1.getPosicion().getY(),
										e1.getTamanio().getAncho(),e1.getTamanio().getAlto());
			
			for(int j=i+1; j<administradorJuego.getListaElemento().size(); j++){
				
				//Creamos el rectangulo
				Elemento e2 = administradorJuego.getListaElemento().get(j);
				Rectangle r2 = new Rectangle(e2.getPosicion().getX(),
						e2.getPosicion().getY(),
						e2.getTamanio().getAncho(),
						e2.getTamanio().getAlto());												
				
				if(r1.intersects(r2)){
					e1.chocarContra(e2);
					e2.chocarContra(e1);
				}
			}
			
			
			// estaContenidoDentro, hace referencia si no se paso del tope del tablero
			// esta contenidoposito, se fija si las posiciones son positivas 
			boolean estaContenidoDentro = ( (coord1 >= administradorJuego.getConfig().getAnchoEscenario()) || (coord2 >= administradorJuego.getConfig().getAltoEscenario()) ); 
			boolean estaContenidoPositivo= (coord1<= 0) || (coord2 <= 0 ); 
			if(estaContenidoPositivo || estaContenidoDentro){
				e1.chocarContraPared();
			}			
		}


	}

	
	
	
	
	
	
	
}



