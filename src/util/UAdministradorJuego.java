package util;


import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import configuracion.ConfiguracionInicial;
import logicaJuego.Bonus;
import logicaJuego.BonusInmunidad;
import logicaJuego.BonusMisil;
import logicaJuego.BonusReparacion;
import logicaJuego.Elemento;
import logicaJuego.Nave;
import logicaJuego.AdministradorJuego;
import logicaJuego.Bomba;
import logicaJuego.NaveCrazy;
import logicaJuego.NaveEcuatorial;
import logicaJuego.NaveGreenwich;
import logicaJuego.NaveManual;
import logicaJuego.ObstaculoExplosivo;
import logicaJuego.Pasadizo;
import logicaJuego.Posicion;
import logicaJuego.Tamanio;

public abstract class uAdministradorJuego {
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


	/**
	 * Se crean todos los elementos que estan dentro del juego
	 * @param administradorJuego
	 */
	public static void crearElementos(AdministradorJuego administradorJuego) {
		Tamanio tamanioNave = new Tamanio(ConfiguracionInicial.ANCHO_NAVE,ConfiguracionInicial.ALTO_NAVE);
		
		NaveCrazy naveCrazy = new NaveCrazy(new Posicion(607, 100), tamanioNave, administradorJuego);
		administradorJuego.getListaElemento().add(naveCrazy);
		
		
		NaveManual naveManual = new NaveManual(new Posicion(450,250),tamanioNave, administradorJuego);
		administradorJuego.addElemento(naveManual);
		

		NaveGreenwich naveGranwich = new NaveGreenwich(new Posicion(200, 500), tamanioNave, administradorJuego);
		administradorJuego.addElemento(naveGranwich);
		
		
		tamanioNave = new Tamanio(ConfiguracionInicial.ANCHO_NAVE,80);
		NaveEcuatorial naveEcutaorial = new NaveEcuatorial(new Posicion(600, 300), tamanioNave, administradorJuego);
		administradorJuego.getListaElemento().add(naveEcutaorial);
		
		
		//-----------------------------------------------------------------------
		//		P A S A D I Z O 
		//-----------------------------------------------------------------------
		Posicion posicion_pazadizoA= new Posicion(ConfiguracionInicial.POSICION_X_PASADIZO_A, ConfiguracionInicial.POSICION_Y_PASADIZO_A);
		Posicion posicion_pazadizoB = new Posicion(ConfiguracionInicial.POSICION_X_PASADIZO_B, ConfiguracionInicial.POSICION_Y_PASADIZO_B);
		Pasadizo pasadizoA = new Pasadizo(posicion_pazadizoA, new Tamanio(ConfiguracionInicial.ANCHO_PASADIZO, ConfiguracionInicial.ALTO_PASADIZO),administradorJuego,posicion_pazadizoB);
		administradorJuego.addElemento(pasadizoA);
		
		posicion_pazadizoB= new Posicion(ConfiguracionInicial.POSICION_X_PASADIZO_A, ConfiguracionInicial.POSICION_Y_PASADIZO_A);
		posicion_pazadizoA = new Posicion(ConfiguracionInicial.POSICION_X_PASADIZO_B, ConfiguracionInicial.POSICION_Y_PASADIZO_B);
		Pasadizo pasadizoB = new Pasadizo(posicion_pazadizoA, new Tamanio(ConfiguracionInicial.ANCHO_PASADIZO, ConfiguracionInicial.ALTO_PASADIZO),administradorJuego,posicion_pazadizoB);
		administradorJuego.addElemento(pasadizoB);
		
		
		
		ObstaculoExplosivo obstaculoExplosivo = new ObstaculoExplosivo(new Posicion(ConfiguracionInicial.POSICION_X_OBSTACULO_EXPLOSIVO, ConfiguracionInicial.POSICION_Y_OBSTACULO_EXPLOSIVO), new Tamanio(ConfiguracionInicial.ANCHO_OBSTACULO_EXPLOSIVO, ConfiguracionInicial.ALTO_OBSTACULO_EXPLOSIVO), administradorJuego);
		administradorJuego.addElemento(obstaculoExplosivo);
		
		
		
		
	}
	
