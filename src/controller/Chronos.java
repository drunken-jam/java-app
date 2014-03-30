package controller;
import java.util.Timer;
import java.util.TimerTask;
import model.Game;


public class Chronos {

	private long period;  // segundos
	private long duration;  // minutos
	private static Timer gameTimer = null;
	private static Timer endTimer = null;
	private static long SECONDS=1000;
	private static long MINUTES=60;
	private Executor ejecutor;
	private Drunken controller;

	public Chronos(long p, long d, Drunken controller){
		this.period = p;
		this.duration = d;
		ejecutor = new Executor();
		this.controller = controller;
	}

	private class GameTask extends TimerTask {
		@Override
		public void run(){
			Game game = ejecutor.giveMeGame();
			System.out.println(game.getAudio());
			controller.gameEvent(game);
			gameTimer.cancel();
			ponerAlarmaGames();
		}
	}

	private class EndTask extends TimerTask{
		@Override
		public void run(){
			gameTimer.cancel();
			controller.endEvent();
		}
	}

	public void ponerAlarmaGames(){
		gameTimer = new Timer();
		gameTimer.schedule(new GameTask(), period*SECONDS);
	}

	public void ponerAlarmaEnd(){
		endTimer = new Timer();
		endTimer.schedule(new EndTask(), duration*SECONDS*MINUTES);
	}

	public void init(){
		ponerAlarmaEnd();
		ponerAlarmaGames();
	}

	public void stop(){
		gameTimer.cancel();
		endTimer.cancel();
	}

}
