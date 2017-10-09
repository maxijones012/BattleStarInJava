package logicaJuego;

public class Pasadizo extends Estatico{
//	private pasadizo 
	
//	Constructor
	public Pasadizo(Posicion posicion, Tamanio tamanio, Escenario escenario) {
		super(posicion, tamanio, escenario);
	}

	@Override
	public void jugar() {
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContraPared() {
		// TODO Auto-generated method stub
		
	}

	
}
