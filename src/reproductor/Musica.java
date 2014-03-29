package reproductor;

/**
 * Ejecucion de la musica
 * @author MurielPiojo
 *
 */
public class Musica {
	
    private Reproductor thread = new Reproductor();
    

    /**
     * Hace un set del fichero de musica default
     * @param direccion
     */
    @SuppressWarnings("unused")
	private void setURLFichero(String direccion){
    	
    	thread.setURLFicheroMusica(direccion);
    }
    
    /**
     * Ejecuta el fichero de musica mp3 localizado en ID
     * @param ID
     */
    public void startMusica(String ID) {
    	
    	thread.setURLFicheroMusica(ID);

        //Crea el THREAD del reproductor
        thread.start();

    }
}
