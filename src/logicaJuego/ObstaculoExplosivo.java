package logicaJuego;

import java.lang.Override;

public class ObstaculoExplosivo extends Estatico{
	private int tiempoDeExplosion=20;
	
//	constructor 
	public ObstaculoExplosivo(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
		
	}

	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {	
		explotar();
	}

	
	
	private void explotar() { //TODO VERIFICAR ESTO
		if (getTiempoDeExplosion()>0){
			
		}else{this.destruir(this);}
		
	}

	public int getTiempoDeExplosion() {
		return tiempoDeExplosion;
	}

	public void setTiempoDeExplosion(int tiempoDeExplosion) {
		this.tiempoDeExplosion = tiempoDeExplosion;
	}

}
