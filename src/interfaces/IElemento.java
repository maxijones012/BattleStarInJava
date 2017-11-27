package interfaces;

import logicaJuego.Bomba;
import logicaJuego.BonusInmunidad;
import logicaJuego.BonusMisil;
import logicaJuego.BonusReparacion;
import logicaJuego.Elemento;
import logicaJuego.Misil;
import logicaJuego.Nave;
import logicaJuego.ObstaculoExplosivo;
import logicaJuego.Pasadizo;
/**
 * Interfaz implementada por los elementos dentro del juego 
 * @author carlos
 *
 */
public interface IElemento {
	
	/**
	 * METODO ABSTRACTO TODOS LOS ELEMENTOS QUE IMPLEMENTAN LA INTERFAZ DEBEN DE REDIFINIR ESTE METODO  
	 */
	public abstract void jugar();
	
	
	
	
//	/**
//	 * Indica el comportamiento que toma al chocar con otro elemento.
//	 * Se sobreescribe en las subclases
//	 * 
//	 * @param elemento Elemento con el que choco
//	 * @return 
//	 */
	public abstract void chocarContra(Elemento elemento);
//
//	
	/**
	 * Cuando un {@link Movible movible} choca contra una pared debera invertir su direccion
	 */
	public abstract void chocarContraPared();
//	
 /**
 * Cuando una bomba cocha con otra bomba esta ejecuta su metod destruir
 * @param bomba
 */
	public abstract void chocarContraBomba(Bomba bomba);

    /**
     *Cuando una nave choca contra el bonus se restaura el valor de combustible por defaul
     * y aumenta su nivel de vida en n unidadess
     * @param bonus
     */
	public abstract void chocarContraBonusReparacion (BonusReparacion bonus);
	/**
	 * Se otogra un tiempo de inmunidada a la nave 
	 * @param bonus
	 */
	public abstract void chocarContraBonusInmunidad(BonusInmunidad bonus);
	
	/**
	 * SE  VERIFICA SI EL MISIL Y EL BONUS SE SUPERPONEN
	 *  EL BONUS SE OTORGA A LA NAVE Y EL MISIL EJECUTA SU METODO DESTRUIR 
	 * @param bonus
	 */
	public abstract void chocarContraBonusMisil(BonusMisil bonus);
// 
	/**
	 * Verifica  si la nave se superpone con el  bonus 
	 * @param nave
	 */
	public abstract void chocarContraNave(Nave nave);
//	
//		
	/**
	 * cuando un elemento choca contra el pasadizo ejecuta  su metodo chocarContraPazadizo
	 * @param pasadizo
	 */
	public abstract void chocarContraPazadizo(Pasadizo pasadizo);
	
	/**
	 *  verifica si el misil se superpone con algun elemento dentro del juego 
	 * @param misil
	 */
	public abstract void chocarContraMisil(Misil misil);
	
	/**
	 * verifica si un elemento dentro del juego choca o se superpone con el  obstaculo explosivo 
	 * @param obstaculoExplosivo
	 */
	public abstract void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculoExplosivo);
	
	
}
