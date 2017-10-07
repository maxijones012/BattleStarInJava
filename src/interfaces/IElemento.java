package interfaces;

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
//	public void chocarContraPared() {}
//	
//	public void chocarContraMunicion(Municion municion){}
//	
//	public void chocarContraBomba(Bomba bomba){}
//	
//	public void chocarContraBonus(){}
//
//
	public abstract void chocarContraBonusReparacion (BonusReparacion bonus);
//
	public abstract void chocarContraBonusInmunidad(BonusInmunidad bonus);
	
	public abstract void chocarContraBonusMisil(BonusMisil bonus);
//
//	public void chocarContraNave(Nave nave){}
//	
//		
	

	
}
