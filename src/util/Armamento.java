package util;


import logicaJuego.Bomba;
import logicaJuego.Misil;
import logicaJuego.Nave;
import logicaJuego.Posicion;
import logicaJuego.Tamanio;

/**
 * clase abstracta Armamento, donde tiene todos los metodos para 
 * que SOLO LOS OBJETOS MOVIBLES,puedan usarla
 * @author Maxi Jones
 *
 */
public abstract class Armamento {
	static class Circulo {
	    public double x, y;
	    public double radio;
	    public Circulo(){;}
	    public Circulo(double posx, double posy, double r){
	            x = posx;
	            y = posy;
	            radio = r;
	    }
	    public  double getAreaCobertura(){ return 2 * 3.14159 * radio;}
	    public  double area(){ return 3.14159 * radio * radio;}
	}

	
	/**
	 * crea una nueva BOMBA apartir de la posicion de una nave
	 * @param nave
	 */
	public static void dispararBomba(Nave nave) {
		if (nave.getCantidadBomba()>0){
			Posicion posicion = new Posicion(nave.getPosicion().getX(),nave.getPosicion().getY());
			Tamanio tamanio = new Tamanio(nave.getTamanio().getAncho(), nave.getTamanio().getAlto());
			new Bomba(nave, posicion,tamanio, nave.getAministradorJuego());
			new Bomba(nave, posicion,tamanio, nave.getAdministradorJuego());
		}
	}

	
	/**
	 * Crea un MISIL, apartir de la posicion de la nave
	 * @param nave
	 */
	public static void dispararMisil(Nave nave) {
		if (nave.getCantidadMunicion()>0){
			Posicion posicion = new Posicion(nave.getPosicion().getX(),nave.getPosicion().getY());
			Tamanio tamanio = new Tamanio(nave.getTamanio().getAncho(), nave.getTamanio().getAlto());
			new Misil(nave, posicion,tamanio, nave.getAministradorJuego());
			new Misil(nave, posicion,tamanio, nave.getAdministradorJuego());
		}
	}

	public static void explotar(Bomba bomba){
		//TODO mejorar y controla que haga bien el circulo
		if (bomba!= null){
			int x = bomba.getPosicion().getX();
			int y= bomba.getPosicion().getY();
			
			Circulo circulo = new Circulo(x,y, 25); //TODO EL 50 SACARLO DE CONFIG
			circulo.getAreaCobertura();
			
		}
		
	};
	
	
	//TODO se podria hacer un 
//	public void estrategiaDeDisparo();
}
