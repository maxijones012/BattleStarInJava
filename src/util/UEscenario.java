package util;


import java.awt.Rectangle;
import java.util.Random;

import logicaJuego.Bonus;
import logicaJuego.BonusInmunidad;
import logicaJuego.BonusMisil;
import logicaJuego.BonusReparacion;
import logicaJuego.Elemento;
import logicaJuego.Escenario;
import logicaJuego.NaveCrazy;
import logicaJuego.Posicion;
import logicaJuego.Tamanio;

public abstract class UEscenario {
	/**
	 * da los turno a cada elemento del juego 
	 * @param escenario
	 */
	public static void darTurno(Escenario escenario){
		for(int i=0; i<escenario.getListaElemento().size(); i++){
			Elemento elemento = escenario.getListaElemento().get(i);			
			elemento.jugar();
		}
	}
	

	/**
	 * Elimina los elementos de la lista
	 * @param escenario
	 */
	public static void eliminarElementos(Escenario escenario){
		
		for(int i=0; i<escenario.getListaElemento().size();i++){
			if (!escenario.getListaElemento().get(i).getEstaVivo())
				escenario.getListaElemento().remove(i);
		}
		
		
	}


	//TODO HACER LOS CREAR ELEMENTOS
	public static void crearElementos(Escenario escenario) {
		NaveCrazy naveCrazy = new NaveCrazy(new Posicion(40, 40), new Tamanio(30, 30), escenario);
		escenario.getListaElemento().add(naveCrazy);
		
		
	}
	
	
	public static void crearBonus(Escenario escenario) {
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
			  int x = (int) (Movimiento.posicionAleatoriaX()*escenario.getConfig().getAnchoEscenario());
			  int y = (int) (Movimiento.posicionAleatoriaY()*escenario.getConfig().getAltoEscenario());
			switch (tipoBonus) {
				case 1:	
						bonus = new BonusMisil(new Posicion(x,y),new Tamanio(escenario.getConfig().getAnchoBonus(), escenario.getConfig().getAltoBonus()),escenario, null); 
						break;
		
				case 2:	bonus = new BonusInmunidad(new Posicion(x,y),new Tamanio(escenario.getConfig().getAnchoBonus(), escenario.getConfig().getAltoBonus()),escenario,null);
						break;
				case 3: bonus = new BonusReparacion(new Posicion(x,y),new Tamanio(escenario.getConfig().getAnchoBonus(), escenario.getConfig().getAltoBonus()),escenario,null);
			}
			bonus.getTamanio().setAlto(escenario.getConfig().getAltoBonus());
			bonus.getTamanio().setAncho(escenario.getConfig().getAnchoBonus());
			
			bonus.setTiempoVida(99);

			
			escenario.getListaElemento().add(bonus);
			escenario.setBonusAleatorio(false);
		  }		

	}
	
	
	
	
	
	
	
	
	
	/**
	 * controla si un elemento se choco con otro elemento dentro del escenario
	 */
	public static void verficarChoques(Escenario escenario) {
		
		for(int i=0; i<escenario.getListaElemento().size();i++){
			
			Elemento e1 = escenario.getListaElemento().get(i);
			
			//guaramos las coordenadas para verificar si choco contra el tablero
			int coord1 = Movimiento.obtenerPosicionX(e1);
			int coord2 = Movimiento.obtenerPosicionY(e1);

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
					e2.chocarContra(e1);
				}
			}
			
			
			// estaContenidoDentro, hace referencia si no se paso del tope del tablero
			// esta contenidoposito, se fija si las posiciones son positivas 
			boolean estaContenidoDentro = ( (coord1 >= escenario.getConfig().getAnchoEscenario()) || (coord2 >= escenario.getConfig().getAltoEscenario()) ); 
			boolean estaContenidoPositivo= (coord1<= 0) || (coord2 <= 0 ); 
			if(estaContenidoPositivo || estaContenidoDentro){
				e1.chocarContraPared();
			}			
		}


	}

	
	
	
	
	
	
	
}



