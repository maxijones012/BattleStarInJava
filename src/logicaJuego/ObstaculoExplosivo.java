package logicaJuego;

import java.lang.Override;

public class ObstaculoExplosivo extends Estatico{
	private int tiempoDeExplosion=20;
	
//	constructor 
	public ObstaculoExplosivo(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
	}

	@Override
	public void jugar() {

	}

	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
		
	}

	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {}

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {}

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

	@Override
	public void chocarContraPared() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContraBomba(Bomba bomba) {
		this.setNivelVida(getNivelVida()-bomba.getDanioBomba());
	}

	@Override
	public void chocarContraNave(Nave nave) {}

}
