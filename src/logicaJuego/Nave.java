package logicaJuego;

import interfaces.INave;
import util.Armamento;

public abstract class Nave implements INave{

	
	
	
	@Override
	public void dispararBomba() {
		Armamento.dispararBomba(this);
	}

	
	
	@Override
	public void dispararMunicion() {
		Armamento.dispararMunicion(this);
	}

}
