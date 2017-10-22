package grafica;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;

import com.sun.prism.paint.Color;

import logicaJuego.AdministradorJuego;
import logicaJuego.Bomba;
import logicaJuego.Elemento;
import logicaJuego.Movible;
import logicaJuego.Nave;
import util.Controles;
import util.uGrafica;
import util.uMovimiento;

@SuppressWarnings("serial")
public class TableroJuego extends Canvas implements KeyListener{
	private AdministradorJuego administradorJuego;
	private HashMap<String, BufferedImage> listaImagenes;
	private int anchoNave;
	private int altoNave;
	

	/**
	 * Constructor de la clase tablero de Juego, donde se  dibujan los elementos 
	 * 
	 */
	public TableroJuego(AdministradorJuego administradorJuego) {
		this.administradorJuego=administradorJuego;
		this.altoNave=this.getAdministradorJuego().getConfiguracionInicial().getAltoNave();
		this.anchoNave=this.getAdministradorJuego().getConfiguracionInicial().getAnchoNave();
		
	}
			
			
	public void inicializar() {		
		//Crea dos buffers para dibujar.
		this.createBufferStrategy(2);		
		this.addKeyListener(this);
	}
	
	
	
	private void dibujar(){
		for (int i=0; i< administradorJuego.getListaElemento().size(); i++){
			//pinto cada elemento
			Elemento e = administradorJuego.getListaElemento().get(i);//creo un elemento manipulable	
			int x = uMovimiento.obtenerPosicionX(e);
			int y = uMovimiento.obtenerPosicionY(e);

			
			//busca el nombre de la clase con el nombre del archivo

			BufferedImage eImagen =  getImagen(e.getClass().getName());

			if (e instanceof Movible){
				Movible e2 = (Movible) e;				
				eImagen = rotarImagen(eImagen, e2.getDireccion());
				if (e2 instanceof Nave){
					Nave Nave = (Nave) e2;
					uGrafica.dibujarRadar(this, Nave);
					String nombre = e2.toString();
					this.getGrafico2D().drawString(nombre, x, y);
				}
				
				if (e2 instanceof Bomba){
					Bomba bomba = (Bomba) e2;
					if (bomba.isEstaExplotando()==true){
						uGrafica.dibujarExplosion(this,bomba);
					}
				}

			}

			this.getGrafico2D().drawImage(eImagen, x, y, e.getTamanio().getAncho(), e.getTamanio().getAlto(), null);
			this.getGrafico2D().dispose();
		}
		
		this.getBufferStrategy().show();

	}



	public Graphics2D getGrafico2D(){		
		if (this.getBufferStrategy() == null)
			return (Graphics2D) this.getGraphics();
		else 
			return (Graphics2D)this.getBufferStrategy().getDrawGraphics();		
	}
	
	
	private BufferedImage getImagen(String key){
		if (listaImagenes == null)
			listaImagenes = new HashMap<String, BufferedImage>();
		BufferedImage img = listaImagenes.get(key);
		if (img == null) {
			img = cargarImagen(System.getProperty("user.dir") + File.separator + "img" + File.separator + key + ".png");
			if (img != null){
				if (key != "fondo")
					img = uGrafica.cambiarTamanio(img, getAnchoNave(), getAltoNave());
				listaImagenes.put(key, img);
			}
		}
		return img;
	}		
			
			
			
	
			
	
	/**
	 * Se rota la imagen del elemento y se la devuelve en {@link BufferedImage bufferedImage}
	 * @param image
	 * @param angulo
	 * @return
	 */
	public BufferedImage rotarImagen(BufferedImage image, int angulo){
		return (uGrafica.rotar(image, angulo));
	}
	
	
	
	
	


	public HashMap<String, BufferedImage> getListaImagenes() {
		return listaImagenes;
	}

	private BufferedImage cargarImagen(String fileName){
		try {
			return ImageIO.read(new File(fileName));
		} catch (Exception e) {
			System.out.println("No se encontro la imagen " + fileName);

			return null;
		}
		
	}

	
	
	
	
	public int getAltoNave() {
		return altoNave;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		Controles.controlTeclado(this, e, getAdministradorJuego().getConfiguracionInicial());
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent c) {
		
	}
	

	public AdministradorJuego getAdministradorJuego() {
		return administradorJuego;
	}
	public int getAnchoNave() {
		return anchoNave;
	}


	public void actualizar() {
		limpiar();
 		dibujar(); 	
	}


	
	private void limpiar(){
		this.getGrafico2D().drawImage(getImagen("fondo"), 0, 0, getWidth(), getHeight(), null);
		this.getGrafico2D().dispose();
	}
	

}
