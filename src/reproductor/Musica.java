package reproductor;

/**
 * Ejecucion de la musica
 * @author Deekin III
 *
 */
public class Musica {
	
    private Reproductor thread = new Reproductor();
    

    /**
     * Hace un set del fichero de musica default
     * @param direccion
     */
    private void setURLFichero(String direccion){
    	
    	thread.setURLFicheroMusica(direccion);
    }
    
    /**
     * Ejecuta el fichero de musica mp3 localizado en la direccion introducida
     * @param direccion
     */
    public void startMusica(String direccion) {
    	
    	thread.setURLFicheroMusica(direccion);

        //Crea el THREAD del reproductor
        thread.start();

    }
}
