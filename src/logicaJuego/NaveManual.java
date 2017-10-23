package logicaJuego;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import configuracion.ConfiguracionInicial;

public class NaveManual extends Nave{

	public NaveManual(Posicion posicion, Tamanio tamanio, AdministradorJuego administradorJuego) {
		super(posicion, tamanio, administradorJuego);
		
	}

	
	
	@Override
	public void jugar() {
 		if(this.getAdministradorJuego().getConfiguracionInicial().isDisMunicion()){			
			this.dispararMunicion(this);
			this.getAdministradorJuego().getConfiguracionInicial().setDisMunicion(false);
			String v = ("/sonido/laser.wav");
			Clip bang = cargarSonido(v);
			bang.start();
//			bang.stop();
		}
		if(this.getAdministradorJuego().getConfiguracionInicial().isDisBomba()){
			this.dispararBomba(this);
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
	public void elementosVistos(ArrayList<Elemento> elementos) {
	}

	@Override
	public void chocarContraPared() {
		this.girar(180);
		super.avanzar();
	}


	
	@Override
	public String toString() {
		return ("MANUAL");
	}
	
	
	public static Clip cargarSonido(final String ruta){
		Clip clip = null;
		try{
			InputStream is = ClassLoader.class .getResourceAsStream(ruta);
			AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
			DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(ais);
					
				
		}  catch (Exception e){
			e.printStackTrace();
		}
		return clip;
	}

}
