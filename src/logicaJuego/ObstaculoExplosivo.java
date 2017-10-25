package logicaJuego;

import java.lang.Override;

import configuracion.ConfiguracionInicial;

public class ObstaculoExplosivo extends Estatico{
	private int tiempoDeExplosion;
	private int nivelDanio=ConfiguracionInicial.DANIO_OBSTACULO_EXPLOSIVO;
	private boolean explotando=false;
	
	public ObstaculoExplosivo(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
		this.tiempoDeExplosion=this.getAdministradorJuego().getConfiguracionInicial().getTiempoDeExplosion();
	}

	@Override
	public void jugar() {
		if (isExplotando()){
			this.setTiempoDeExplosion(getTiempoDeExplosion()-1);
		}

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
			this.setExplotando(true);
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
	public void chocarContraNave(Nave nave) {
		explotar();
	}

	public int getNivelDanio() {
		return nivelDanio;
	}

	@Override
	public void chocarContraPazadizo(Pasadizo pasadizo) {}

	@Override
	public void chocarContraMisil(Misil misil) {
		this.setNivelVida(this.getNivelVida()-misil.getNivelDanio());
		explotar();
	}

	@Override
	public void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculoExplosivo) {}

	public boolean isExplotando() {
		return explotando;
	}

	public void setExplotando(boolean explotando) {
		this.explotando = explotando;
	}

}
