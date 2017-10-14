package logicaJuego;

/**
 *  Se  mueve  por  el  escenario  sin  un  rumbo  fijo,  y  dispara  misiles  cada  vez  que  toca  
 *     alguno​ ​de​ ​los​ ​límites​ ​del​ ​escenario.
 * @author Maxi Jones
 *
 */
public class NaveCrazy extends Nave{
	
	
	
	//constructor
	public NaveCrazy(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
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
	public void chocarContraPared() {
		super.girar(-90); //TODO CAPAZ QUE HAY QUE CAMBIARLO A 90
		this.disparar(new Misil(this, null, null, null)); //TODO VERIFICAR LOS 'NULL'
	}













	

}
