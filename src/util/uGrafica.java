package util;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import grafica.TableroJuego;
import logicaJuego.Bomba;
import logicaJuego.Nave;

public class uGrafica {

	
	public static void dibujarRadar(TableroJuego tableroJuego, Nave nave) {
		tableroJuego.getGrafico2D().drawPolygon(nave.getRadar().getAreaCobertura());
	}



	public static BufferedImage cambiarTamanio(BufferedImage img, int ancho, int alto) {
		
//		BufferedImage newImage = new BufferedImage(ancho,alto, BufferedImage.TYPE_INT_RGB); //esto agrega el fondo en los elementos
		BufferedImage newImage = new BufferedImage(ancho,alto, BufferedImage.TRANSLUCENT);

		Graphics g = newImage.createGraphics();
		g.drawImage(img, 0, 0, ancho, alto, null);
		g.dispose();
		
		return newImage;
	}



	/**
	 * Calcula la dimension
	 * @param img
	 * @param angulo
	 * @return
	 */
	private static Dimension calcularDimension(BufferedImage img, int angulo){
		double w = (double)img.getWidth();
		double h = (double)img.getHeight();

		double x1 = Math.abs(w * Math.cos(Math.toRadians(angulo))); 
		double x2 = Math.abs(h * Math.sin(Math.toRadians(angulo)));

		double y1 = Math.abs(h * Math.cos(Math.toRadians(angulo))); 
		double y2 = Math.abs(w * Math.sin(Math.toRadians(angulo)));

		return new Dimension((int)(x1+x2), (int)(y1+y2));
	}
	


	public static BufferedImage rotar(BufferedImage image, int angulo) {
		Dimension dim = calcularDimension(image, angulo);

		int w2 = (int)dim.getWidth();
		int h2 = (int)dim.getHeight();		

		int w = image.getWidth();
		int h = image.getHeight();		

		BufferedImage image2 = new BufferedImage(w2, h2, BufferedImage.TRANSLUCENT);

		Graphics2D g2d = (Graphics2D)image2.getGraphics();

		double x = (w2- w) / 2.0;
		double y = (h2-h) / 2.0;

		AffineTransform at = AffineTransform.getTranslateInstance(x, y);
		at.rotate(Math.toRadians(angulo), w/2, h/2);

		g2d.drawRenderedImage(image, at);

		return image2;		
	}



	public static void dibujarExplosion(TableroJuego tableroJuego, Bomba bomba) {
//		tableroJuego.getGrafico2D().drawPolygon(nave.getRadar().getAreaCobertura());
		
		int x= bomba.getPosicion().getX()-45;
		int y= bomba.getPosicion().getY()-45;
		
		tableroJuego.getGrafico2D().drawOval(x, y,120, 120);	
		
	}	
	
	
}
