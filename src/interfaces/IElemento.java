package interfaces;

import logicaJuego.Bomba;
import logicaJuego.BonusInmunidad;
import logicaJuego.BonusMisil;
import logicaJuego.BonusReparacion;
import logicaJuego.Elemento;

public interface IElemento {
	
	/**
	 * 
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
	public abstract void chocarContraPared();
//	
//	
	public abstract void chocarContraBomba(Bomba bomba);

	public abstract void chocarContraBonusReparacion (BonusReparacion bonus);

	public abstract void chocarContraBonusInmunidad(BonusInmunidad bonus);
	
	public abstract void chocarContraBonusMisil(BonusMisil bonus);
//
//	public void chocarContraNave(Nave nave){}
//	
//		
	

	
}
