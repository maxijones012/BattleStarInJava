package sonido;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class uSonido {

	private static Clip cargarSonido(final String ruta){
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
	
	/**
	 * crea y reproduce un sonido con @param ruta
	 * @param ruta ejemplo de uso "/sonido/bomba.wav"
	 */
	public static void reproducir(final String ruta){
		Clip bang = cargarSonido(ruta);
		bang.start();
	}
	
}
