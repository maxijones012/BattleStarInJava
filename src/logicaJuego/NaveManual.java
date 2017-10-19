package logicaJuego;

import java.util.ArrayList;

public class NaveManual extends Nave{

	public NaveManual(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
	}

	
	
	@Override
	public void jugar() {
		if(this.getAdministradorJuego().getConfiguracionInicial().isDisMunicion()){
			this.disparar(new Misil(this, null, null, this.getAdministradorJuego()));
			this.getAdministradorJuego().getConfiguracionInicial().setDisMunicion(false);
		}
		if(this.getAdministradorJuego().getConfiguracionInicial().isDisBomba()){
			this.disparar(new Bomba(this, null, null, this.getAdministradorJuego()));
			this.getAdministradorJuego().getConfiguracionInicial().setDisBomba(false);
		}
		if (this.getAdministradorJuego().getConfiguracionInicial().isDerecha()){
			this.setDireccion(0);		
			this.avanzar();
		}
		else{
			if (this.getAdministradorJuego().getConfiguracionInicial().isIzquierda()){
				this.setDireccion(180);
				this.avanzar();
			}
			else{
				if (this.getAdministradorJuego().getConfiguracionInicial().isArriba()){
					this.setDireccion(270);
					this.avanzar();
				}
				else{
					this.setDireccion(90); 
					this.avanzar();
				}
			}
		}				
	}
	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {}

	@Override
	public void chocarContraPared() {
		// TODO Auto-generated method stub
		
	}

}
