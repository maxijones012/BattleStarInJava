package grafica.pantallaCarga;

/**
 * 
 * I M P O R T A N T E
 * 
 * 
 * PARA EJECUTAR
 * new PantallaCargandoMain();
 * 
 * 
 */
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class PantallaCargandoMain {

	PantallaCargando screen;

	public PantallaCargandoMain() {
		inicioPantalla();
		screen.velocidadDeCarga();
	}


	/**
   * carga la imagen de incio del juego 
   */
  private void inicioPantalla() {
    ImageIcon myImage = new ImageIcon("imagen/java.gif");
    screen = new PantallaCargando(myImage);
    screen.setLocationRelativeTo(null);
    screen.setProgresoMax(100);
    screen.setVisible(true);
  }

	public static void main(String[] args) {
		new PantallaCargandoMain();
	}
}