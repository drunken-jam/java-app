package controller;

import model.Game;
import view.MainView;


public class Drunken {
	private static final long INITIAL_SECONDS = 5;
	private static final long INITIAL_MINUTES = 1;
	private Chronos chrono;
	private MainView view;

	// al pulsar start en la ventana se llama a go()
	public void go() {
		chrono = new Chronos(INITIAL_SECONDS,INITIAL_MINUTES, this);
		chrono.init();
	}

	public static void main(String[] args) {
		new Drunken().start();
	}

	public void start() {
		view = new MainView(this);
	}

	public void stop(){
		chrono.stop();
		view.enable();
	}
	
	public void gameEvent(Game game) {
		view.setGameOnScreen(game.getAudio());
		view.disable();
	}
	
	public void endEvent() {
		view.putInitial();
		view.enable();
	}
}
