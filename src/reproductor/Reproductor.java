package reproductor;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Reproductor
 * @author MurielPiojo
 *
 */
public class Reproductor extends Thread{

	private String ficheroMusica = "./assets/audio/FearNotThisNight.mp3";

	@Override
	public void run(){

		FileInputStream fis;
		Player player;
		try {
			fis = new FileInputStream(
					this.ficheroMusica);

			BufferedInputStream bis = new BufferedInputStream(fis);

			player = new Player(bis);// Llamada a constructor de la clase Player
			player.play();          // Llamada al m�todo play
			player.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("El fichero de musica no se ha introducido correctamente: "+e.getMessage());
		}catch (JavaLayerException e) {
			e.printStackTrace();
			System.err.println("El fichero de musica esta dando problemas: "+e.getMessage());
		}
	}

	public void setURLFicheroMusica(String direccion){

		this.ficheroMusica = "./assets/audio/"+direccion+".mp3";
	}
}
