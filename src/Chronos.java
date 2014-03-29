import java.util.Timer;
import java.util.TimerTask;
import model.Game;


public class Chronos {

	private long period;  // segundos
	private static Timer timer = null;
	private Executor ejecutor;

	public Chronos(long p){
		this.period = p;
		ejecutor = new Executor();
	}

	private class Task extends TimerTask{
		@Override
		public void run(){
			System.out.println("sunea alarma");
			Game game = ejecutor.giveMeGame();
			System.out.println(game.getAudio());
			timer.cancel();
			ponerAlarma();
		}
	}

	public void ponerAlarma(){

		timer = new Timer();

		timer.schedule(new Task(), period*1000);
	}



}
