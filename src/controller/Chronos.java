package controller;
import java.util.Timer;
import java.util.TimerTask;
import model.Game;


public class Chronos {

	private long period;  // segundos
	private static Timer timer = null;
	private Executor ejecutor;
	private Drunken controller;

	public Chronos(long p, Drunken controller){
		this.period = p;
		ejecutor = new Executor();
		this.controller = controller;
	}

	private class Task extends TimerTask{
		@Override
		public void run(){
			Game game = ejecutor.giveMeGame();
			System.out.println(game.getAudio());
			controller.newGame(game);
			timer.cancel();
			ponerAlarmaGames();
		}
	}

	public void ponerAlarmaGames(){

		timer = new Timer();

		timer.schedule(new Task(), period*1000);
	}



}
