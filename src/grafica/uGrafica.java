package grafica;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import logicaJuego.Nave;

public class uGrafica {

	/**
	 * Dibuja el radar de la nave
	 * @param tableroJuego
	 * @param nave
	 */
	public static void dibujarRadar(TableroJuego tableroJuego, Nave nave) {
		tableroJuego.getGrafico2D().drawPolygon(nave.getRadar().getAreaCobertura());		
	}


	/**
	 * Cambia el tama�o de la imagen
	 * @param img
	 * @param ancho
	 * @param alto
	 * @return
	 */
/**
 * buffer con las imagnes cargadas desde el path 
 * @param img
 * @param ancho
 * @param alto
 * @return
 */
	public static BufferedImage cambiarTamanio(BufferedImage img, int ancho, int alto) {
		
		BufferedImage newImage = new BufferedImage(ancho,alto, BufferedImage.TYPE_INT_RGB);

		Graphics g = newImage.createGraphics();
		g.drawImage(img, 0, 0, ancho, alto, null);
		g.dispose();
		
		return newImage;
	}	
	
	
}