	/**
	 * Genera bonus con {@link Posicion posion} aleatorias, y de los tipos 
	 * {@link BonusReparacion bonusReparacion}
	 * {@link BonusMisil bonusMisil}
	 * {@link BonusInmunidad bonusInmunidad}
	 * @param administradorJuego
	 */
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
		  int tipoBonus = (int)(tipoRandom.nextDouble()*3+1);
		  if(administradorJuego.getBonusAleatorio()==true){				  
			  int x = (int) (uMovimiento.posicionAleatoriaX()*ConfiguracionInicial.ANCHO_ESCENARIO);
			  int y = (int) (uMovimiento.posicionAleatoriaY()*ConfiguracionInicial.ALTO_ESCENARIO);
			switch (tipoBonus) {
				case 1:	
						bonus = new BonusMisil(new Posicion(x,y),new Tamanio(administradorJuego.getConfiguracionInicial().getAnchoBonus(), administradorJuego.getConfiguracionInicial().getAltoBonus()),administradorJuego, null); 
						break;
		
				case 2:	bonus = new BonusInmunidad(new Posicion(x,y),new Tamanio(administradorJuego.getConfiguracionInicial().getAnchoBonus(), administradorJuego.getConfiguracionInicial().getAltoBonus()),administradorJuego,null);
						break;
				case 3: bonus = new BonusReparacion(new Posicion(x,y),new Tamanio(administradorJuego.getConfiguracionInicial().getAnchoBonus(), administradorJuego.getConfiguracionInicial().getAltoBonus()),administradorJuego,null);
			}
			bonus.getTamanio().setAlto(administradorJuego.getConfiguracionInicial().getAltoBonus());
			bonus.getTamanio().setAncho(administradorJuego.getConfiguracionInicial().getAnchoBonus());
			
			
			administradorJuego.getListaElemento().add(bonus);
			administradorJuego.setBonusAleatorio(false);
		  }		

	}
	
	
	
	
	
	
	
	
	
	/**
	 * controla si un {@link Elemento elemento} se choco con otro elemento dentro del escenario
	 */
	public static void verficarChoques(AdministradorJuego administradorJuego) {
		
		for(int i=0; i<administradorJuego.getListaElemento().size();i++){
			
			Elemento e1 = administradorJuego.getListaElemento().get(i);
			//guaramos las coordenadas para verificar si choco contra el tablero
			int coord1 = uMovimiento.obtenerPosicionX(e1);
			int coord2 = uMovimiento.obtenerPosicionY(e1);

			//Creamos el rectangulo
			Rectangle r1 = new Rectangle(e1.getPosicion().getX(),e1.getPosicion().getY(),
										e1.getTamanio().getAncho(),e1.getTamanio().getAlto());

			if (e1 instanceof Pasadizo) {
				r1.setSize(1,1);
				Posicion pos = uMovimiento.getCentro(e1);
				r1.setLocation(pos.getX(), pos.getY());
			}
			if (e1 instanceof Bomba) {
				Bomba bomb = (Bomba) e1;
				if (bomb.isEstaExplotando()){
					r1.setSize(ConfiguracionInicial.ANCHO_BOMBA*2, ConfiguracionInicial.ALTO_BOMBA*2);
				}
			}
			
			
			for(int j=i+1; j<administradorJuego.getListaElemento().size(); j++){
				
				Elemento e2 = administradorJuego.getListaElemento().get(j);

				//Creamos el rectangulo
				Rectangle r2 = new Rectangle(e2.getPosicion().getX(),
						e2.getPosicion().getY(),
						e2.getTamanio().getAncho(),
						e2.getTamanio().getAlto());												

				if (e2 instanceof Pasadizo) {
					r2.setSize(1,1);

				}
				
				if (e2 instanceof Bomba) {
					Bomba bomb = (Bomba) e2;
					if (bomb.isEstaExplotando()){
						r2.setSize(ConfiguracionInicial.ANCHO_BOMBA*2, ConfiguracionInicial.ALTO_BOMBA*2);
					}
				}

				if(r1.intersects(r2)){
					uDebugConsola.mostrarColision(e1, e2);
					e1.chocarContra(e2);
					e2.chocarContra(e1);

				}
			}
			
			
			// estaContenidoDentro, hace referencia si no se paso del tope del tablero
			// esta contenidoposito, se fija si las posiciones son positivas
			
			//controlamos la posicion de arriba
			int correctorVentana=100;
			coord1 = coord1 + correctorVentana;
			coord2 = coord2 + correctorVentana;
			boolean estaContenidoDentro = ( (coord1 >= ConfiguracionInicial.ANCHO_ESCENARIO) || (coord2 >= ConfiguracionInicial.ALTO_ESCENARIO) );

			//controlamos la posicion de abajo
			coord1 = coord1 - correctorVentana;
			coord2 = coord2 - correctorVentana;
			boolean estaContenidoPositivo= (coord1<= 0) || (coord2 <= 0 ); 
			if(estaContenidoPositivo || estaContenidoDentro){
				e1.chocarContraPared();
			}			
		}


	}




	/**
	 * Busca todas las naves vivas que quedaon al finalizar el juego, y las muestra
	 * @param elementos
	 * @return
	 */
	public static int buscarNaveVivos(ArrayList<Elemento> elementos) {
		int contador=0;
		for (int i = 0; i < elementos.size(); i++) {
			Elemento e = elementos.get(i);
			if (e instanceof Nave){
				contador++;
				Nave nave = (Nave) e;
				mostrarNave(nave);
			}
		}
		return (contador);
	}

	
	/**
	 * Muestra el nombre de la nave
	 * @param nave
	 */
	private static void mostrarNave(Nave nave) {
		String c = nave.getClass().getName();
		c = c.substring(12, c.length());
		System.out.println("GANADOR: "+ c);
	}

	
	
	
	
	
	
	
}



