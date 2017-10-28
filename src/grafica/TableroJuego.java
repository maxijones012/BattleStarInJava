package grafica;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;

import configuracion.ConfiguracionInicial;
import logicaJuego.AdministradorJuego;
import logicaJuego.Elemento;
import logicaJuego.Movible;
import logicaJuego.Nave;
import logicaJuego.ObstaculoExplosivo;
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
	 * @param administradorJuego
	 */
	public TableroJuego(AdministradorJuego administradorJuego) {
		this.administradorJuego=administradorJuego;
		this.altoNave=ConfiguracionInicial.ALTO_NAVE;
		this.anchoNave=ConfiguracionInicial.ANCHO_NAVE;
		
	}
			
	/**
	 * Crea un buffer para eliminar el parpadeo de la pantalla
	 */
	public void inicializar() {		
		//Crea dos buffers para dibujar.
		this.createBufferStrategy(2);		
		this.addKeyListener(this);
	}
	
	
	
	
	
	/**
	 * Dibuja los {@link Elemento elementos} en el escenario del juego
	 */
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
					Nave nave = (Nave) e2;
					uGrafica.dibujarRadar(this, nave);
					this.getGrafico2D().setColor(Color.RED);
					String nombre = e2.toString();
					this.getGrafico2D().drawString(nombre, x, y);
					
//					if (nave.getInmunidad()){
//						eImagen = getImagen(e.getClass().getName()+"Explotando")
//					}
				}
				
			}
			
			if (e instanceof ObstaculoExplosivo){
				ObstaculoExplosivo obstaculoExplosivo = (ObstaculoExplosivo) e;
				if (obstaculoExplosivo.isExplotando()==true){
//						uGrafica.dibujarExplosion(this,bomba);
					eImagen = getImagen(e.getClass().getName()+"Explotando");
				}
			}
			
			dibujarTiempoJuego(this, 40, 40);
			
			this.getGrafico2D().drawImage(eImagen, x, y, e.getTamanio().getAncho(), e.getTamanio().getAlto(), null);
			this.getGrafico2D().dispose();
		}
		
		this.getBufferStrategy().show();

	}


	/**
	 * Dibuja un contador en la pantalla en posicion (x,y)
	 * @param tableroJuego
	 * @param posX
	 * @param posY
	 */
	private void dibujarTiempoJuego(TableroJuego tableroJuego, int posX, int posY) {
		int tiempo = (tableroJuego.getAdministradorJuego().getTiempo());
		String ctiempo = Integer.toString(tiempo);			
		Font fuente = new Font("Monospaced", Font.ITALIC , 70);

		FontRenderContext frc = this.getGrafico2D().getFontRenderContext();
		
        TextLayout t = new TextLayout(ctiempo, fuente, frc);
        this.getGrafico2D().setColor(Color.pink);
        t.draw(this.getGrafico2D(), 70, 80);

        
		this.getGrafico2D().drawString(ctiempo, 40, 40);
	}

	
	
	/**
	 * obtiene el buffer de imagenes
	 * @return
	 */
	public Graphics2D getGrafico2D(){		
		if (this.getBufferStrategy() == null)
			return (Graphics2D) this.getGraphics();
		else 
			return (Graphics2D)this.getBufferStrategy().getDrawGraphics();		
	}
	
	
	
	/**
	 * 
	 * @param key
	 * @return
	 */
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
	 * @return Imagen rotada
	 */
	public BufferedImage rotarImagen(BufferedImage image, int angulo){
		return (uGrafica.rotar(image, angulo));
	}
	
	
	
	
	

	/**
	 * Obtengo el buffer que contiene todas las imagenes del juego
	 * @return listaImagenes
	 */
	public HashMap<String, BufferedImage> getListaImagenes() {
		return listaImagenes;
	}

	
	/**
	 * Carga las imagenes desde el fichero de sistema
	 * @param fileName
	 * @return new FileName or "no se encontro la imagen"
	 */
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


	/**
	 * Actualiza la pantalla
	 */
	public void actualizar() {
		limpiar();
 		dibujar(); 	
	}


	/**
	 * Limpia la pantalla o ventana de juego
	 */
	private void limpiar(){
		this.getGrafico2D().drawImage(getImagen("fondo"), 0, 0, getWidth(), getHeight(), null);
		this.getGrafico2D().dispose();
	}
	

}
