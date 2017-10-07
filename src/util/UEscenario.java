package util;


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

public class UEscenario {
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
			  int x = (int) (Movimiento.posicionAleatoriaX()*escenario.getConfig().getConfigEscenario().getAnchoEscenario());
			  int y = (int) (Movimiento.posicionAleatoriaY()*escenario.getConfig().getConfigEscenario().getAltoEscenario());
			switch (tipoBonus) {
				case 1:	
						bonus = new BonusMisil(new Posicion(x,y),new Tamanio(escenario.getConfig().getBonusConfig().getAncho(), escenario.getConfig().getBonusConfig().getAlto()),escenario); 
						break;
		
				case 2:	bonus = new BonusInmunidad(new Posicion(x,y),new Tamanio(escenario.getConfig().getBonusConfig().getAncho(), escenario.getConfig().getBonusConfig().getAlto()),escenario);
						break;
				case 3: bonus = new BonusReparacion(new Posicion(x,y),new Tamanio(escenario.getConfig().getBonusConfig().getAncho(), escenario.getConfig().getBonusConfig().getAlto()),escenario);
			}
			bonus.getTamanio().setAlto(escenario.getConfig().getBonusConfig().getAlto());
			bonus.getTamanio().setAncho(escenario.getConfig().getBonusConfig().getAncho());
			
			bonus.setTiempoVida(99);

			
			escenario.getListaElemento().add(bonus);
			escenario.setBonusAleatorio(false);
		  }		

	}
}



