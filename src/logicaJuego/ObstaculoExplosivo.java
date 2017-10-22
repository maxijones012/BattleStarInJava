package logicaJuego;

import java.lang.Override;

public class ObstaculoExplosivo extends Estatico{
	private int tiempoDeExplosion;
	private int nivelDanio=50;
	
	public ObstaculoExplosivo(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
		this.tiempoDeExplosion=this.getAdministradorJuego().getConfiguracionInicial().getTiempoDeExplosion();
	}

	@Override
	public void jugar() {

	}

	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraObstaculoExplosivo(this);
		
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

	public int getNivelDanio() {
		return nivelDanio;
	}

	@Override
	public void chocarContraPazadizo(Pasadizo pasadizo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContraMisil(Misil misil) {
		this.setNivelVida(this.getNivelVida()-misil.getNivelDanio());
	}

	@Override
	public void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculoExplosivo) {
		// TODO Auto-generated method stub
		
	}

}
