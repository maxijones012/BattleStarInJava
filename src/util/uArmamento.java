package util;


import configuracion.ConfiguracionInicial;
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
public abstract class uArmamento {
	
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
		if (nave.getCantidadBomba() > 0){	
			int ancho = ConfiguracionInicial.ANCHO_BOMBA;
			int alto = ConfiguracionInicial.ALTO_BOMBA;
			
			Bomba b = new Bomba(nave, new Posicion(nave.getPosicion().getX(), nave.getPosicion().getY()), new Tamanio(ancho,alto),nave.getAdministradorJuego());
			b.setDireccion(nave.getDireccion());
			b.setDuenio(nave);
			nave.setCantidadBomba(nave.getCantidadBomba()-1);
			nave.getAdministradorJuego().addElemento(b);
		}
	}

	
	/**
	 * Crea un {@link Misil misil}, apartir de la posicion de la {@link Nave nave}
	 * @param nave que es la que crea el Misil
	 */
	public static void dispararMisil(Nave nave) {
		int ancho=ConfiguracionInicial.ANCHO_MISIL;
		int alto = ConfiguracionInicial.ALTO_MISIL;
		if (nave.getCantidadMunicion() > 0){
			Misil misil = new Misil(nave, new Posicion(nave.getPosicion().getX(), nave.getPosicion().getY()), new Tamanio(ancho,alto),nave.getAdministradorJuego());
			misil.setDireccion(nave.getDireccion());
			misil.setDuenio(nave);
			nave.setCantidadMunicion(nave.getCantidadMunicion()-1);	
			nave.getAdministradorJuego().addElemento(misil);
		}
	}

	/**
	 * Crea un radio de explosion que afecta a aquellos elementos que esten dentro de ese
	 * area de cobertura
	 * @param bomba
	 */
	//TODO [MEJORA] Muestren esta animación de alguna manera en la interfaz. Ej que la bomba aumente de tamaño
	public static void explotar(Bomba bomba){
		//TODO mejorar y controla que haga bien el circulo
		if (bomba!= null){
			int x = bomba.getPosicion().getX();
			int y= bomba.getPosicion().getY();
			
			Circulo circulo = new Circulo(x,y, 25); //TODO EL 50 SACARLO DE CONFIG
			circulo.getAreaCobertura();
			
		}
		
	}


	public static void dispararBomba(Nave nave, int dir) {
		if (nave.getCantidadBomba() > 0){	
			int ancho = ConfiguracionInicial.ANCHO_BOMBA;
			int alto = ConfiguracionInicial.ALTO_BOMBA;
			
			Bomba b = new Bomba(nave, new Posicion(nave.getPosicion().getX(), nave.getPosicion().getY()), new Tamanio(ancho,alto),nave.getAdministradorJuego());
			b.setDireccion(dir);
			b.setDuenio(nave);
			nave.setCantidadBomba(nave.getCantidadBomba()-1);
			nave.getAdministradorJuego().addElemento(b);
		}
		
	}


	public static void dispararMisil(Nave nave, int dir) {
		int ancho=ConfiguracionInicial.ANCHO_MISIL;
		int alto = ConfiguracionInicial.ALTO_MISIL;
		if (nave.getCantidadMunicion() > 0){
			Misil misil = new Misil(nave, new Posicion(nave.getPosicion().getX(), nave.getPosicion().getY()), new Tamanio(ancho,alto),nave.getAdministradorJuego());
			misil.setDireccion(dir);
			misil.setDuenio(nave);
			nave.setCantidadMunicion(nave.getCantidadMunicion()-1);	
			nave.getAdministradorJuego().addElemento(misil);
		}
		
	}


	
	
	//TODO se podria hacer un 
//	public void estrategiaDeDisparo();
}
