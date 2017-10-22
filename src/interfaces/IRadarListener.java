package interfaces;

import java.util.ArrayList;
import logicaJuego.Elemento;
/**
 * 
 * @author carlos
 * se define una interfaz(para implementar el patron observer obserbale)
 */
public interface IRadarListener {
	/**
	 * define un arraylist de los elementos que "escuchan el radar"
	 * @param elementos
	 */
	void elementosVistos(ArrayList<Elemento> elementos);

}
