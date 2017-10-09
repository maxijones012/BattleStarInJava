package logicaJuego;

/**
 *  Se  mueve  por  el  escenario  sin  un  rumbo  fijo,  y  dispara  misiles  cada  vez  que  toca  
 *     alguno​ ​de​ ​los​ ​límites​ ​del​ ​escenario.
 * @author Maxi Jones
 *
 */
public class NaveCrazy extends Nave{

	
	
	//constructor
	public NaveCrazy(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
	}


	
	
	@Override
	public void jugar() {
		
		super.jugar();
	}




	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
	}



	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		// TODO obtener beneficio
		
	}


	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		// TODO obtener beneficio
		
	}


	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		// TODO obtener beneficio
		
	}




	@Override
	public void chocarContraPared() {
		this.disparar(new Misil(this, null, null, null)); //TODO VERIFICAR LOS 'NULL'
	}








	

}
